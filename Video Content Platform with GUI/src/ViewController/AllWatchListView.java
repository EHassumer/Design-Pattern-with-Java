package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import File.JSON;
import Model.User;
import Model.Video;
import Model.WatchList;
import Service.WatchListService;

public class AllWatchListView extends JFrame implements Observer {
	private JButton listname ;
	private User user;
	private Video video;
	private List<User> users;
	private JSON json;
	
	
	JFrame frame;
	JPanel content = new JPanel();
	public void update(Observable o, Object data) {
		user=(User)o;
		content.removeAll();
        content.revalidate();
        content.repaint();
        createContent();
		
	 }
	public AllWatchListView(List<User> users,User user,Video video,JSON json) {  //for adding video to the watch list - It calls in all videos view in add button listener
		frame= new JFrame("All Watch List");
		this.user=user;
		this.video=video;
		this.users=users;
		this.json=json;
		
		frame.setSize(500,300);
		
		frame.add(content);
		content.setLayout(null);
		
		createContent();
		
		 this.pack();
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setLocation(500, 500);
		 frame.setVisible(true);
	}

		
	public AllWatchListView(User user,JSON json) { //for choosing and printing all videos in chosen specific watch list
		frame= new JFrame("All Watch List");
		this.user=user;
		this.json=json;
		
		frame.setSize(500,300);
		
		frame.add(content);
		content.setLayout(null);
		
		for(int i=0;i<user.getWatchList().size();i++) {
			listname = new JButton(user.getWatchList().get(i).getName());
			listname.setBounds(10, 10+i*50, 250, 25);
			
			content.add(listname);
			
			listname.addActionListener(new ListPrintListener(user.getWatchList().get(i)));
		}
		 this.pack();
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setLocation(200, 200);
		 frame.setVisible(true);
	
	}
	public void createContent() {
		for(int i=0;i<user.getWatchList().size();i++) {
			listname = new JButton(user.getWatchList().get(i).getName());
			listname.setBounds(10, 10+i*50, 250, 25);
			
			content.add(listname);
			
			listname.addActionListener(new ListListener(user.getWatchList().get(i)));
		}
	}
	 class ListListener implements ActionListener { //for adding video to the watch list
		 private WatchList mylist;
		 public ListListener(WatchList mylist) {
			 this.mylist=mylist;
		 }
			public void actionPerformed(ActionEvent e) {
				
				WatchListService wls=new WatchListService();
				try {
					wls.addVideo(mylist, video,users);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(false);
		    	
		    }

	   }
	 class ListPrintListener implements ActionListener { //for  printing all videos in chosen specific watch list
		 private WatchList mylist;
		 public ListPrintListener(WatchList mylist) {
			 this.mylist=mylist;
		 }
			public void actionPerformed(ActionEvent e) {
				
				WatchListView print=new WatchListView(users, user, mylist,json);
				mylist.addObserver(print);
		    	
		    }

	   }

}
