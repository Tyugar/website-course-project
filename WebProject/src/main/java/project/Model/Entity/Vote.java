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
	
	public Vote() {
		
	}
	
	public Vote(Long id, VoteType voteType, Opinion opinion, User user) {
		this.id = id;
		this.voteType = voteType;
		this.opinion = opinion;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VoteType getVoteType() {
		return voteType;
	}

	public void setVoteType(VoteType voteType) {
		this.voteType = voteType;
	}

	public Opinion getOpinion() {
		return opinion;
	}

	public void setOpinion(Opinion opinion) {
		this.opinion = opinion;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Vote [id=" + id + ", voteType=" + voteType + ", opinion=" + opinion + ", user=" + user + "]";
	}

	
	

}
