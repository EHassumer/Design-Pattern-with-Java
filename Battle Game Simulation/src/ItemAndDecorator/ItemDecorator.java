package ItemAndDecorator;

import PlaneAndDecorator.Plane;
import ShipAndDecorator.Ship;

public abstract class ItemDecorator implements Plane,Ship{
	protected IItem tempItem;
	
	public ItemDecorator(IItem item) {
		tempItem=item;
	}
	
	public String getName() {
		
		return tempItem.getName();
	}
	public int getPoint() {
		return tempItem.getPoint();
	}
	
}
