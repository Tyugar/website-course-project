package project.Model.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.Model.Entity.Opinion;

@Repository
public interface OpinionRepo extends JpaRepository<Opinion, Long>{

	boolean existsByIdAndUserId(long id, long userId);
	
	boolean existsByWhiskyIdAndUserId(long whiskyId, long userId);
	
}
