package ShipAndDecorator;

import PlaneAndDecorator.Bomber;
import PlaneAndDecorator.Fighter;
import PlaneAndDecorator.Multirole;

public class Cannon extends ShipDecorator{
	private int point;
	public Cannon(Ship newShip) {
		super(newShip);
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		if(tempShip.getClass().equals(Cruiser.class) || tempShip.getClass().equals(Destroyer.class) || tempShip.getClass().equals(Frigate.class))
			return tempShip.getName() + "(cannon[3-7]";
		else
			return tempShip.getName() + ",cannon[3-7]";
	}
	public String getNameRun() {//to print with generated point, if/else block for places of comma and parentheses 
		if(tempShip.getClass().equals(Cruiser.class) || tempShip.getClass().equals(Destroyer.class) || tempShip.getClass().equals(Frigate.class))
			return tempShip.getNameRun() + "(cannon["+point+"]";
		else
			return tempShip.getNameRun() + ",cannon["+point+"]";
	}
	public int getPoint() {
		point = (int)(Math.random()*5+3);
		return tempShip.getPoint()+point;
	}
}
