package Notes;

public abstract class NoteGenerator {
	private int id;
	private String title;

    public NoteGenerator(int id, String title) {
		this.id=id;
		this.title = title;
		
		}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
    public abstract void print();
	protected abstract void addNote(NoteGenerator note);

}
