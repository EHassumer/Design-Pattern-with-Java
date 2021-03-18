package State;
import Notes.Note;

public class Cancelled implements State{
	
	private static Cancelled instance = new Cancelled();
	
	private Cancelled() {
	}

	public static Cancelled instance() {
		return instance;
	}
	
	public void updateState(Note ntc) {
		System.out.println("Note is cancelled so it cannot be changed.");
		
	}//end update
}//end class
