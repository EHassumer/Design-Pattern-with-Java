package Factory;
import java.util.Scanner;

import ItemAndDecorator.Rocket;
import Player.Player;
import ShipAndDecorator.Cannon;
import ShipAndDecorator.Cruiser;
import ShipAndDecorator.Destroyer;
import ShipAndDecorator.Frigate;
import ShipAndDecorator.Ship;
import ShipAndDecorator.Torpedo;

public class ShipFactory implements AbstractFactory{
	public Ship createShip() { //to create a ship that is selected type
		boolean result=true;
		Ship ship=null;
		while(result) {
			System.out.print("Which type of ship do you want to create?\n1-Cruiser\n2-Destroyer\n3-Frigate\n-->");
		    Scanner input=new Scanner(System.in);
		    int operator=input.nextInt();
		   
			switch(operator){
			case 1:
				ship=create("Cruiser");
				result=false;
				break;
			case 2:
				ship=create("Destroyer");
				result=false;
				break;
			case 3:
				ship=create("Frigate");
				result=false;
				break;
			default:
				System.out.println("Wrong input!!");
			}
		}
		return ship;
	}
	@Override
	public Ship create(String shipType) { 
		if("Cruiser".equalsIgnoreCase(shipType))
			return new Cruiser();
		else if("Destroyer".equalsIgnoreCase(shipType))
			return new Destroyer();
		else if("Frigate".equalsIgnoreCase(shipType))
			return new Frigate();
		else
			return null;
	}
	public Ship addParts(Ship ship) {// to add a part for selected ship
		Ship temp=ship;
		boolean result=true;
		while(result) {
			System.out.print("Which type of part do you want to add?\n1-Rocket\n2-Torpedo\n3-Cannon\n-->");
		    Scanner input=new Scanner(System.in);
		    int operator=input.nextInt();
		   
			switch(operator){
			case 1:
				temp=new Rocket(ship);
				result=false;
				break;
			case 2:
				temp=new Torpedo(ship);
				result=false;
				break;
			case 3:
				temp=new Cannon(ship);
				result=false;
				break;
			default:
				System.out.println("Wrong input!!");
			}	
		}
		return temp;
	}
	public void part(Player player,int num) { //to select a ship for adding a part
		Ship ship=(Ship) player.getItemlist().get(num-1);		
		ship=addParts(ship);
		player.getItemlist().remove(num-1);
		player.getItemlist().add(num-1,ship);
		player.printItems();			
	}
}
