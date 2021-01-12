package project.Model.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.Model.Entity.Whisky;

@Repository
public interface WhiskyRepo extends JpaRepository<Whisky, Long>{

	List<Whisky> findByNameContainingIgnoreCase(String search);

}
