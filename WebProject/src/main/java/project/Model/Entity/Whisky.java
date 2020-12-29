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
	
	
	
		
}
