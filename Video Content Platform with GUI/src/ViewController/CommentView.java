package ViewController;

import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Model.Video;

public class CommentView extends JFrame implements Observer{
	private static JLabel Title;
	private JTextField comment ;
	private Video video;
	JFrame frame= new JFrame("Comments");
	JPanel content = new JPanel();
	public void update(Observable o, Object data) {
		 video=(Video)o;
		 createContent();
		 
	 }
	CommentView(Video video) {
		frame.setSize(500,300);
		this.video=video;
		
		Title=new JLabel("Comments of "+ video.getTitle()+":");
		Title.setBounds(10, 10, 400, 25);
		Title.setFont(new Font("Dialog", Font.PLAIN, 15));
		content.add(Title);
		
		createContent();  //this method for filling the content of this view.
		
		frame.add(content);
		content.setLayout(null);
		
		
		 this.pack();
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setLocation(600, 600);
		 frame.setVisible(true);
	}
	public void createContent() {  //prints all comments of this video with user name to the view.
		for(int i=0;i<video.getComments().size();i++) {
			comment = new JTextField(video.getComments().get(i).toString())	;
			comment.setBounds(10, 10+(i+1)*50, 250, 25);
			comment.setEditable(false);
			content.add(comment);
		}
	}
}