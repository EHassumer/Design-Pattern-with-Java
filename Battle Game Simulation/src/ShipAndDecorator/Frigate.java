package ShipAndDecorator;

import PlaneAndDecorator.Bomber;
import PlaneAndDecorator.Fighter;
import PlaneAndDecorator.Multirole;

public class Frigate implements Ship{
	private String name;
	private int point;
	
	public Frigate() {
		name= "Frigate Ship";
	}
	public String getName() {
		return "Frigate Ship [10-40]";
	}
	public String getNameRun() {//to print with generated point
		
			return "Frigate Ship["+point+"]";
	}

	@Override
	public int getPoint() {
		point = (int)(Math.random()*31+10);
		return point;
	}
}