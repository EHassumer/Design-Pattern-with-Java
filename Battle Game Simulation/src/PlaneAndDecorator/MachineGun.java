package PlaneAndDecorator;

public class MachineGun extends PlaneDecorator{
	private int point;
	public MachineGun(Plane newPlane) {
		super(newPlane);
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		if(tempPlane.getClass().equals(Fighter.class) || tempPlane.getClass().equals(Multirole.class) || tempPlane.getClass().equals(Bomber.class))
			return tempPlane.getName() + "(machinegun[1-3]";
		else
			return tempPlane.getName() + ",machinegun[1-3]";
	}
	public String getNameRun() {//to print with generated point, if/else block for places of comma and parentheses 
		if(tempPlane.getClass().equals(Fighter.class) || tempPlane.getClass().equals(Multirole.class) || tempPlane.getClass().equals(Bomber.class))
			return tempPlane.getNameRun() + "(machinegun["+point+"]";
		else
			return tempPlane.getNameRun() + ",machinegun["+point+"]";
	}
	public int getPoint() {
		point = (int)(Math.random()*3+1);
		return tempPlane.getPoint()+point;
	}


}
