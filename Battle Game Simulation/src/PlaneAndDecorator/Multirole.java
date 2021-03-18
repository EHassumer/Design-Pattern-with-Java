package PlaneAndDecorator;
public class Multirole implements Plane {
	private int point;
	private Engine engine;
	
	public Multirole(Engine engine) {
		this.engine=engine;	
	}
	public String getName() {
		return "Multirole Plane[10-15] with "+ engine.getName();
	}
	public String getNameRun() {//to print with generated point
			return  "Multirole["+point+"] with "+ engine.getNameRun();
	}
	@Override
	public int getPoint() {
		point = (int)(Math.random()*16+10);
		return point + engine.getPoint();
	}
	public Engine getEngine() {
		return engine;
	}
}
