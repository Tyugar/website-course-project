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
import javax.persistence.Transient;

@Entity
@Table(name = "Whisky")
public class Whisky {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String type;
	private String countryOfOrigin;
	private int alcoholVolume;
	private String description;
	@OneToMany(
			mappedBy = "whisky",
			cascade = CascadeType.ALL
			)
	private List<Opinion> opinions = new ArrayList<>();
	
	@Transient
	private Double averageRate; 
	@Transient
	private Double averageSmell; 
	@Transient
	private Double averageTaste;
	@Transient
	private Double averageFinish; 
	


	public Whisky() {
		
	}
	
	public Whisky(String name, String type, String countryOfOrigin, int i, String description) {
		this.name = name;
		this.type = type;
		this.countryOfOrigin = countryOfOrigin;
		this.alcoholVolume = i;
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

	public int getAlcoholVolume() {
		return alcoholVolume;
	}

	public void setAlcoholVolume(int alcoholVolume) {
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

	public double getAverageRate() {
		if(!this.opinions.isEmpty()){
			averageRate=(getAverageSmell()+getAverageTaste()+getAverageFinish())/3;
			return averageRate;
			}
		return -1; //zrobic w thymeleafie case ktory sprawdzi jesli -1 to napisze ze ni ma 
	}

	public void setAverageRate(Double averageRate) {
		this.averageRate = averageRate;
	}

	public double getAverageSmell() {
		if(!this.opinions.isEmpty()){
			averageSmell = this.opinions.stream().mapToDouble(c->c.getSmell()).sum()/opinions.size();
			return averageSmell;
		}
		return -1;
	}

	public void setAverageSmell(Double averageSmell) {
		this.averageSmell = averageSmell;
	}

	public double getAverageTaste() {
		if(!this.opinions.isEmpty()){
			averageTaste = this.opinions.stream().mapToDouble(c->c.getTaste()).sum()/opinions.size();
			return averageTaste;
		}
		return -1;
	}

	public void setAverageTaste(Double averageTaste) {
		this.averageTaste = averageTaste;
	}

	public double getAverageFinish() {
		if(!this.opinions.isEmpty()){
			averageFinish = this.opinions.stream().mapToDouble(c->c.getFinish()).sum()/opinions.size();
			return averageFinish;
		}
		return -1;
	}

	public void setAverageFinish(Double averageFinish) {
		
		this.averageFinish = averageFinish;
	}

	@Override
	public String toString() {
		return "Whisky [id=" + id + ", name=" + name + ", type=" + type + ", countryOfOrigin=" + countryOfOrigin
				+ ", alcoholVolume=" + alcoholVolume + ", description=" + description + ", opinions=" + opinions + "]";
	}
	
	
	
		
}
