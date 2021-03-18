/**
 * 
 * @author G05
 *
 */
@SuppressWarnings("serial")
public class IncorrectQuitButton extends IllegalArgumentException{
	
	public IncorrectQuitButton(String message) {
		super(message);
	}

	public IncorrectQuitButton() {		
	}
	
	@Override
	public void printStackTrace() {
		System.out.println("Incorrect quit button");
	}	


}// end exception
