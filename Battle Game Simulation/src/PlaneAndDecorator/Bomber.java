package PlaneAndDecorator;
public class Bomber implements Plane {
	private int point;
	private Engine engine;
	
	public Bomber(Engine engine) {
		this.engine=engine;	
	}
	public String getName() {
		// TODO Auto-generated method stub
		return "Bomber Plane[15-20] with "+ engine.getName();
	}
	public String getNameRun() {//to print with generated point
		
			return "Bomber["+point+"] with "+ engine.getNameRun();
	}
	@Override
	public int getPoint() {
		point = (int)(Math.random()*6+15);
		return point + engine.getPoint();
	}

}

