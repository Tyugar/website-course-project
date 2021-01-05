package project.Service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import project.Model.Entity.User;
import project.Model.Repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    
	@Override
	public void save(User user) {
		
		Date date = new Date();
		user.setCreatedAt(date);
		user.setRole("ROLE_USER");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepo.saveAndFlush(user);
		
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

}
