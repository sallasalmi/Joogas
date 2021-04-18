package hh.swd20.joogabooga.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AsanaRepository extends CrudRepository<Asana, Long> {

    List<Asana> findByAsname(String asname);

}


