package PlaneAndDecorator;

public class Bomb extends PlaneDecorator{
	private int point;
	public Bomb(Plane newPlane) {
		super(newPlane);
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		if(tempPlane.getClass().equals(Fighter.class) || tempPlane.getClass().equals(Multirole.class) || tempPlane.getClass().equals(Bomber.class))
			return tempPlane.getName() + "(bomb[0-10]";
		else
			return tempPlane.getName() + ",bomb[0-10]";
	}
	public String getNameRun() {//to print with generated point, if/else block for places of comma and parentheses 
		if(tempPlane.getClass().equals(Fighter.class) || tempPlane.getClass().equals(Multirole.class) || tempPlane.getClass().equals(Bomber.class))
			return tempPlane.getNameRun() + "(bomb["+point+"]";
		else
			return tempPlane.getNameRun() + ",bomb["+point+"]";
	}
	public int getPoint() {
		point = (int)(Math.random()*12-1);
		return tempPlane.getPoint()+point;
	}



}
