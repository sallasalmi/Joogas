package hh.swd20.joogabooga.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Asana {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long asanaid;
    private String asname;
    private String adescription;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id")
    private Jooga jooga;

	public Asana(String asname, String adescription, Jooga jooga) {
		super();
		this.asname = asname;
		this.adescription = adescription;
		this.jooga = jooga;
	}

	public Asana() {}
	
	public Long getAsanaid() {
		return asanaid;
	}

	public void setAsanaid(Long asanaid) {
		this.asanaid = asanaid;
	}

	public String getAsname() {
		return asname;
	}

	public void setAsname(String asname) {
		this.asname = asname;
	}

	public String getAdescription() {
		return adescription;
	}

	public void setAdescription(String adescription) {
		this.adescription = adescription;
	}

	public Jooga getJooga() {
		return jooga;
	}

	public void setJooga(Jooga jooga) {
		this.jooga = jooga;
	}

	@Override
	public String toString() {
		return "Asana [asname=" + asname + ", adescription=" + adescription + ", jooga=" + jooga + "]";
	}

    
}


