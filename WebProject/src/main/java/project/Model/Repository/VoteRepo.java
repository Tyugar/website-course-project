package project.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.Model.Entity.Vote;

@Repository
public interface VoteRepo extends JpaRepository<Vote, Long> {

	
	boolean existsByOpinionIdAndUserId(long opinion_id, long user_id);
	
	Vote findByOpinionIdAndUserId(long opinion_id, long user_id);
	
}
