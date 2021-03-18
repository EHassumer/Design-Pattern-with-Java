package Notes;
import java.util.Date;

import State.State;

public class Note extends NoteGenerator{
	private String content;
	private State state;
	private Date date;

	public Note(int id, String title, String content, State state) {
		super(id,title);
		this.content = content;
		this.state = state;
		date =new Date();
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	@Override
	public void print() {
		System.out.println("Content: "+getContent());
	}
	@Override
	protected void addNote(NoteGenerator note) {
		// TODO Auto-generated method stub
		
	}

}
