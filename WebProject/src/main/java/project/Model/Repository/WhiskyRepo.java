package project.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.Model.Entity.Whisky;

@Repository
public interface WhiskyRepo extends JpaRepository<Whisky, Long>{

}
