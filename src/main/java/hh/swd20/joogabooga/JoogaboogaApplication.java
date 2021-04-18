package hh.swd20.joogabooga;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import hh.swd20.joogabooga.domain.Asana;
import hh.swd20.joogabooga.domain.AsanaRepository;
import hh.swd20.joogabooga.domain.Jooga;
import hh.swd20.joogabooga.domain.JoogaRepository;
import hh.swd20.joogabooga.domain.Review;
import hh.swd20.joogabooga.domain.ReviewRepository;
import hh.swd20.joogabooga.domain.User;
import hh.swd20.joogabooga.domain.UserRepository;

@SpringBootApplication
public class JoogaboogaApplication {


	private static final Logger log = LoggerFactory.getLogger(JoogaboogaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JoogaboogaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo (
			JoogaRepository jrepository, 
			ReviewRepository vrepository, 
			AsanaRepository arepository, 
			UserRepository urepository ) {
		
		return (args) -> {
			
			urepository.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "user@quizapp.fi"));
			urepository.save(new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "admin@quizapp.fi"));
			
			
			log.info("save a couple of joogas");
			Review r1 = new Review("Hyvä"); 
			vrepository.save(r1);
			Review r2 = new Review("Rentouttava"); 
			vrepository.save(r2);
			Review r3 = new Review("Urheilullinen"); 
			vrepository.save(r3);
			
			jrepository.save(new Jooga("Hotjooga", "Kuumaa", "20min",r1));
			jrepository.save(new Jooga("Kundaliinijooga", "Keskittymistä hengitykseen ja hauskoja ääniä", "60min",r2));
			jrepository.save(new Jooga("Yinjooga", "Oikein mukavaa", "30min",r3));
			
			arepository.save(new Asana("Venyttelevä koira", "Venyttele kuin koira", jrepository.findByName("Hotjooga").get(0)));
			arepository.save(new Asana("aurinko", "Venyttele kuin koira", jrepository.findByName("Kundaliinijooga").get(0)));
			arepository.save(new Asana("kuu", "Venyttele kuin koira", jrepository.findByName("Yinjooga").get(0)));
			
			log.info("fetch all the joogas");
			for (Jooga jooga : jrepository.findAll()) {
				log.info(jooga.toString());
			}

		};
	}


}
