package Service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.json.JSONException;

import File.JSON;
import File.ReadJSON;
import Model.Comment;
import Model.User;
import Model.Video;

public class VideoService {
	
	private List<User> temporary;
	private List<Comment> temporaryCom;
	private List<Video> videos;
	public void likeVideo(Video video,User user,JSON json) throws JSONException, ParseException, IOException {
		boolean result=true;
    	for(int i=0;i<video.getLikes().size();i++) {  // if the user is already like this video, nothing is done.

    		if(video.getLikes().get(i)==user) {
    			result=false;
    		}
    	}	
    	if(result) {
    		for(int i=0;i<video.getDislikes().size();i++) {//if the user didn't like the video,  updates the list of dislikes and adds the user to the list of likes.
	        	if(video.getDislikes().get(i)==user) {
	    			video.getDislikes().remove(i);
	    		}
        	}
    	 temporary=video.getLikes();
    	 temporary.add(user);
    	 video.setLikes(temporary);
    	 json.updateJSONFile(video,json.getJsonObject());
    	
    	}
	}
	public void dislikeVideo(Video video,User user,JSON json) throws JSONException, ParseException, IOException {
		boolean result=true;
		for(int i=0;i<video.getDislikes().size();i++) {  // if the user is already dislike this video, nothing is done.
    		if(video.getDislikes().get(i)==user) {
    			result=false;
    		}
    	}	
    	if(result) {
    		for(int i=0;i<video.getLikes().size();i++) {//if the user likes the video,  updates the list of likes and adds the user to the list of dislikes.
	        	if(video.getLikes().get(i)==user) {
	    			video.getLikes().remove(i);
	    		}
        	}
    	temporary=video.getDislikes();
       	temporary.add(user);
       	video.setDislikes(temporary);
       	json.updateJSONFile(video,json.getJsonObject());
    	}
	}
	public void commentVideo(Video video,Comment comment,JSON json) throws JSONException, ParseException, IOException { //adds the comment of user to this video
			temporaryCom=video.getComments();
	       	temporaryCom.add(comment);
	       	video.setComments(temporaryCom);
	       	json.updateJSONFile(video,json.getJsonObject());
	
	}
}
