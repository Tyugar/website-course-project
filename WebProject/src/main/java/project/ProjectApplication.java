package project;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import project.Model.Entity.Opinion;
import project.Model.Entity.User;
import project.Model.Entity.Vote;
import project.Model.Entity.Whisky;
import project.Model.Enum.VoteType;
import project.Model.Repository.OpinionRepo;
import project.Model.Repository.UserRepo;
import project.Model.Repository.WhiskyRepo;
import project.Service.UserService;
import project.Service.UserServiceImpl;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ProjectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ProjectApplication.class, args);
		
				ConfigurableApplicationContext confiurableApplicationContext = 
						SpringApplication.run(ProjectApplication.class, args);
				
				OpinionRepo opinionRepo= confiurableApplicationContext.getBean(OpinionRepo.class);
				UserService usseService = confiurableApplicationContext.getBean(UserService.class);
				WhiskyRepo whiskyRepo= confiurableApplicationContext.getBean(WhiskyRepo.class);
				Date date = new Date();
				User user1 = new User("marik1234", "1234", "test@wp.pl", date,"ROLE_USER");
				User user2 = new User("marianBaczal", "2137", "onet@gmail.com", date,"ROLE_USER");
				User user3 = new User("123", "123", "oneddt@gmail.com", date,"ROLE_USER");
				Whisky whisky = new Whisky("Golden losz", "jakisTyp", "Polska", 40, "bla bla bla blablablalbalbalbla");
				Whisky whisky1 = new Whisky("Jameson", "jakisInnyTyp", "Irlandia", 43, "aaaaaaaaaaaaaaaaaaa");
				Whisky whisky2 = new Whisky("Jack Daniels", "jakisInnyTyp", "USA", 40, "bbbbbbbbbbbbbbbbbbbbbbbbbbba");
				Whisky whisky3 = new Whisky("Jim Beam", "jakisTyp", "USA", 40, "ccccccccccccccccccccccc");
				Opinion opinion1 = new Opinion(date, 3, 2, 1, "co to za g***o, komu to smakuje, najgorsze co piłem. W życiu.", whisky, user1);
				Opinion opinion2 = new Opinion(date, 5, 5, 4, "najlepsze co pilem w zyciu!", whisky1, user2);
				Opinion opinion3 = new Opinion(date, 1, 2, 3, "Gdybym miał powiedzieć co cenię w życiu najbardziej - powiedziałbym, że ludzi, ludzi którzy podali mi pomocną dłoń kiedy sobie nie radziłem, kiedy byłem sam i co ciekawe to przypadkowe spotkania wpływają na nasze życie. Chodzi o to, że kiedy wyznaje się pewne wartości nawet z pozoru uniwersalne bywa że nie znajduje się zrozumienia, które by tak rzec, które pomaga się nam rozwijać. Ja miałem szczęście by tak rzec ponieważ je znalazłem i dziękuję życiu, dziękuję mu, życie to śpiew, życie to taniec, życie to miłość.\n" + 
						"\n" + 
						"Wielu ludzi pyta mnie o to samo \"ale jak ty to robisz, skąd czerpiesz tę radość\" a ja im odpowiadam, że to proste, to umiłowanie życia, to właśnie ono sprawia, że dzisiaj na przykład buduję maszyny a jutro kto wie dlaczego by nie oddam się pracy społecznej i będę ot choćby sadzić znaczy, marchew.", whisky2, user2);
				Opinion opinion4 = new Opinion(date, 3, 2, 1, "bardzo dobry trunek, nie powiem że nie.", whisky3, user2);
				Vote vote1 = new Vote(VoteType.LIKE, opinion1, user2);
				Vote vote2 = new Vote(VoteType.DISLIKE, opinion1, user3);
				Vote vote3 = new Vote(VoteType.DISLIKE, opinion1, user3);
				Vote vote4= new Vote(VoteType.DISLIKE, opinion1, user3);
				Opinion tempOpinion = new Opinion();
				whiskyRepo.save(whisky);
				whiskyRepo.save(whisky1);
				whiskyRepo.save(whisky2);
				whiskyRepo.save(whisky3);
				List<Opinion> opinions1 = Arrays.asList(opinion1);
				List<Opinion> opinions2 = Arrays.asList(opinion2,opinion3,opinion4);
				List<Vote> votes1= Arrays.asList(vote1);
				List<Vote> votes2= Arrays.asList(vote2,vote3,vote4);	
				user1.setOpinions(opinions1);
				user2.setVotes(votes1);
				user3.setVotes(votes2);
				user2.setOpinions(opinions2);
				usseService.save(user1);
				usseService.save(user2);
				usseService.save(user3);
				
				tempOpinion.setCreatedAt(date);
				tempOpinion.setFinish(5);
				tempOpinion.setSmell(5);
				tempOpinion.setTaste(5);
				tempOpinion.setUser(user1);
				tempOpinion.setText("LOREM IPSUMMMMMMMMMMMMMMM");
				tempOpinion.setWhisky(whisky3);
				whisky3.getOpinions().add(tempOpinion);
				whiskyRepo.save(whisky3);
			
	}
}
