package Main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import File.JSON;
import File.ReadJSON;
import File.XMLWriter;
import Model.Comment;
import Model.User;
import Model.Video;
import Model.WatchList;
import ViewController.LoginView;
public class Main {
	public static void main(String[] args) throws Exception {
		CreateList lists=new CreateList();
		lists.start();
		//lists.process(); 
		LoginView login=new LoginView(lists.getUsers(),lists.getVideos(),lists.getJson());
	
		
		
	}
}
