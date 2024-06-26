package hh.swd20.joogabooga.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.joogabooga.domain.Asana;
import hh.swd20.joogabooga.domain.AsanaRepository;
import hh.swd20.joogabooga.domain.Jooga;
import hh.swd20.joogabooga.domain.JoogaRepository;
import hh.swd20.joogabooga.domain.ReviewRepository;

@Controller
public class JoogaController {
	
	@Autowired
	private ReviewRepository vrepository;

	@Autowired
	private JoogaRepository jrepository;
	
	@Autowired
	private AsanaRepository arepository;
	
	// Hakee kaikki joogat
	@RequestMapping(value = {"/","/joogalist"}) 
	public String joogaList(Model model) { 
		model.addAttribute("joogas", jrepository.findAll());
		return "joogalist";
	}
	
	// Lisää uuden joogan
	@RequestMapping(value = "/new")
	public String newjooga(Model model){
		model.addAttribute("jooga", new Jooga());
		model.addAttribute("reviews", vrepository.findAll());
		return "newjooga";
	}
	
	// Tallentaa uuden joogan
	@RequestMapping(value = "/savejooga", method = RequestMethod.POST)
	public String save(Jooga jooga, Asana asana){
		jrepository.save(jooga);
		arepository.save(asana);
		return "redirect:joogalist";
	}
//	
	// Hakee kaikki tiettyyn joogaan kuuluvat asanat
	@RequestMapping("/asanas/{id}")
	public String asanas(@PathVariable("id") Long id, Model model) {
		model.addAttribute("jooga", jrepository.findById(id));
		model.addAttribute("asanas", arepository.findAll());
		return "asanas";
	}
//	
	@RequestMapping(value = "/deleteasana/{id}", method = RequestMethod.GET)
	public String deleteAsana(@PathVariable("id") Long asanaid, Model model) {
		arepository.deleteById(asanaid);
		return "redirect:../joogalist";
	}
//	
//	
	// Lisää uuden asanan
	@RequestMapping(value="/newasana")
	public String addasana( Model model){
		model.addAttribute("asana", new Asana());
		model.addAttribute("joogas", jrepository.findAll());
		return "newasana";
	}
//	
	// Tallentaa uuden asanan
	@RequestMapping(value = "/saveasana", method = RequestMethod.POST)
	public String saveasana(Asana asana){
		arepository.save(asana);
		return "redirect:joogalist";
	}
	
	// Poistaa joogan
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteJooga(@PathVariable("id") Long id, Model model) {
		jrepository.deleteById(id);
		return "redirect:../joogalist";
	}
	
	// Muokkaa tiettyä joogaa
	@RequestMapping(value= "/edit/{id}")
	public String editJooga(@PathVariable("id") Long id, Model model) {
		model.addAttribute("jooga", jrepository.findById(id));
		model.addAttribute("reviews", vrepository.findAll());
		
		return "editjooga";
	}
	
	// kaikki asanat
	@CrossOrigin
	@GetMapping(value = "/api/asanas")
	public @ResponseBody List<Asana> getAllAsanas() {
		return (List<Asana>) arepository.findAll();
	}
	

	// RESTful kaikki joogat
	@CrossOrigin
	@GetMapping(value = "/api/joogas")
	public @ResponseBody List<Jooga> joogaListRest() {
		return (List<Jooga>) jrepository.findAll();
	}

	// RESTful jooga id:n mukaan
	@CrossOrigin
	@GetMapping(value = "/api/jooga/{id}")
	public @ResponseBody Optional<Jooga> findJoogaRest(@PathVariable("id") Long id) {
		return jrepository.findById(id);
	}

	// Restful asanat id:n mukaan
	@CrossOrigin
	@GetMapping(value = "/api/asana/{id}")
	public @ResponseBody Optional<Asana> asanaRest(@PathVariable("id") Long id) {
		return arepository.findById(id);
	}

}
