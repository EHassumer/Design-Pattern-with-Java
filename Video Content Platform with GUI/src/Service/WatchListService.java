package Service;
import java.util.ArrayList;
import java.util.List;

import File.XMLWriter;
import Model.User;
import Model.Video;
import Model.WatchList;

public class WatchListService {
	private List<Video> temporary;
	private XMLWriter xmlWrite = new XMLWriter();
	public void addVideo(WatchList watchlist,Video video,List<User> users) throws Exception { //if the selected video is not already added to the list, it will add it to this list
		boolean result=true;
		for(Video i: watchlist.getList()) {
			if(i.equals(video)) {
				result=false;
			}
		}
		if(result) {
			temporary=watchlist.getList();
			temporary.add(video);
			watchlist.setList(temporary);
			xmlWrite.saveUser(users);
		}
	}
	public void removeVideo(WatchList watchlist,Video video,List<User> users) throws Exception {// removes this video from this list
		 temporary=watchlist.getList();
    	 temporary.remove(video);
    	 watchlist.setList(temporary);
    	 xmlWrite.saveUser(users);
	}

}
