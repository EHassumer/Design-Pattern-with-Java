package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import File.JSON;
import Model.User;
import Service.UserService;

public class FollowerView extends JFrame implements Observer {
	 private static JTextField usernameTitle;
	    private static JButton followButton;
	    private static JButton viewWatchListButton;
	    private User user;
	    private List<User> users;
	    private JSON json;
	    
	    JFrame frame = new JFrame("Followers");
	    JPanel content = new JPanel();
	    
	    public void update(Observable o, Object data) {
			 user=(User)o;
			 content.removeAll();
	         content.revalidate();
	         content.repaint();
	         createContent();	
		 }
	    
	    FollowerView(List<User> users,User user,JSON json) {
	        this.user = user;
	        this.users = users;
	        this.json=json;
	        
	        frame.setSize(600, 300);

	        frame.add(content);
	        content.setLayout(null);
	        
	        createContent();

	        this.pack();
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocation(300, 300);
	        frame.setVisible(true);
	    }

	    public void createContent() {
	        for (int i = 0; i < user.getFollowers().size(); i++) {
	            usernameTitle = new JTextField(user.getFollowers().get(i).getName());
	            usernameTitle.setBounds(10, (10 + i * 50), 150, 25);
	            usernameTitle.setEditable(false);
	            content.add(usernameTitle);

	            followButton = new JButton("Follow");
	            followButton.setBounds(200, (10 + i * 50), 150, 25);
	            content.add(followButton);
	            
	            viewWatchListButton = new JButton("Watchlist");
	            viewWatchListButton.setBounds(350, (10 + i * 50), 150, 25);
	            content.add(viewWatchListButton);

	            followButton.addActionListener(new FollowListener(user.getFollowers().get(i), usernameTitle, followButton));
	            viewWatchListButton.addActionListener(new ViewWatchListListener(user.getFollowers().get(i)));

	        }
	    }
	    
	    class FollowListener implements ActionListener {// if the user clicks follow button, this user that is chosen is added in to following list.
	        User followed;
	        JTextField videoTitle;
	        JButton removeButton;
	        public FollowListener(User followed, JTextField usernameTitle, JButton unfollowButton) {
	            this.followed = followed;
	            this.videoTitle = videoTitle;
	            this.removeButton = removeButton;
	        }
	        public void actionPerformed(ActionEvent e) {
	            UserService us= new UserService();
	            try {
					us.follow(user, followed,users);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	          
	        }
	    }
	    class ViewWatchListListener implements ActionListener { // if the user clicks the watchlist button, user can see all watch list of other user that follower of user.
	        User following;
	        public ViewWatchListListener(User unfollowing) {
	            this.following = unfollowing;	          
	        }
	        public void actionPerformed(ActionEvent e) {
		           FollowingWatchListView list=new FollowingWatchListView(following,json);
	        }
	    }
}
