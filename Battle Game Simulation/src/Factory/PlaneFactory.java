package Factory;
import java.util.Scanner;

import ItemAndDecorator.IItem;
import ItemAndDecorator.Rocket;
import PlaneAndDecorator.Bomb;
import PlaneAndDecorator.Bomber;
import PlaneAndDecorator.Engine;
import PlaneAndDecorator.Fighter;
import PlaneAndDecorator.MachineGun;
import PlaneAndDecorator.Missile;
import PlaneAndDecorator.Multirole;
import PlaneAndDecorator.Plane;
import PlaneAndDecorator.Pulsejet;
import PlaneAndDecorator.Turbojet;
import Player.Player;

public class PlaneFactory implements AbstractFactory {
	
	public Plane createPlane() {//to create a plane that is selected type
		boolean result=true;
		Plane plane=null;
		while(result) {
			System.out.print("Which type of plane do you want to create?\n1-Fighter\n2-Bomber\n3-Multirole\n-->");
		    Scanner input=new Scanner(System.in);
		    int operator=input.nextInt();
		   
			switch(operator){
			case 1:
				plane=create("Fighter");
				result=false;
				break;
			case 2:
				plane=create("Bomber");
				result=false;
				break;
			case 3:
				plane=create("Multirole");
				result=false;
				break;
			default:
				System.out.println("Wrong input!!");
			}
		}
		return plane;
	}

	@Override
	public Plane create(String planeType) {
		Engine engine=createEngine();
		if("Fighter".equalsIgnoreCase(planeType))
			return new Fighter(engine);
		else if("Bomber".equalsIgnoreCase(planeType))
			return new Bomber(engine);
		else if("Multirole".equalsIgnoreCase(planeType))
			return new Multirole(engine);
		else
			return null;
	}
	public Engine createEngine() { // to create an engine for plane
		System.out.print("Which type of engine do you want to create?\n1-Pulsejet\n2-Turbojet\n-->");
	    Scanner input=new Scanner(System.in);
	    int operator=input.nextInt();
	    Engine engine=null;
		switch(operator){
		case 1:
			engine=new Pulsejet();
			break;
		case 2:
			engine=new Turbojet();
			break;
		default:
			System.out.println("Wrong input!!");
			engine=createEngine();
		}
		return engine;
	     
	}
	public Plane addParts(Plane plane) {// to add a part for selected plane
		Plane temp=plane;
		boolean result=true;
		while(result) {
			System.out.print("Which type of part do you want to add?\n1-Rocket\n2-Missile\n3-Machine gun\n4-Bomb\n-->");
		    Scanner input=new Scanner(System.in);
		    int operator=input.nextInt();
		   
			switch(operator){
			case 1:
				temp=new Rocket(plane);
				result=false;
				break;
			case 2:
				temp=new Missile(plane);
				result=false;
				break;
			case 3:
				temp=new MachineGun(plane);
				result=false;
				break;
			case 4:
				temp=new Bomb(plane);
				result=false;
				break;
			default:
				System.out.println("Wrong input!!");
			}	
		}
		return temp;
	}
	public void part(Player player,int num) {//to select a plane for adding a part
		Plane plane=(Plane) player.getItemlist().get(num-1);
		plane=addParts(plane);
		player.getItemlist().remove(num-1);
		player.getItemlist().add(num-1,plane);
		player.printItems();		
	}

	
	
	
}
