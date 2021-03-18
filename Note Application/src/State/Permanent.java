package State;
import java.util.Scanner;

import Notes.Note;

public class Permanent implements State {
	
	private static Permanent instance = new Permanent();

	public Permanent() {
	}

	public static Permanent instance() {
		return instance;
	}

	public void updateState(Note ntc) {
		System.out.println("Note is permanent");
		try {
			Thread.sleep(2);
		}catch (InterruptedException e){}
		System.out.println("Press 1 if you want to cancel the note: ");
		Scanner s=new Scanner(System.in);
		int choice=s.nextInt();
		if(choice==1) {
			ntc.setState(Cancelled.instance());
		}else {
			System.out.println("Nothing is changed\nNote is still permanent");
		}
	}//end update
}//end class
