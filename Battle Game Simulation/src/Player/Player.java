package Player;
import java.util.ArrayList;
import java.util.List;

import ItemAndDecorator.IItem;
import PlaneAndDecorator.Plane;
import ShipAndDecorator.Ship;

public class Player {
	private List<IItem> itemlist;
	// we create ship and plane list to check number of them for limitation
	private List<Plane> planelist; 
	private List<Ship> shiplist;
	
	 public Player() {
		 itemlist=new ArrayList<>(5);
		 planelist=new ArrayList<>(3);
		 shiplist=new ArrayList<>(3);
	 }
	public List<Plane> getPlanelist() {
		return planelist;
	}
	
	public List<Ship> getShiplist() {
		return shiplist;
	}
	
	public List<IItem> getItemlist() {
		return itemlist;
	}
	public int calculatePoint() {
		int total=0;
		for(int i=0;i<itemlist.size();i++) {
			total+=itemlist.get(i).getPoint();
			System.out.println("-"+itemlist.get(i).getNameRun()+")");
		}
		return total;
	}
	public void resetItems() {
		itemlist.clear();
		planelist.clear();
		shiplist.clear();
	}
	public void printItems() {
		if(itemlist.size()!=0) {
			for(IItem i : itemlist)
				System.out.println(i.getName()+")");
		}
		
	}

	 

}
