import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONFile {

	private JSONObject j = new JSONObject();

	public <T> void saveJSON(ArrayList<T> game) throws JSONException, IOException {
		FileWriter jsonWriter = new FileWriter("JSON.json");

		j.put("The level of the game", game.get(0));
		j.put("The type of the runtrack", game.get(1));
		j.put("The perimeter", game.get(2));
		j.put("The reason of ended game", game.get(3));
		j.put("The total number of currencies", game.get(4));
		j.put("The number of diamond", game.get(5));
		j.put("The total score", game.get(6));
		jsonWriter.write(j.toString());

		jsonWriter.close();
	}//end  save json file
	
	public void writeJsonFile() {
		try {  
	    	FileWriter jsonWriter = new FileWriter("JSON.json");
			jsonWriter.write(j.toString());
			jsonWriter.close();
	    } catch (IOException e) {
	         e.printStackTrace();
	      }
	      System.out.println("JSON file created: "+j);
	}

	public JSONObject getJsonObject() {
		return j;
	}//end get json object
}//end JSONFile
