package hh.swd20.joogabooga.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Jooga {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private String time;
	
	@ManyToOne
	 @JoinColumn(name = "reviewid")
	 private Review review;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="jooga")
	private List<Asana> asanas;
	
	public Jooga() {}
	
	public Jooga(String name, String description, String time, Review review) {
		super();
		this.name = name;
		this.description = description;
		this.time = time;
		this.review = review;
	}
	
	
	public List<Asana> getAsanas() {
		return asanas;
	}

	public void setAsanas(List<Asana> asanas) {
		this.asanas = asanas;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Jooga [name=" + name + ", description=" + description + ", time=" + time + "]";
	}

}
