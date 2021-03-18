package PlaneAndDecorator;
public class Missile extends PlaneDecorator {
	private int point;
	public Missile(Plane newPlane) {
		super(newPlane);
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		if(tempPlane.getClass().equals(Fighter.class) || tempPlane.getClass().equals(Multirole.class) || tempPlane.getClass().equals(Bomber.class))
			return tempPlane.getName() + "(missile[3-6]";
		else
			return tempPlane.getName() + ",missile[3-6]";
	}
	public String getNameRun() {//to print with generated point, if/else block for places of comma and parentheses 
		if(tempPlane.getClass().equals(Fighter.class) || tempPlane.getClass().equals(Multirole.class) || tempPlane.getClass().equals(Bomber.class))
			return tempPlane.getNameRun() + "(missile["+point+"]";
		else
			return tempPlane.getNameRun() + ",missile["+point+"]";
	}
	public int getPoint() {
		point = (int)(Math.random()*4+3);
		return tempPlane.getPoint()+point;
	}


}
