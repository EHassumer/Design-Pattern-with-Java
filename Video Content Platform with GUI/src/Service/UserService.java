package Service;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import File.ReadJSON;
import File.XMLReader;
import File.XMLWriter;
import Model.User;
import Model.Video;
import Model.WatchList;

public class UserService {
	private List<User> temporary;
	private List<WatchList> temporaryWatch;
	private XMLWriter xmlWrite = new XMLWriter();

	public void follow(User user, User otherUser, List<User> users) throws Exception {
		boolean result = true;
		for (int i = 0; i < user.getFollowing().size(); i++) { // If the user is already following the other user,
																// nothing is done.
			if (user.getFollowing().get(i).getName().equals(otherUser.getName())) {
				result = false;
			}
		}
		if (result) {
			temporary = user.getFollowing();
			temporary.add(otherUser);
			user.setFollowing(temporary);
		
			boolean add=true;
			for (int i = 0; i < otherUser.getFollowers().size(); i++) {
				if(otherUser.getFollowers().get(i).getName().equals(user.getName())) {
					add=false;
				}
			}
			if(add) {
				temporary=otherUser.getFollowers();
				temporary.add(user);
				otherUser.setFollowers(temporary);
			}
		}
			xmlWrite.saveUser(users);
		
	}

	public void unfollow(User user, User otherUser,List<User> users) throws Exception {// user unfollow the other user
		temporary = user.getFollowing();
		temporary.remove(otherUser);
		user.setFollowing(temporary);
		temporary=otherUser.getFollowers();
		temporary.remove(user);
		otherUser.setFollowers(temporary);
		xmlWrite.saveUser(users);
	}

	public void createWatchList(User user, String name,List<User> users) throws Exception {
		boolean result = true;
		for (int i = 0; i < user.getWatchList().size(); i++) {
			if (user.getWatchList().get(i).getName().equals(name)) // If a list already exists with the same name , it
																	// will not add.
				result = false;
		}
		if (result) {
			WatchList watchlist = new WatchList(name);
			temporaryWatch = user.getWatchList();
			temporaryWatch.add(watchlist);
			user.setWatchList(temporaryWatch);
			xmlWrite.saveUser(users);

		}

	}

}
