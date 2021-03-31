package project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Model.Entity.Whisky;
import project.Model.Repository.WhiskyRepo;


@Service
public class WhiskyServiceImpl implements WhiskyService {

		@Autowired
		private WhiskyRepo whiskyRepo;
		
		@Override
		public Whisky findById(long id) {
			return whiskyRepo.getOne(id);
		}

		@Override
		public void save(Whisky whisky) {
			whiskyRepo.saveAndFlush(whisky);
		}

		@Override
		public List<Whisky> findWhiskyByName(String name) {
			
			return whiskyRepo.findByNameContainingIgnoreCase(name);
		}

		@Override
		public List<Whisky> findAllByType(String type) {
			return whiskyRepo.findAllByTypeIgnoreCase(type);
		}

		@Override
		public List<Whisky> findAllByTopOverallRanking() {
			return whiskyRepo.findAllByOrderByTopOverallRanking();
		}

		@Override
		public List<Whisky> findAllByMostReviewed() {

			return whiskyRepo.findAllByOrderByMostReviewed();
		}

		@Override
		public List<Whisky> findAllByAlphabeticalOrder() {
			return  whiskyRepo.findAllByOrderByNameAsc();
		}

		@Override
		public List<Whisky> findAll() {
			return whiskyRepo.findAll();	
		}
		
}
