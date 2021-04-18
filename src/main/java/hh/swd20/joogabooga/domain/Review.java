package hh.swd20.joogabooga.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Review {

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "review")
	private List<Jooga> joogas;
	
	public List<Jooga> getJoogas() {
		return joogas;
	}

	public void setJoogas(List<Jooga> joogas) {
		this.joogas = joogas;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long reviewid;
	private String name;
	
	public Review() {}
	
	public Review(String name) {
		super();
		this.name = name;
	}
	public Long getReviewid() {
		return reviewid;
	}
	public void setReviewid(Long reviewid) {
		this.reviewid = reviewid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Review [reviewid=" + reviewid + ", name=" + name + "]";
	}
	
}
