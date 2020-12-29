package project.Model.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nickname;
	private String password;
	private String email;
	private Date createdAt;
	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL
			)
	private List<Opinion> opinions = new ArrayList<>();
	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL
			)
	private List<Vote> votes= new ArrayList<>();
	
	

	
	
}
