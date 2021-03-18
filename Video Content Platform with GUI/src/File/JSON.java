package File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import Model.Comment;
import Model.User;
import Model.Video;
import Service.UserService;
import Service.VideoService;



public class JSON<T> {
	
	public static JSONObject json=new JSONObject();
	private int id = 1;

	public void saveJSON(List<Video> videos) throws JSONException, IOException {
		for (Video i : videos) {
            JSONObject video = new JSONObject();
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
            String date = dateFormat.format(((Video) i).getDate());
            video.put("Title", i.getTitle());
            video.put("Content", i.getContent());
            video.put("Audience", i.getAudience());
            video.put("Date", date);
            JSONObject likes = new JSONObject();
            for(int k=0; k< i.getLikes().size() ;k++) {
                   JSONObject c = new JSONObject();
                   c.put("User",i.getLikes().get(k).getName());
                   likes.put(String.valueOf(k),c);
            }
            video.put("Likes", likes);
            JSONObject dislikes = new JSONObject();
            for(int k=0; k< i.getDislikes().size() ;k++) {
                   JSONObject c = new JSONObject();
                   c.put("User",i.getDislikes().get(k).getName());
                   dislikes.put(String.valueOf(k),c);
            }
            video.put("Dislikes", likes);
            JSONObject comment = new JSONObject();
            for(int k=0; k< i.getComments().size() ;k++) {
                   JSONObject c = new JSONObject();
                   c.put("Name",i.getComments().get(k).getUser().getName());
                   c.put("Comment", i.getComments().get(k).getComment());
                    comment.put(String.valueOf(k),c);
            }
            video.put("Comments",comment );
            json.put(String.valueOf(i.getId()), video);
            id++;
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
		System.out.println("JSON file created: " + json.length() + " Videos");
	}//end write

	public static JSONObject getJsonObject() {
		return json;
	}// end get json object
	
	public void updateJSONFile(Video update, JSONObject jsonobject) throws JSONException {
		JSONObject video = new JSONObject();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String date = dateFormat.format(((Video) update).getDate());
        video.put("Title", update.getTitle());
        video.put("Content", update.getContent());
        video.put("Audience", update.getAudience());
        video.put("Date", date);
        JSONObject likes = new JSONObject();
        for(int k=0; k< update.getLikes().size() ;k++) {
               JSONObject c = new JSONObject();
               c.put("User",update.getLikes().get(k).getName());
               likes.put(String.valueOf(k),c);
        }
        video.put("Likes", likes);
        JSONObject dislikes = new JSONObject();
        for(int k=0; k< update.getDislikes().size() ;k++) {
               JSONObject c = new JSONObject();
               c.put("User",update.getDislikes().get(k).getName());
               dislikes.put(String.valueOf(k),c);
        }
        video.put("Dislikes", dislikes);
        JSONObject comment = new JSONObject();
        for(int k=0; k< update.getComments().size() ;k++) {
               JSONObject c = new JSONObject();
               c.put("Name",update.getComments().get(k).getUser().getName());
               c.put("Comment", update.getComments().get(k).getComment());
                comment.put(String.valueOf(k),c);
        }
        video.put("Comments",comment );
        jsonobject.put(String.valueOf(update.getId()), video);
        writeJsonFile();
	}
	

}
	
	
	    
	        
	
