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
import javax.persistence.Transient;

import project.Model.Enum.VoteType;

@Entity
@Table(name = "Opinion")
public class Opinion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date createdAt;
	private int Smell;
	private int Taste;
	private int Finish;
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
	
	@Transient
	private Long voteResult;

	
	public Opinion() {
	}
	
	public Opinion(Date createdAt, int i, int j, int k, String text, Whisky whisky,
			 User user) {
		this.createdAt = createdAt;
		Smell = i;
		Taste = j;
		Finish = k;
		this.text = text;
		this.whisky = whisky;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getSmell() {
		return Smell;
	}

	public void setSmell(int smell) {
		Smell = smell;
	}

	public int getTaste() {
		return Taste;
	}

	public void setTaste(int taste) {
		Taste = taste;
	}

	public int getFinish() {
		return Finish;
	}

	public void setFinish(int finish) {
		Finish = finish;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Whisky getWhisky() {
		return whisky;
	}

	public void setWhisky(Whisky whisky) {
		this.whisky = whisky;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getVoteResult() {
		
		voteResult = this.votes.stream().filter(c -> c.getVoteType() == VoteType.LIKE).count() 
				-this.votes.stream().filter(c -> c.getVoteType() == VoteType.DISLIKE).count();
	
		return voteResult;
	}

	public void setVoteResult(Long voteResult) {
		this.voteResult = voteResult;
	}
	



	@Override
	public String toString() {
		return "Opinion [id=" + id + ", createdAt=" + createdAt + ", Smell=" + Smell + ", Taste=" + Taste + ", Finish="
				+ Finish + ", text=" + text + ", whisky=" + whisky + ", votes=" + votes + ", user=" + user + "]";
	}
	
	
	
	
	
	

}
