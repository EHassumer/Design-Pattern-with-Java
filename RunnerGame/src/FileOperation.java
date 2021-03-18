import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;
public class FileOperation {
	private JSONObject jsonObject = new JSONObject();
	public void saveJsonFile(String deadReason,String level,String typeOfRuntrack,int perimeter,int totalScore,int totalDiamond,int totalCurriencies) throws JSONException {
		jsonObject.put("reason",deadReason);
	    jsonObject.put("level",level);
	    jsonObject.put("typeof runtrack",typeOfRuntrack);
	    jsonObject.put("perimeter",perimeter);
	    jsonObject.put("total score",totalScore);
	    jsonObject.put("total diamond",totalDiamond);
	    jsonObject.put("total curriencies",totalCurriencies);
	    
	}
	public JSONObject getJsonObject() {
		return jsonObject;
	}
	
	
	
	public void writeJsonFile() {
		try {  
	    	FileWriter jsonWriter = new FileWriter("JSON.json");
			jsonWriter.write(jsonObject.toString());
			jsonWriter.close();
	    } catch (IOException e) {
	         e.printStackTrace();
	      }
	      System.out.println("JSON file created: "+jsonObject);
	}
}
