import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

public class JavaKeyListener<T> implements KeyListener{
	
	public ArrayList<T> key = new ArrayList<T>();
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}//end keyTyped
	
	public T getKey() {
		return  this.key.get(0);
	}//end getKey

	@SuppressWarnings("unchecked")
	@Override
	public void keyPressed(KeyEvent e) {
		key.add(0,(T) KeyEvent.getKeyText(e.getKeyCode()));
		try {
			Thread.sleep(1000);
		}catch (InterruptedException i){}
		System.out.println("You pressed " + key);
		if(e.getKeyCode() == KeyEvent.VK_Q ) {
			System.out.println("Game is over ");
		}if(e.getKeyCode() != KeyEvent.VK_Q ){
			System.out.println("You pressed " + key);
			throw new IncorrectQuitButton();
		}
	} // end key press
	
	@Override
	public void keyReleased(KeyEvent e) {
		try {	
			if(e.getKeyCode() != KeyEvent.VK_Q ){
				throw new IncorrectQuitButton();
			}
		}catch(IncorrectQuitButton q) {
			try {
				Thread.sleep(100);
			}catch (InterruptedException i){}
			q.printStackTrace();
		}
		System.exit(0);
	}//to show action key pressed
	
	public void listen() { 
		    key.add(0,(T) null);
			JFrame frame = new JFrame();
		 	JavaKeyListener<T> listen = new JavaKeyListener<T>();
	        frame.setTitle("Game");
	        frame.setSize(400, 20);
	        frame.setResizable(false);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.addKeyListener(listen);
	        frame.setVisible(true);
	}//to take input from keyboard 
	
}//end class
