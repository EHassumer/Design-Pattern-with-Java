package JSon;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import Notes.Note;
import Notes.NoteGenerator;
import Notes.NoteGroup;

public class Export {
	
	private JSONObject json = new JSONObject();

	public void saveJSON(ArrayList<NoteGenerator> notes) throws JSONException, IOException {
		for (NoteGenerator i : notes) {
			if (i.getClass().getSimpleName().equals("NoteGroup")) {
				if (!((NoteGroup) i).getNotelist().isEmpty()) {
					saveJSON(((NoteGroup) i).getNotelist());
				}
			}
			if (i.getClass().getSimpleName().equals("Note")) {
				String[] attribute = new String[4];
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
				String date = dateFormat.format(((Note) i).getDate());
				attribute[0] = i.getTitle();
				attribute[1] = ((Note) i).getContent();
				attribute[2] = String.valueOf(((Note) i).getState().getClass().getSimpleName());
				attribute[3] = date;
				json.put(String.valueOf(i.getId()), attribute);
			}
		}//for
	}// end save json file

	public void writeJsonFile() {
		try {
			FileWriter jsonWriter = new FileWriter("JSON.json");
			jsonWriter.write(json.toString());
			jsonWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("JSON file created: " + json.length() + " Notes");
	}//end write

	public JSONObject getJsonObject() {
		return json;
	}// end get json object
}//end class
