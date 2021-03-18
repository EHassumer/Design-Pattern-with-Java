package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Model.User;
import Service.UserService;

public class AllUsersView extends JFrame {
	private static JTextField usernameTitle;
	private static JButton followButton;
	
	private User user;
	private List<User> users;
	
	JFrame frame= new JFrame("All Users");
	JPanel content = new JPanel();
	AllUsersView(List<User> users,User user){
		
		this.user=user;
		this.users=users;
	
		frame.setSize(500,300);
		
		frame.add(content);
		content.setLayout(null);
		int a=0;
		for(int i=0;i<users.size();i++) {
			
			if(!users.get(i).equals(user)) {	// user can not see yourself in all users list	
				usernameTitle=new JTextField(users.get(i).getName());
				usernameTitle.setBounds(10, (10+a*50), 150, 25);
				usernameTitle.setEditable(false);
				content.add(usernameTitle);
				
				followButton=new JButton("Follow");
				followButton.setBounds(200, (10+a*50), 80, 25);
				content.add(followButton);
				a++; 
				
				followButton.addActionListener(new AddListener(users.get(i)));
				
			}
			
		}
		
        this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(400, 400);
		frame.setVisible(true);
	}
	 class AddListener implements ActionListener { //if the user clicks the add button the user that is chose is added following list
		    User followeduser;
		    public AddListener(User followeduser) {
		    	this.followeduser=followeduser;
		}
		    public void actionPerformed(ActionEvent e) {
		    	UserService us=new UserService();
		    	try {
					us.follow(user, followeduser,users);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	
		    }
	   }	
}
