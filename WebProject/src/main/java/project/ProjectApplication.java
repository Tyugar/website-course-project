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
import project.Model.Repository.UserRepo;
import project.Model.Repository.WhiskyRepo;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ProjectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ProjectApplication.class, args);
		
				ConfigurableApplicationContext confiurableApplicationContext = 
						SpringApplication.run(ProjectApplication.class, args);
				UserRepo userRepo = confiurableApplicationContext.getBean(UserRepo.class);
				WhiskyRepo whiskyRepo= confiurableApplicationContext.getBean(WhiskyRepo.class);
				Date date = new Date();
				User user1 = new User("marik1234", "1234", "dupa@wp.pl", date);
				User user2 = new User("marianBaczal", "2137", "onet@gmail.com", date);
				Whisky whisky = new Whisky("Golden losz", "jakieSaTypyXD", "Polska", 40, "bla bla bla blablablalbalbalbla");
				Opinion opinion1 = new Opinion(date, 3, 2, 1, "to jest berbelucha a nie whyski", whisky, user1);
				Opinion opinion2 = new Opinion(date, 5, 5, 4, "najlepsze co pilem w zyciu!!!", whisky, user2);
				Vote vote = new Vote(VoteType.LIKE, opinion1, user2);
				whiskyRepo.save(whisky);
				List<Opinion> opinions1 = Arrays.asList(opinion1);
				List<Opinion> opinions2 = Arrays.asList(opinion2);
				List<Vote> votes= Arrays.asList(vote);				
				user1.setOpinions(opinions1);
				user2.setVotes(votes);
				user2.setOpinions(opinions2);
				userRepo.save(user1);
				userRepo.save(user2);
			
	}
}
