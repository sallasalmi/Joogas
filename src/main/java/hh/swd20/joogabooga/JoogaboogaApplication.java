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
			
			jrepository.deleteAll();
			vrepository.deleteAll();
			arepository.deleteAll();
			urepository.deleteAll();
			
			
			urepository.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "user@quizapp.fi"));
			urepository.save(new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "admin@quizapp.fi"));
			
			
			log.info("save a couple of joogas");
			Review r1 = new Review("Hyvä"); 
			vrepository.save(r1);
			Review r2 = new Review("Rentouttava"); 
			vrepository.save(r2);
			Review r3 = new Review("Kehitettävää"); 
			vrepository.save(r3);
			
			jrepository.save(new Jooga("Hotjooga", "Puhdistava", "20min",r1));
			jrepository.save(new Jooga("Kundaliinijooga", "Syvää eskittymistä hengitykseen", "60min",r2));
			jrepository.save(new Jooga("Yinjooga", "Rentouttava", "30min",r3));
			
			arepository.save(new Asana("Vuoriasento", "Seiso suorassa kädet sivuilla ja anna painon levätä tasaisesti koko jalkapohjilla.", jrepository.findByName("Hotjooga").get(0)));
			arepository.save(new Asana("Alaspäin katsova koira", "Aloita konttausasennosta, levitä sormet ja juurruta kämmenet alustaa vasten."
					+ "Rauhallisesti hengittäen lähde nostamaan polvia hitaasti irti alustasta työntäen samalla lantiota ylös, kunnes jalat alkavat suoristua", jrepository.findByName("Hotjooga").get(0)));
			arepository.save(new Asana("Puuasento", "Nosta vasen jalka ja ota vasemmalla kädellä nilkasta kiinni."
					+ " Tarkoituksena on nostaa vasemman jalan jalkapohja tukijalan sisäsyrjää vasten, joko pohkeen korkeudelle tai aivan ylös reiden sisäsyrjää vasten oman tason mukaan.", jrepository.findByName("Kundaliinijooga").get(0)));
			arepository.save(new Asana("Kobra", "Makaa lattialla mahalteen ja aseta kämmenet lattiaa vasten rintakehän viereen. Ala nostamaan päätä ylöspäin rintakehää venyttäen.", jrepository.findByName("Kundaliinijooga").get(0)));
			arepository.save(new Asana("kolmio", "Aloita vuoriasennosta ja harppaa vasen jalka taakse. Laske oikea käsi lattiaan ja vasemmalla kädellä kurkoita kohti kattoa", jrepository.findByName("Yinjooga").get(0)));
			arepository.save(new Asana("Lapsen lepoasento", "Aloita konttausasennosta. Sen jäkeen työnnä lantiota kantapäitä kohti kunnes laskeudut niiden päälle."
					+ "Kurota kädet pitkälle pään yläpuolelle ja aseta kämmenet mattoa vasten.", jrepository.findByName("Yinjooga").get(0)));
			
			log.info("fetch all the joogas");
			for (Jooga jooga : jrepository.findAll()) {
				log.info(jooga.toString());
			}

		};
	}


}
