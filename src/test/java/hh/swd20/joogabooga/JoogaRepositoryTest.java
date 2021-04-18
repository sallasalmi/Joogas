package hh.swd20.joogabooga;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.joogabooga.domain.Jooga;
import hh.swd20.joogabooga.domain.JoogaRepository;

@ExtendWith(SpringExtension.class) 
@DataJpaTest
public class JoogaRepositoryTest {
	
	@Autowired
    private JoogaRepository jrepository;

    @Test
    public void findByNameShouldReturnJooga() {
        List<Jooga> joogas = jrepository.findByName("Hotjooga");
        
        assertThat(joogas).hasSize(1);
        assertThat(joogas.get(0).getName()).isEqualTo("Hotjooga");
    }
    
    @Test 
    public void createNewJooga() {
    	Jooga jooga = new Jooga("Rentouttava jooga", "Rauhallista", "20min", null);
    	jrepository.save(jooga);
    	assertThat(jooga.getId()).isNotNull();
    }

}
