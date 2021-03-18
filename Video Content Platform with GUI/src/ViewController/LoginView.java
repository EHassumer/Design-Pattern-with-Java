package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import File.JSON;
import Model.User;
import Model.Video;
import Service.LoginService;

public class LoginView extends JFrame{
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton loginButton;
	private static JLabel result;
	
	private LoginService loginService=new LoginService();
	private List<User> users;
	private List<Video> videos;
	private JSON json;
	
	JFrame frame= new JFrame("Login");
	JPanel panel =new JPanel();
	
	public LoginView(List<User> users,List<Video> videos,JSON json){
		
		this.users=users;
		this.videos=videos;
		this.json=json;
		
		frame.setSize(350,200);
		
		frame.add(panel);
		panel.setLayout(null);
		
		userLabel= new JLabel("User");
		userLabel.setBounds(10, 20, 80, 25);	
		panel.add(userLabel);
		
		passwordLabel= new JLabel("Password");
		passwordLabel.setBounds(10, 50, 165, 25);	
		panel.add(passwordLabel);
		
		userText= new JTextField(20);
		passwordText= new JPasswordField();
		userText.setBounds(100, 20, 165, 25);
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(userText);
		panel.add(passwordText);
		
		loginButton= new JButton("Login");
		loginButton.setBounds(140, 100,80, 25);
		panel.add(loginButton);
		
		result = new JLabel("");
		result.setBounds(10, 110, 300, 25);
		panel.add(result);	
		
		loginButton.addActionListener(new LoginListener());
		
        this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	
  
   class LoginListener implements ActionListener { //if the user clicks the login button, loginservice controls this operation and if it is succesful, user page view is opened. If not,user must try again.
	    public void actionPerformed(ActionEvent e) {
	    	User user=null;
			String username=userText.getText();
			String password = passwordText.getText();
			user=loginService.login(users, username, password);
			if(user!=null) {
				result.setText("Login successful!");
			    frame.setVisible(false);
			    UserPageView homepage=new UserPageView(users,videos, user,json);
			}else {
				userText.setText(null);
				passwordText.setText(null);
				result.setText("Login unsuccesful!");
			}
	    }
   }



   
}