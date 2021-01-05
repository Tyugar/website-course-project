package project.Service;

public interface SecurityService {
	
	boolean isAuthenticated();
	
	void autoLogin(String username, String password);

}
