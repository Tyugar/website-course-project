package project.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.Model.Entity.Opinion;

@Repository
public interface OpinionRepo extends JpaRepository<Opinion, Long>{

}
