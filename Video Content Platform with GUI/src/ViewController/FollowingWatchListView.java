package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import File.JSON;
import Model.User;
import Model.WatchList;

public class FollowingWatchListView extends JFrame {
	    private static JButton watchlistButton;
	    private JSON json;
	     
	    JFrame frame = new JFrame("Watch List");
	    JPanel content = new JPanel();

	    FollowingWatchListView(User user,JSON json) {
	    	this.json=json;
	    	
	        frame.setSize(500, 300);

	        frame.add(content);
	        content.setLayout(null);
	        for (int i = 0; i < user.getWatchList().size(); i++) {

	            watchlistButton = new JButton(user.getWatchList().get(i).getName());
	            watchlistButton.setBounds(10, (10 + i * 50), 80, 25);
	            content.add(watchlistButton);
	            
	            watchlistButton.addActionListener(new WatchListListener(user.getWatchList().get(i)));
	            
	        }
	        this.pack();
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocation(300, 300);
	        frame.setVisible(true);
	    }
	    
	    class WatchListListener implements ActionListener {//if the user clicks the button with the name of the watch list, this watch list view is opened.
	        WatchList list;
	        public WatchListListener(WatchList list) {
	            this.list = list;
	        }
	        public void actionPerformed(ActionEvent e) {
	            WatchListView watchlistview=new WatchListView(list,json);
	            list.addObserver(watchlistview);
	        }
	    }

}
