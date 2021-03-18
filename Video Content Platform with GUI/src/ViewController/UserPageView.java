package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import File.JSON;
import Model.User;
import Model.Video;

public class UserPageView extends JFrame{
	private static JButton watchListButton=new JButton("Create Watch List");
	private static JButton viewWatchListButton=new JButton("All Watch List");
	private static JButton allVideosButton=new JButton("All Videos");
	private static JButton followedUsersButton=new JButton("Followed Users");
	private static JButton followersButton=new JButton("Followers");
	private static JButton allUsersButton=new JButton("All Users");
	private User user;
	private List<Video> videos;
	private List<User> users;
	private JSON json;
	
	JFrame frame= new JFrame("Userpage");
	JPanel content = new JPanel();
	
	UserPageView(List<User> users,List<Video> videos,User user,JSON json){
		
		this.users=users;
		this.user=user;
		this.videos=videos;
		this.json=json;
		frame.setSize(400,400);
		
		frame.add(content);
		content.setLayout(null);
		
		watchListButton.setBounds(80, 50, 200, 25);
		content.add(watchListButton);

		viewWatchListButton.setBounds(80, 100, 200, 25);
		content.add(viewWatchListButton);
		
		allVideosButton.setBounds(80, 150, 200, 25);
		content.add(allVideosButton);
		
		followedUsersButton.setBounds(80, 200, 200, 25);
		content.add(followedUsersButton);
		
		followersButton.setBounds(80, 250, 200, 25);
		content.add(followersButton);
		
		allUsersButton.setBounds(80, 300, 200, 25);
		content.add(allUsersButton);
		
		watchListButton.addActionListener(new WatchListListener());
		viewWatchListButton.addActionListener(new ViewWatchListListener());
		allVideosButton.addActionListener(new AllVideosListener());
		followedUsersButton.addActionListener(new FollowedUsersListener());
		followersButton.addActionListener(new FollowersListener());
		allUsersButton.addActionListener(new AllUsersListener());
		
        this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	class WatchListListener implements ActionListener {//if the user clicks Create Watch List button, Create Watch List view is opened.
	    public void actionPerformed(ActionEvent e) {
			CreateWatchListView createList= new CreateWatchListView(users,user);	
	    }
	}
	class ViewWatchListListener implements ActionListener {//if the user clicks All Watch List button, All Watch List view is opened.
	    public void actionPerformed(ActionEvent e) {
			AllWatchListView allList=new AllWatchListView(user,json);
	    }
	}
	class AllVideosListener implements ActionListener {//if the user clicks All Videos button, All Videos view is opened.
	    public void actionPerformed(ActionEvent e) {
	    	AllVideosView allvideos=new AllVideosView(user, videos,users,json);	
	    }
	}
	class FollowedUsersListener implements ActionListener {//if the user clicks Followed Users button, Followed Users view is opened.
	    public void actionPerformed(ActionEvent e) {
			FollowedUserView followed=new FollowedUserView(users,user,json);
			user.addObserver(followed);
	    }
	}
	class FollowersListener implements ActionListener {//if the user clicks Followers button, Followers view is opened.
	    public void actionPerformed(ActionEvent e) {
			FollowerView follower=new FollowerView(users,user,json);
			user.addObserver(follower);
	    }
	}
	class AllUsersListener implements ActionListener {//if the user clicks All Users button, All Users view is opened.
	    public void actionPerformed(ActionEvent e) {
	    	AllUsersView allusers=new AllUsersView(users, user);
	    }
	}
}

