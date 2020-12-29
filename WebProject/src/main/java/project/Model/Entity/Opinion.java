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
	
	public Opinion() {
	}
	
	public Opinion(Long id, Date createdAt, Long smell, Long taste, Long finish, String text, Whisky whisky,
			List<Vote> votes, User user) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		Smell = smell;
		Taste = taste;
		Finish = finish;
		this.text = text;
		this.whisky = whisky;
		this.votes = votes;
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

	public Long getSmell() {
		return Smell;
	}

	public void setSmell(Long smell) {
		Smell = smell;
	}

	public Long getTaste() {
		return Taste;
	}

	public void setTaste(Long taste) {
		Taste = taste;
	}

	public Long getFinish() {
		return Finish;
	}

	public void setFinish(Long finish) {
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

	
	@Override
	public String toString() {
		return "Opinion [id=" + id + ", createdAt=" + createdAt + ", Smell=" + Smell + ", Taste=" + Taste + ", Finish="
				+ Finish + ", text=" + text + ", whisky=" + whisky + ", votes=" + votes + ", user=" + user + "]";
	}
	
	
	
	
	
	

}
