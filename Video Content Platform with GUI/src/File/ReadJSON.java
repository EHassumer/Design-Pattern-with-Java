package File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Model.Comment;
import Model.User;
import Model.Video;


	 
	 
public class ReadJSON {
	    public List<Video>  readJSON(String file) throws java.text.ParseException {
	    	List<Video> videoList = new ArrayList<Video>();
	        //JSON parser object to parse read file
	        JSONParser jsonParser = new JSONParser();  
	        try (FileReader reader = new FileReader(file))
	        {
	            //Read JSON file
	        	JSONObject obj = (JSONObject) jsonParser.parse(reader);
                for(int i =1 ; i < obj.size()+1; i++) {
                
                    JSONObject j = (JSONObject) obj.get(Integer.toString(i));
                    String title = (String) j.get("Title");
                    String content = (String) j.get("Content");
                    String audience = (String) j.get("Audience");
                    String dateString = (String) j.get("Date");
                    Date date =  new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").parse(dateString);

                    List<User> likesList = new ArrayList<User>();
                    JSONObject likes = (JSONObject)( j.get("Likes"));
                    for(int k = 0; k < likes.size(); k++) {
                        JSONObject l = (JSONObject)( likes.get(Integer.toString(k)));
                        String name = (String) l.get("User");
                        User user = new User(name);
                        likesList.add(user);
                    }
  
                    List<User> dislikesList = new ArrayList<User>();
                    JSONObject dislikes = (JSONObject)( j.get("Likes"));
                    for(int k = 0; k < dislikes.size(); k++) {
                        JSONObject d = (JSONObject)( dislikes.get(Integer.toString(k)));
                        String name = (String) d.get("User");
                        User user = new User(name);
                        dislikesList.add(user);
                    }
                    List<Comment> commentsList = new ArrayList<Comment>();
                    JSONObject comments = (JSONObject)( j.get("Comments"));
                    for(int k = 0; k < comments.size(); k++) {
                        JSONObject c = (JSONObject)( comments.get(Integer.toString(k)));
                        String name = (String) c.get("Name");
                        User user = new User(name);
                        String comment = (String) c.get("Comment");
                        Comment addComment = new Comment(user, comment);
                        commentsList.add(addComment);
                    }
                    Video video = new Video(title,content,audience,date);
                    videoList.add(video);  
	            }   
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
			return videoList;
	    }//end readJSON
	 
}