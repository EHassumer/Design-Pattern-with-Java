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
import Model.Video;
import Model.WatchList;
import Service.WatchListService;

public class WatchListView extends JFrame implements Observer {
    private static JTextField videoTitle;
    private static JButton removeButton;
    private static JButton viewButton;
    private User user;
    private WatchList list;
    private List<User> users;
    private JSON json;
   
    JFrame frame = new JFrame("Watch List");
    JPanel content = new JPanel();
    
    public void update(Observable o, Object data) {
		 list=(WatchList)o;
		 content.removeAll();
         content.revalidate();
         content.repaint();
         createContent();    
	 }

    WatchListView(List<User> users, User user, WatchList list, JSON json) {
    	this.users = users;
        this.user = user;
        this.list=list;
        this.json=json;
        
        frame.setSize(500, 300);

        frame.add(content);
        content.setLayout(null);
        createContent();

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(300, 300);
        frame.setVisible(true);
    }
    
    WatchListView(WatchList list,JSON json) {
        this.list=list;
        this.json=json;
        
        frame.setSize(500, 300);

        frame.add(content);
        content.setLayout(null);
        
        for (int i = 0; i < list.getList().size(); i++) {
        	 videoTitle = new JTextField(list.getList().get(i).getTitle());
             videoTitle.setBounds(10, (10 + i * 50), 150, 25);
             videoTitle.setEditable(false);
             content.add(videoTitle);

             viewButton = new JButton("View");
             viewButton.setBounds(300, (10 + i * 50), 80, 25);
             content.add(viewButton);

             viewButton.addActionListener(new ViewListener(list.getList().get(i)));
        }
       
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(300, 300);
        frame.setVisible(true);
    }

    public void createContent() {
        for (int i = 0; i < list.getList().size(); i++) {
            videoTitle = new JTextField(list.getList().get(i).getTitle());
            videoTitle.setBounds(10, (10 + i * 50), 150, 25);
            videoTitle.setEditable(false);
            content.add(videoTitle);

            removeButton = new JButton("Remove");
            removeButton.setBounds(200, (10 + i * 50), 80, 25);
            content.add(removeButton);
            
            viewButton = new JButton("View");
            viewButton.setBounds(300, (10 + i * 50), 80, 25);
            content.add(viewButton);

            removeButton.addActionListener(new RemoveListener(list.getList().get(i)));
            viewButton.addActionListener(new ViewListener(list.getList().get(i)));              
        }
    }

    class RemoveListener implements ActionListener { // if the user clicks remove button, the video that is chosen by user is removed in watchlist.
        Video video;
        public RemoveListener(Video video) {
            this.video = video;
        }
        public void actionPerformed(ActionEvent e) {
        	WatchListService ws=new WatchListService();
        	
        	try {
				ws.removeVideo(list, video,users);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}   
        }
    }
    
    class ViewListener implements ActionListener { // if the user clicks view button, user can see the chosen video view. 
        Video video;
        public ViewListener(Video video) {
            this.video = video;
        }
        public void actionPerformed(ActionEvent e) {
            VideoView videoview=new VideoView(video, user,json);
            video.addObserver(videoview);
        }
    }
}
 