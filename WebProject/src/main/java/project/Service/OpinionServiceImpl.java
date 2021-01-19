package project.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Model.Entity.Opinion;
import project.Model.Repository.OpinionRepo;

@Service
public class OpinionServiceImpl implements OpinionService{

	@Autowired
	OpinionRepo opinionRepo;
	
	@Override
	public Opinion findById(Long id) {
		return opinionRepo.getOne(id);
	}
	
	@Override
	public Boolean haveAlreadyReviewed(long whiskyId, long userId) {
		return opinionRepo.existsByWhiskyIdAndUserId(whiskyId, userId);
	}

}
