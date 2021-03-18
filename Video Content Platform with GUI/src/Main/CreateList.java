package Main;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;

import File.JSON;
import File.ReadJSON;
import File.XMLReader;
import File.XMLWriter;
import Model.Comment;
import Model.User;
import Model.Video;
import Service.VideoService;

public class CreateList {
	private List<Video> videos = new ArrayList<Video>();
	private List<User> users = new ArrayList<User>();
	private JSON json;
	public void start() throws Exception {
		json = new JSON();
		
		Video video1 = new Video("Bedroom makeover", "V-log", "+13", new Date());
		video1.setId(1);
		Video video2 = new Video("Top-10 2020 PlayList", "Music List", "+10", new Date());
		video2.setId(2);
		Video video3 = new Video("Pride and Prejudice", "Film", "+15", new Date());
		video3.setId(3);

		XMLReader readxml=new XMLReader();
		users=readxml.XMLRead();
		
				
		videos.add(video3);
		videos.add(video2);
		videos.add(video1);
		json.saveJSON(videos);
		json.writeJsonFile();

	}

	public void process() throws Exception {
		
		User user1 = new User("Eda", "123");
		User user2 = new User("Huri", "456");
		User user3 = new User("Merve", "789");
		
		users.add(user3);
		users.add(user2);
		users.add(user1); 
		
		XMLWriter write = new XMLWriter();
		write.saveUser(users);
		
		
	}

	public List<Video> getVideos() {
		return videos;
	}

	public List<User> getUsers() {
		return users;
	}

	public JSON getJson() {
		return json;
	}

}
