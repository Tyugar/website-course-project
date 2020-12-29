package project.Model.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Whisky")
public class Whisky {

		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String type;
	private String countryOfOrigin;
	private Long alcoholVolume;
	private String description;
	@OneToMany(
			mappedBy = "whisky",
			cascade = CascadeType.ALL
			)
	private List<Opinion> opinions = new ArrayList<>();
	
	public Whisky() {
	}
	
	public Whisky(String name, String type, String countryOfOrigin, Long alcoholVolume, String description) {
		this.name = name;
		this.type = type;
		this.countryOfOrigin = countryOfOrigin;
		this.alcoholVolume = alcoholVolume;
		this.description = description;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public Long getAlcoholVolume() {
		return alcoholVolume;
	}

	public void setAlcoholVolume(Long alcoholVolume) {
		this.alcoholVolume = alcoholVolume;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Opinion> getOpinions() {
		return opinions;
	}

	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
	}

	@Override
	public String toString() {
		return "Whisky [id=" + id + ", name=" + name + ", type=" + type + ", countryOfOrigin=" + countryOfOrigin
				+ ", alcoholVolume=" + alcoholVolume + ", description=" + description + ", opinions=" + opinions + "]";
	}
	
	
	
		
}
