package ViewController;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.JSONException;

import File.JSON;
import Model.Comment;
import Model.User;
import Model.Video;
import Service.VideoService;

public class VideoView extends JFrame implements Observer {
	private static JLabel videoTitle;
	private static JLabel contentVideo;
	private static JLabel audienceVideo;
	private static JLabel dateVideo;
	private static JButton likeButton=new JButton("Like");
	private JTextField like_num ;
	private static JButton dislikeButton=new JButton("Dislike");
	private JTextField dislike_num ;
	private static JButton commentButton=new JButton("Add Comment");
	private static JButton commentviewButton=new JButton("View All Comment");
	private JTextField comment_num ;
	private static JTextField commenttext;
	
	private Video video;
	private User user;
	private JSON json;
	VideoService vs=new VideoService();

	JFrame frame= new JFrame();
	JPanel content = new JPanel();
	
	 public void update(Observable o, Object data) {
		 Video video=(Video)o;
		 dislike_num.setText(Integer.toString(video.getDislikes().size()));
     	 like_num.setText(Integer.toString(video.getLikes().size()));
     	 comment_num.setText(Integer.toString(video.getComments().size()));
	 }
	VideoView(Video video,User user,JSON json){
		this.video=video;
		this.user=user;
		this.json=json;
		
		frame.setSize(500,300);
		
		frame.add(content);
		content.setLayout(null);
		videoTitle=new JLabel(video.getTitle());
		videoTitle.setBounds(100, 10, 200, 25);
		videoTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		content.add(videoTitle);
		
		
		contentVideo=new JLabel("Content:  "+video.getContent());
		contentVideo.setBounds(10, 40, 100, 50);
		contentVideo.setFont(new Font("Dialog", Font.PLAIN, 15));
		content.add(contentVideo);
		
		audienceVideo=new JLabel("Audience:  "+video.getAudience());
		audienceVideo.setBounds(120, 40, 100, 50);
		audienceVideo.setFont(new Font("Dialog", Font.PLAIN, 15));
		content.add(audienceVideo);
		
		dateVideo=new JLabel(video.getDate().toString());
		dateVideo.setBounds(230, 40, 130, 50);
		dateVideo.setFont(new Font("Dialog", Font.PLAIN, 15));
		content.add(dateVideo);
		
		likeButton.setBounds(10, 100, 80, 25);
		content.add(likeButton);
		
		like_num = new JTextField(Integer.toString(video.getLikes().size()));
		like_num.setBounds(100, 100, 30, 25);
		like_num.setEditable(false);
		content.add(like_num);
		
		dislikeButton.setBounds(150, 100, 80, 25);
		content.add(dislikeButton);
		
		dislike_num= new JTextField(Integer.toString(video.getDislikes().size()));
		dislike_num.setBounds(240, 100, 30, 25);
		dislike_num.setEditable(false);
		content.add(dislike_num);
		
		commenttext= new JTextField(100);
		commenttext.setBounds(10, 150, 300, 25);
		content.add(commenttext);
		
		comment_num = new JTextField(Integer.toString(video.getComments().size()));
		comment_num.setBounds(320, 150, 30, 25);
		comment_num.setEditable(false);
		content.add(comment_num);
		
		commentButton.setBounds(10, 180, 150, 25);
		content.add(commentButton);
		
		commentviewButton.setBounds(200, 180, 150, 25);
		content.add(commentviewButton);
		
		likeButton.addActionListener(new LikeListener());
        dislikeButton.addActionListener(new DisLikeListener());
        commentButton.addActionListener(new CommentListener());
        commentviewButton.addActionListener(new CommentViewListener());
		       
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addWindowListener(new CloseListener());
        frame.setLocation(600, 600);
		frame.setVisible(true);
	}

	class LikeListener implements ActionListener { // if the user clicks like button, the user is added in like list of this video.
        public void actionPerformed(ActionEvent e) {
        	try {
				vs.likeVideo(video, user, json);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
        }
    }
	
	class DisLikeListener implements ActionListener {// if the user clicks dislike button, the user is added in dislike list of this video.
		public void actionPerformed(ActionEvent e) {
			try {
				vs.dislikeVideo(video, user, json);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}       	
		}
	}
	
	class CommentListener implements ActionListener {// if the user clicks add comment button, comment that is written by the user is added in comment list of this video.
		public void actionPerformed(ActionEvent e) {
			Comment comment=new Comment(user,commenttext.getText());
			try {
				vs.commentVideo(video, comment, json);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			commenttext.setText(null);	
		}
	}

	class CommentViewListener implements ActionListener {// if the user clicks view all comments button, user can see comment view page.
		public void actionPerformed(ActionEvent e) {
			CommentView commentview=new CommentView(video);
			video.addObserver(commentview);			
		}
	}
	public static class CloseListener extends WindowAdapter {	// Despite the closing of the page on all video view pages, actionlisteners were still open. To prevent this confusion, we closed the list of each button with the time we closed the page.
		public void windowClosing(WindowEvent e) {
			
			for(ActionListener conf : commentButton.getActionListeners())
            {
				commentButton.removeActionListener(conf);
            }
			for(ActionListener conf : commentviewButton.getActionListeners())
            {
				commentviewButton.removeActionListener(conf);
            }
			for(ActionListener conf : likeButton.getActionListeners())
            {
				likeButton.removeActionListener(conf);
            }
			for(ActionListener conf : dislikeButton.getActionListeners())
            {
				dislikeButton.removeActionListener(conf);
            }	
		}
	}

}
