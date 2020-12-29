package project.Model.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Opinion")
public class Opinion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date createdAt;
	private Long Smell;
	private Long Taste;
	private Long Finish;
	private String text;
	@ManyToOne
	@JoinColumn(name = "whisky_id")
	private Whisky whisky;
	@OneToMany(
			mappedBy = "opinion",
			cascade = CascadeType.ALL
			)
	private List<Vote> votes = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	
	
	
	

}
