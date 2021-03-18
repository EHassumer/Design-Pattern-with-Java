package Main;
import java.util.Scanner;

import Factory.PlaneFactory;
import Factory.ShipFactory;
import PlaneAndDecorator.Plane;
import Player.Player;
import ShipAndDecorator.Ship;

public class BattleGame {
	private Player player1 =new Player();
	private Player player2=new Player();
	private PlaneFactory planefac=new PlaneFactory();
	private ShipFactory shipfac=new ShipFactory();

	public void menu() {
		while(true) {
			System.out.print("-------Menu-------\n1-Player Operations\n2-Run Simulation\n3-Reset items\n4-Exit\n-->");
		    Scanner input=new Scanner(System.in);
		    int operator=input.nextInt();   
			switch(operator){
			case 1://for selecting player	
				System.out.print("Which player are you?\n1-Player1\n2-Player2\n-->");
				operator=input.nextInt();
				if(operator==1) {
					operations(player1);
					break;
				}
				else if(operator==2) {
					operations(player2);
					break;
				}
				else {
					System.out.println("Wrong input!!");
					break;
				}
			case 2://run simulation
				if(player1.getItemlist().size()==0 || player2.getItemlist().size()==0) { 
					System.out.println("All player must have at least one item. ");
					break;
				}else {
					System.out.println("Points for Player 1:");
					int point1=player1.calculatePoint();
					System.out.println("Points for Player 2:");
					int point2=player2.calculatePoint();
					System.out.println("Player 1 points "+point1+"-Player 2 points "+point2);
					if(point1>point2) {
						System.out.println("Player 1 wins by "+(point1-point2)+".");
						break;
					}else if(point2>point1) {
						System.out.println("Player 2 wins by "+(point2-point1)+".");
						break;
					}else {
						System.out.println("Your points are equals.");
						break;
					}
			}
			case 3:// resets all items from players
				player1.resetItems();
				player2.resetItems();
				break;
			case 4://exits in system
				System.exit(0);
			default:
					System.out.println("Wrong input!!");
			}	
		}		
	}
		public void operations(Player player) {			
			boolean result=true;
			while(result) {
				System.out.print("1-Add part of item\n2-Add Plane\n3-Add Ship\n4-Show the items of players\n5-Finish\n-->");
			    Scanner input=new Scanner(System.in);
			    int operator=input.nextInt();
				switch(operator){
				case 1:
					if(player.getItemlist().size()==0) {
						System.out.println("There is any item, please choose!!");
					}else {
						for(int j=0;j<player.getItemlist().size();j++) {//prints all items that are owned by user for selecting 
							System.out.println(j+1 +"-" +player.getItemlist().get(j).getName()+")");
						}
						System.out.print("Please enter the item number to add some parts-->");
						int item=input.nextInt();
						boolean result2=true;
						while(result2) {
							if(item>player.getItemlist().size()) {
								System.out.println("Wrong input!!");
								System.out.print("Please enter the item number to add some parts-->");
								item=input.nextInt();
							}else {
								if(player.getItemlist().get(item-1) instanceof Plane) {// if item that is selected is plane
									planefac.part(player,item);
									result2=false;
								}else if(player.getItemlist().get(item-1) instanceof Ship) {// if item that is selected is ship
									shipfac.part(player,item);
									result2=false;
									}
							}
						}						
					}
					break;
				case 2:
					if(player.getItemlist().size()<5) { //limitation for  "There should be a maximum of 5 items."
						if(player.getPlanelist().size()<3) {//limitation for  "There should be a maximum of 3 planes."
							Plane plane=planefac.createPlane();	
							if(planeTypeCounter(player, plane)<2) {//limitation for "There should be a maximum of 2 items that are the same type."
								player.getPlanelist().add(plane);
								plane=planefac.addParts(plane);
								player.getItemlist().add(plane);
								player.printItems();
								break;
							}else {
								System.out.println("There should be a maximum of 2 items that are the same type.");
								break;
							}	
						}else {
							System.out.println("There should be a maximum of 3 planes.");
							break;
						}
					}else {
						System.out.println("There should be a maximum of 5 items");
						break;
					}
				case 3:
					if(player.getItemlist().size()<5) {//limitation for  "There should be a maximum of 5 items."
						if(player.getShiplist().size()<3) {//limitation for  "There should be a maximum of 3 ships."
							Ship ship=shipfac.createShip();					
							if(shipTypeCounter(player, ship)<2) {//limitation for "There should be a maximum of 2 items that are the same type."
								player.getShiplist().add(ship);
								ship=shipfac.addParts(ship);
								player.getItemlist().add(ship);
								player.printItems();
								break;
							}else {
								System.out.println("There should be a maximum of 2 items that are the same type.");
								break;
							}
						}else {
							System.out.println("There should be a maximum of 3 ships.");
							break;
						}
					}else {
						System.out.println("There should be a maximum of 5 items");
						break;
					}
				case 4://to print all items that are owned by all players
						System.out.println("Player 1:");
						player1.printItems();
						System.out.println("Player 2:");
						player2.printItems();
					break;
				case 5:// for finish
					result=false;
					break;
				default:
					System.out.println("Wrong input!!");
				}			
			}
		}
		private int shipTypeCounter(Player player, Ship ship) {//to count number of ships that are same type in ship list
			int counter=0;
			for(int k=0;k<player.getShiplist().size();k++) {
				if(player.getShiplist().get(k).getClass()==ship.getClass()) {
					counter+=1;
				}
			}
			return counter;
		}
		public int planeTypeCounter(Player player,Plane plane) {//to count number of planes that are same type in plane list
			int counter=0;
			for(int k=0;k<player.getPlanelist().size();k++) {
				if(player.getPlanelist().get(k).getClass()==plane.getClass()) {
					counter+=1;
				}
			}
			return counter;
		}
}
