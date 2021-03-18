package Service;
import java.util.List;

import Model.User;

public class LoginService {
	
	public User login(List<User> users,String username, String password) {
		User result=null;
		for(User i: users) {
			if(username.trim().equals(i.getName()) && password.trim().equals(i.getPassword())) {
				result=i;
			}
		}
		return result; // if login is successful, it returns this user. If it is not, it returns null.
	}
}
