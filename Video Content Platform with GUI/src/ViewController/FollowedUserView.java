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

public class FollowedUserView extends JFrame implements Observer{
	 private static JTextField usernameTitle;
	    private static JButton unfollowButton;
	    private static JButton viewWatchListButton;
	    private User user;
	    private List<User> users;
	    private JSON json;
	    
	    JFrame frame = new JFrame("Followed User");
	    JPanel content = new JPanel();
	    public void update(Observable o, Object data) {
			 user=(User)o;
			 content.removeAll();
	         content.revalidate();
	         content.repaint();
	         createContent();
			
		 }
	    FollowedUserView(List<User> users,User user,JSON json) {
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
	        for (int i = 0; i < user.getFollowing().size(); i++) {
	            usernameTitle = new JTextField(user.getFollowing().get(i).getName());
	            usernameTitle.setBounds(10, (10 + i * 50), 150, 25);
	            usernameTitle.setEditable(false);
	            content.add(usernameTitle);


	            unfollowButton = new JButton("Unfollow");
	            unfollowButton.setBounds(200, (10 + i * 50), 150, 25);
	            content.add(unfollowButton);
	            
	            viewWatchListButton = new JButton("Watchlist");
	            viewWatchListButton.setBounds(350, (10 + i * 50), 150, 25);
	            content.add(viewWatchListButton);



	            unfollowButton.addActionListener(new UnfollowListener(user.getFollowing().get(i)));
	            viewWatchListButton.addActionListener(new ViewWatchListListener(user.getFollowing().get(i)));

	        }
	    }


	    class UnfollowListener implements ActionListener { //if the user clicks unfollow button, the user that is chosen removes from following list.
	        User unfollowed;
	        public UnfollowListener(User unfollowed) {
	            this.unfollowed = unfollowed;
	        }
	        public void actionPerformed(ActionEvent e) {
	            UserService us= new UserService();
	            try {
					us.unfollow(user, unfollowed,users);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
	    }
	    class ViewWatchListListener implements ActionListener { //if the user clicks view button, the watch list that belongs to the user opens in following watch list view.
	        User following;
	
	        public ViewWatchListListener(User unfollowing) {
	            this.following = unfollowing;
	          
	        }
	        public void actionPerformed(ActionEvent e) {
	           FollowingWatchListView list=new FollowingWatchListView(following,json);


	        }
	    }


	}
	 
	

