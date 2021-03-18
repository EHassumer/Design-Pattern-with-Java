package Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class User extends Observable {
	private String name;
	private String password;
	private List<WatchList> watchList; // the list of watch list that is belong to user 
	private List<User> following; // the list of users that is followed by this user
	private List<User> followers; // the list of users that follow this user
	
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
		this.watchList = new ArrayList<WatchList>();
		this.following = new ArrayList<User>();
		this.followers = new ArrayList<User>();
	}
    
    
    public User(String name) {
        this.name = name;
        this.watchList = new ArrayList<WatchList>();
        this.following = new ArrayList<User>();
        this.followers = new ArrayList<User>();
    }


    public User() {
        
        this.watchList = new ArrayList<WatchList>();
        this.following = new ArrayList<User>();
        this.followers = new ArrayList<User>();
    }
    
	public User(User user) {
	        this.name = user.getName();
	        this.password = user.getPassword();
	        this.watchList = user.getWatchList();
	        this.following = new ArrayList<User>();
	        this.followers = new ArrayList<User>();
	        if(!user.getFollowing().isEmpty()) {
	            for(User i: user.getFollowers()) {
	                
	                following.add(i);
	            }
	        }
	        if(!user.getFollowers().isEmpty()) {
	            for(User i: user.getFollowers()) {
	                
	                followers.add(i);
	            }
	        }
	        
	    }
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}
	public List<WatchList> getWatchList() {
		return watchList;
	}

	public List<User> getFollowing() {
		return following;
	}

	public List<User> getFollowers() {
		return followers;
	}

	public void setName(String name) {
		setChanged();
		notifyObservers();
		this.name = name;
	}

	public void setPassword(String password) {
		setChanged();
		notifyObservers();
		this.password = password;
	}

	public void setWatchList(List<WatchList> watchList) {
		setChanged();
		notifyObservers();
		this.watchList = watchList;
	}

	public void setFollowing(List<User> following) {
		setChanged();
		notifyObservers();
		this.following = following;
	}

	public void setFollowers(List<User> followers) {
		setChanged();
		notifyObservers();
		this.followers = followers;
	}
	


}
