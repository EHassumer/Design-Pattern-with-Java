package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import File.JSON;
import Model.User;
import Model.Video;

public class AllVideosView extends JFrame {
	private static JTextField videoTitle;
	private static JButton addButton;
	private static JButton viewButton;
	private User user;
	private List<User> users;
	private JSON json;
	
	JFrame frame= new JFrame("All Videos");
	JPanel content = new JPanel();
	
	AllVideosView(User user,List<Video> videos,List<User> users,JSON json){
			
		this.user=user;
		this.users=users;
		this.json=json;

		frame.setSize(500,300);
		
		frame.add(content);
		content.setLayout(null);
		
		for(int i=0;i<videos.size();i++) {
			videoTitle=new JTextField(videos.get(i).getTitle());
			videoTitle.setBounds(10, (10+i*50), 150, 25);
			videoTitle.setEditable(false);
			content.add(videoTitle);
			
			addButton=new JButton("Add");
			addButton.setBounds(200, (10+i*50), 80, 25);
			content.add(addButton);
			
			viewButton=new JButton("View");
			viewButton.setBounds(300, (10+i*50), 80, 25);
			content.add(viewButton);
			

			addButton.addActionListener(new AddListener(videos.get(i)));
			viewButton.addActionListener(new ViewListener(videos.get(i)));
		}
		
        this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(400, 400);
		frame.setVisible(true);
	}
	 class AddListener implements ActionListener { // if the user clicks the add button, all watch list view opens and user have to choose a list for adding this video.
		    Video video;
		    public AddListener(Video video) {
		    	this.video=video;
		}
		    public void actionPerformed(ActionEvent e) {
		    	AllWatchListView allwatchlist=new AllWatchListView(users,user,video,json);
		    	user.addObserver(allwatchlist);
		    	
		    }

	   }
	 class ViewListener implements ActionListener { // if the user clicks the view button, view of this video is opened.
		   Video video;
		    public ViewListener(Video video) {
		    	this.video=video;
		}

			public void actionPerformed(ActionEvent e) {
		    	VideoView videoView=new VideoView(video,user,json);
		    	video.addObserver(videoView);
		    	
		    	
		    }

	   }
	

}
