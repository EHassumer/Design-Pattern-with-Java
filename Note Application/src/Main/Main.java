package Main;

import java.io.IOException;
import java.util.Scanner;

import org.json.JSONException;

import JSon.Export;
import Notes.NoteGroup;

public class Main {
	@SuppressWarnings("resource")
	public  void start() throws JSONException, IOException {
		NoteGroup notes=new NoteGroup(0,"notes");
		UserFunction user=new UserFunction();
		System.out.print("Welcome to the Note Application\n");
		while(true) {
			System.out.println("------------------------------\n1: Create note or note group\n2: List Note Groups and Notes\n3: Change States of Notes\n4: Reset the program\n5: Export Notes as JSon File \n6: Exit");
			System.out.print("-------------------------------\nPlease press number to do the operation you want:");
			Scanner scan = new Scanner(System.in);
			int num=scan.nextInt();
			switch(num) {
			case 1:
				user.loop(notes);
				break;
			case 2:
				notes.print();
				break;
			case 3:
				user.change(notes);
				break;
			case 4:
				notes.delete();
				break;
			case 5:
				Export json = new Export();
				json.saveJSON(notes.getNotelist());
				json.writeJsonFile();
				break;
			case 6:
				System.out.println("You exited from the program");
				System.exit(0);
				break;
		    }//switch
	    }//while
	}//end star
}//end class