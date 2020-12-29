package project.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.Model.Entity.Vote;

@Repository
public interface VoteRepo extends JpaRepository<Vote, Long> {

}
