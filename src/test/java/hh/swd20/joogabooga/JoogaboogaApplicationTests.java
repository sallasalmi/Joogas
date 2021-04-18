package hh.swd20.joogabooga;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.swd20.joogabooga.web.JoogaController;

@ExtendWith(SpringExtension.class)  
@SpringBootTest
class JoogaboogaApplicationTests {

	@Autowired
	private JoogaController joogaController;
	
	@Test
	void contextLoads() {
		assertThat(joogaController).isNotNull();
	}

}
