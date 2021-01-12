package project.Service;

import java.security.Principal;

public interface VoteService {


	int voteLike(Long opinionId, Principal principal);

}
