package Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class WatchList extends Observable {
	private List<Video> list; // the list of videos that are belong to this watch list
	private String name;

	public WatchList(String name) {
		list =new ArrayList<Video>();
		this.name=name;
	}

	public List<Video> getList() {
		return list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		setChanged();
		notifyObservers();
		this.name = name;
	}

	public void setList(List<Video> list) {
		setChanged();
		notifyObservers();
		this.list = list;
	}
	


}