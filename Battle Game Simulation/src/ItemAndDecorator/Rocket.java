package ItemAndDecorator;

import PlaneAndDecorator.Bomber;
import PlaneAndDecorator.Fighter;
import PlaneAndDecorator.Multirole;
import PlaneAndDecorator.Plane;
import ShipAndDecorator.Cruiser;
import ShipAndDecorator.Destroyer;
import ShipAndDecorator.Frigate;
import ShipAndDecorator.Ship;

public class Rocket extends ItemDecorator {
	private int point;
	public Rocket(Plane plane) {
		super(plane);
		// TODO Auto-generated constructor stub
	}
	public Rocket(Ship newItem) {
		super(newItem);
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		if(tempItem.getClass().equals(Fighter.class) || tempItem.getClass().equals(Multirole.class) || tempItem.getClass().equals(Bomber.class) || tempItem.getClass().equals(Cruiser.class) || tempItem.getClass().equals(Destroyer.class) || tempItem.getClass().equals(Frigate.class))
			return tempItem.getName() + "(rocket[2-8]";
		else
			return tempItem.getName() + ",rocket[2-8]";
	}
	public String getNameRun() {//to print with generated point, if/else block for places of comma and parentheses 
		if(tempItem.getClass().equals(Fighter.class) || tempItem.getClass().equals(Multirole.class) || tempItem.getClass().equals(Bomber.class) || tempItem.getClass().equals(Cruiser.class) || tempItem.getClass().equals(Destroyer.class) || tempItem.getClass().equals(Frigate.class))
			return tempItem.getNameRun() + "(rocket["+point+"]";
		else
			return tempItem.getNameRun() + ",rocket["+point+"]";
	}
	public int getPoint() {
		point = (int)(Math.random()*7+2);
		return tempItem.getPoint()+point;
	}


}
