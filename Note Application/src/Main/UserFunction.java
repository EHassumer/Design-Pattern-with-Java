package Main;

import java.util.Date;
import java.util.Scanner;

import Notes.Note;
import Notes.NoteGroup;
import State.Incomplete;
import State.Permanent;
import State.State;

public class UserFunction {
	
	private int idCounter = 1;
	//This method asks to user which type of note that want to create, and create it.
	//notes(parameter):Note Group that is wanted to create a note or note group in it.
	@SuppressWarnings({ "unused", "resource" })
	public void createNote(NoteGroup notes) {
		boolean isComplete = false; 
		while(!isComplete) {
			System.out.println("Which type of note do you want to create?");
			try {
				Thread.sleep(2);
			}catch (InterruptedException e){}
			System.out.println("Press 1 want to create note group, press 2 want to create note:");
			Scanner scan = new Scanner(System.in);
			int type = scan.nextInt();
			if(type != 1 && type !=2) {
				type=3;
			}
			switch(type) {
				case 1: //For note group
					System.out.println("Please enter the title:");
					String title = scan.nextLine();
					title = scan.nextLine();
					NoteGroup noteGroup = new NoteGroup(idCounter, title);
					notes.addNote(noteGroup);
					idCounter++;
					isComplete = true;
					break;
				case 2:// For note
					State state = null;
					System.out.println("Please enter the title:");
					String title1 = scan.nextLine();
					title1 = scan.nextLine();
					System.out.println("Please enter the content:");
					String content = scan.nextLine();
					boolean isChanged = false;
					while(!isChanged) { //for invalid input, asks again 
						System.out.println("Please enter the state");
						try {
							Thread.sleep(2);
						}catch (InterruptedException e){}
						System.out.println("Press 1 for creating incomplete note , press 2 for creating permanent note:");
						int num = scan.nextInt();
						if(num != 1 && num !=2) {
							num=3; //For invalid input
						}
						switch(num) {
							case 1:
								state = new Incomplete();
								isChanged = true;
								break;
							case 2:
								state = new Permanent();
								isChanged = true;
								break;
							case 3: 
								System.out.println("Invalid input...");
								break;
						}//second switch
					}//second while
					Date date = new Date();
					Note note = new Note(idCounter, title1, content, state);
					notes.addNote(note);
					idCounter++;
					isComplete = true;
					break;
				case 3:
					System.out.println("Invalid input...");
					break;
			}//first switch		
		}//first while
	}//end create
	//This method for searching note group that is wanted to add new note or note group. 
	@SuppressWarnings("resource")
	public void loop(NoteGroup root) {
		if (root.getNotelist().isEmpty()) {
			createNote((NoteGroup) root);
		} else {
			for (int i = 0; i < root.getNotelist().size(); i++) {
				System.out.println("(" + root.getNotelist().get(i).getId() + ") " + root.getNotelist().get(i).getTitle() + " (" + root.getNotelist().get(i).getClass().getSimpleName()+ ")");;
			}//for
			System.out.println("If you want to create note in this group, press 0:");// if the user wants to create new note or note group in the selected note Group, press 0 .
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			if (num == 0)
				createNote((NoteGroup) root);
			else {		//If the user keeps searching a note group, user have to enter the id of note group that is wanted to select. 
				for (int i = 0; i < root.getNotelist().size(); i++) {
					if (root.getNotelist().get(i).getId() == num) {
						if(root.getNotelist().get(i).getClass().getSimpleName().equals("NoteGroup")) {
							loop((NoteGroup) root.getNotelist().get(i));
						}
						if(root.getNotelist().get(i).getClass().getSimpleName().equals("Note")) {
							root.getNotelist().get(i).print(); //Since the user cannot create any note or note group in the note, the program prints content of the note.
						}
					}
				}//for
		   }//second else
		}//first else
	}//end loop
	// This method for changing state of selected note.
	@SuppressWarnings("resource")
	public void change(NoteGroup root) {
		if (root.getNotelist().isEmpty()) {
			System.out.println("There is any note or note group.");
		} else {
			for (int i = 0; i < root.getNotelist().size(); i++) {
				System.out.println("(" + root.getNotelist().get(i).getId() + ") " + root.getNotelist().get(i).getTitle()+" "+root.getNotelist().get(i).getClass().getSimpleName());
				
			}//first for
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			for (int i = 0; i < root.getNotelist().size(); i++) {
				if (root.getNotelist().get(i).getId() == num && (root.getNotelist().get(i) instanceof Note)) {	
					((Note) root.getNotelist().get(i)).getState().updateState(((Note) root.getNotelist().get(i)));
					//if the id that is entered belongs to the note, the state of note is updated.
				}
				else if (root.getNotelist().get(i).getId() == num && (root.getNotelist().get(i) instanceof NoteGroup)) {
					change((NoteGroup) root.getNotelist().get(i));
					//if the id that is entered belongs to the note group, user keeps searching.
				}
		   }//second for
		}//else
	}//end change

}//User Function
