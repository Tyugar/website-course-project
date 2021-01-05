package project.Service;

import project.Model.Entity.User;

public interface UserService {
	
    void save(User user);

    User findByUsername(String username);
}

