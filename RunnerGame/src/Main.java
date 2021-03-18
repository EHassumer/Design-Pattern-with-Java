import java.io.IOException;

import org.json.JSONException;

public class Main {
	
	public static void main(String [] args) throws JSONException, IOException, IncorrectQuitButton, InterruptedException  {
	        
	       @SuppressWarnings("rawtypes")
		   GameEngine game =new GameEngine();
	       game.start();

	}//end main
}//end class
 //Hocam bizim yaptýðýmýza göre klavyede direk q ya basýnca duruyo fakat json file print etmiyor ama json file a bakabilirsiniz 
//orda reason kýsmýna kaydedilmiþ oluyor