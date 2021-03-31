package project.Service;

import java.util.List;

import project.Model.Entity.User;
import project.Model.Entity.Whisky;

public interface WhiskyService {

	void save(Whisky whisky);
	
	Whisky findById(long id);
	
	List<Whisky> findWhiskyByName(String name);
	
	List<Whisky> findAllByType(String type);
	
	List<Whisky> findAllByTopOverallRanking();
	
	List<Whisky> findAllByMostReviewed();
	
	List<Whisky> findAllByAlphabeticalOrder();
	
	List<Whisky> findAll();
}
