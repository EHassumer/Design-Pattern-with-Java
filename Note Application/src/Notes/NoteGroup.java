package Notes;
import java.util.ArrayList;
import java.util.Scanner;

public class NoteGroup extends NoteGenerator{
	
	private ArrayList<NoteGenerator> notelist;

	public NoteGroup(int id, String title) {
		super(id,title);
		this.notelist=new ArrayList<NoteGenerator>();		
	}

    public ArrayList<NoteGenerator> getNotelist() {
		return notelist;
	}
    
	public void addNote(NoteGenerator note) {
		notelist.add(note);
	}
	
	public void delete() {
		this.notelist.clear();
		System.out.println("All notes are deleted...");
	}
	
	public void print() {  //for composite design pattern
		for(int i=0;i<notelist.size();i++) {
			System.out.println("("+notelist.get(i).getId()+") "+notelist.get(i).getTitle()+"("+notelist.get(i).getClass().getSimpleName()+")");
		}
		if(!notelist.isEmpty()) {
			Scanner scan = new Scanner(System.in);
			int id=scan.nextInt();
			for(int i=0;i<notelist.size();i++) {
				if(notelist.get(i).getId()==id) {
				   notelist.get(i).print();
				}
				
			}
		}
	}
	
}
