package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

public class Video extends Observable {
	private String title;
	private String content;
	private String audience;
	private Date date;
	private int id;

	private List<User> likes;  // the list of users that like this video
	private List<User> dislikes;  // the list of users that dislike this video
	private List<Comment> comments;  // the list of comments that are belong to this video
	
	public Video(String title, String content, String audience, Date date) {
		this.title = title;
		this.content = content;
		this.audience = audience;
		this.date = date;
		this.likes = new ArrayList<User>();
		this.dislikes = new ArrayList<User>();
		this.comments = new ArrayList<Comment>();
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public String getAudience() {
		return audience;
	}

	public Date getDate() {
		return date;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public List<User> getLikes() {
		return likes;
	}
	public List<User> getDislikes() {
		return dislikes;
	}
	public List<Comment> getComments() {
		return comments;
	}

	public void setTitle(String title) {
		setChanged();
		notifyObservers();
		this.title = title;
	}

	public void setContent(String content) {
		setChanged();
		notifyObservers();
		this.content = content;
	}

	public void setAudience(String audience) {
		setChanged();
		notifyObservers();
		this.audience = audience;
	}

	public void setDate(Date date) {
		setChanged();
		notifyObservers();
		this.date = date;
	}

	public void setLikes(List<User> likes) {
		setChanged();
		notifyObservers();
		this.likes = likes;
	}

	public void setDislikes(List<User> dislikes) {
		setChanged();
		notifyObservers();
		this.dislikes = dislikes;
	}

	public void setComments(List<Comment> comments) {
		setChanged();
		notifyObservers();
		this.comments = comments;
	}

}