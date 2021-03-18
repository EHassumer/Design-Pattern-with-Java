package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Model.User;
import Service.UserService;

public class CreateWatchListView extends JFrame{
	private static JLabel text;
	private JTextField listname ;
	private static JButton addButton;
	private User user;
	private List<User> users;

	JFrame frame= new JFrame("Create List");
	JPanel content = new JPanel();
	
	CreateWatchListView(List<User> users,User user) {
		this.user=user;
		this.users=users;
		
		frame.setSize(350,200);
		
		frame.add(content);
		content.setLayout(null);
		
		text= new JLabel("Please enter watch list name:");
		text.setBounds(10, 20, 400, 25);	
		content.add(text);
		
		listname=new JTextField(50);
		listname.setBounds(40, 70, 180, 25);
		content.add(listname);
		
		addButton=new JButton("Add");
		addButton.setBounds(70, 120, 80, 25);
		content.add(addButton);
		
		addButton.addActionListener(new AddListener());
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(100, 100);
		frame.setVisible(true);
	}
	 class AddListener implements ActionListener { // if the user clicks the add button, the watch list is created with entered name and is added to list of watch list
		    public void actionPerformed(ActionEvent e) {
		    	String name=listname.getText();
		    	listname.setText(null);
		    	UserService us=new UserService();
		    	try {
					us.createWatchList(user, name,users);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    	frame.setVisible(false);
		    	
		    		    	
		    }
	 }
}

