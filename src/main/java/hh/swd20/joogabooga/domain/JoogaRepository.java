package hh.swd20.joogabooga.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JoogaRepository extends CrudRepository<Jooga, Long> {
	List<Jooga> findByName(String name);
}
