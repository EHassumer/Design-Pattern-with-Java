package ShipAndDecorator;

import PlaneAndDecorator.Bomber;
import PlaneAndDecorator.Fighter;
import PlaneAndDecorator.Multirole;

public class Destroyer implements Ship {
	private String name;
	private int point;

	public Destroyer() {
		name= "Destroyer Ship";
	}
	public String getName() {
		return "Destroyer Ship[20-40]";
	}
	public String getNameRun() {//to print with generated point
		
			return "Destroyer Ship["+point+"]";
	}

	@Override
	public int getPoint() {
		point = (int)(Math.random()*21+20);
		return point;
	}

}
