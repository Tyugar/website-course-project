package Model.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import Model.Entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{

}
