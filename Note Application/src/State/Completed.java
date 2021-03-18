package State;
import Notes.Note;

public class Completed implements State {
	
	private static Completed instance = new Completed();

	private Completed() {
	}

	public static Completed instance() {
		return instance;
	}


	public void updateState(Note note_context) {
		System.out.println("Note is completed so it cannot be changed.");
	}//end update
}//end class