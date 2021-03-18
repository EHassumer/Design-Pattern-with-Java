package ShipAndDecorator;

import PlaneAndDecorator.Bomber;
import PlaneAndDecorator.Fighter;
import PlaneAndDecorator.Multirole;

public class Torpedo extends ShipDecorator{
	private int point;
	public Torpedo(Ship newShip) {
		super(newShip);
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		if(tempShip.getClass().equals(Cruiser.class) || tempShip.getClass().equals(Destroyer.class) || tempShip.getClass().equals(Frigate.class))
			return tempShip.getName() + "(torpedo[3-5]";
		else
			return tempShip.getName() + ",torpedo[3-5]";
	}
	public String getNameRun() {  //to print with generated point, if/else block for places of comma and parentheses 
		if(tempShip.getClass().equals(Cruiser.class) || tempShip.getClass().equals(Destroyer.class) || tempShip.getClass().equals(Frigate.class))
			return tempShip.getNameRun() + "(torpedo["+point+"] ";
		else
			return tempShip.getNameRun() + ",torpedo["+point+"] ";
	}
	public int getPoint() {
		point = (int)(Math.random()*3+3);
		return tempShip.getPoint()+point;
	}

}
