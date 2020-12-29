/*
package project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import Model.Entity.User;
import Model.Repository.UserRepo;

@Component
public class Start {
	
		private UserRepo userRepo;
		
		@Autowired
		public Start(UserRepo userRepo) {
			this.userRepo = userRepo;
		}
		
		@EventListener(ApplicationReadyEvent.class)
		public void runExample() {
			User user = new User("tyugar", "123", "halo@gamil.com");
			userRepo.save(user);
			
		}

}
*/