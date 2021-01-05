package project.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.Model.Entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
