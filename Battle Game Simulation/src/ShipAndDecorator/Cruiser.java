package ShipAndDecorator;

import PlaneAndDecorator.Bomber;
import PlaneAndDecorator.Fighter;
import PlaneAndDecorator.Multirole;

public class Cruiser implements Ship{
	private String name;
	private int point;

	public Cruiser() {
		name= "Cruiser Ship";
	}
	public String getName() {
		return "Cruiser Ship [15-30]";
	}
	public String getNameRun() {//to print with generated point
		
			return "Cruiser Ship["+point+"]";
	}
	@Override
	public int getPoint() {
		point = (int)(Math.random()*16+15);		
		return point;
	}
}
