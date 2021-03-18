package State;
import java.util.Scanner;

import Notes.Note;

public class Incomplete implements State{
	
	private static Incomplete instance = new Incomplete();

	public Incomplete() {
	}

	public static Incomplete instance() {
		return instance;
	}

	public void updateState(Note ntc) {
		System.out.println("Note is incompleted");
		try {
			Thread.sleep(2);
		}catch (InterruptedException e){}
		System.out.print("Press 1 if the note is completed, press 2 if you want to cancel the note:");
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		if (number == 1) {
			ntc.setState(Completed.instance());
		} else if (number == 2) {
			ntc.setState(Cancelled.instance());
		} else {
			System.out.println("Nothing is changed. Note is still incompleted.");

		}
	}//end update
}//end class
