package project.Model.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import project.Model.Enum.VoteType;

@Entity
@Table(name = "Vote")
public class Vote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private VoteType voteType;
	@ManyToOne
	@JoinColumn(name = "vote_id")
	private Opinion opinion;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	
	

}
