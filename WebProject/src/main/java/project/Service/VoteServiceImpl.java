package project.Service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.Model.Entity.User;
import project.Model.Entity.Vote;
import project.Model.Enum.VoteType;
import project.Model.Repository.OpinionRepo;
import project.Model.Repository.VoteRepo;



@Service
public class VoteServiceImpl implements VoteService{
	
	@Autowired
	private  OpinionService opinionService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private VoteRepo voteRepo;
	
	@Autowired
	private OpinionRepo opinionRepo;
	
	
	@Override
	public int voteLike(Long opinionId, Principal principal) {
		

		User currentUser = userService.findByUsername(principal.getName());
		if(opinionRepo.existsByIdAndUserId(opinionId, currentUser.getId())) {
			return -2; //stands for voting on own opinions 
		}
		else {
			Vote vote = new Vote(VoteType.LIKE, opinionService.findById(opinionId),currentUser);
			userService.save(currentUser);
			return 1; //stands for votted like - just temp for example to test this shit
		}
		
	}





	

}
