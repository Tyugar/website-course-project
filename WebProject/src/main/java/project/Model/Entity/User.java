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
	
	
	public User() {
	}
	
	public User(String nickname, String password, String email, Date createdAt) {
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Opinion> getOpinions() {
		return opinions;
	}

	public void setOpinions(List<Opinion> opinions) {
		this.opinions = opinions;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", password=" + password + ", email=" + email
				+ ", createdAt=" + createdAt + ", opinions=" + opinions + ", votes=" + votes + "]";
	}
	
	
}
