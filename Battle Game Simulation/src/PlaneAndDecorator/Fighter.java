package PlaneAndDecorator;

public class Fighter implements Plane{
	private String name;
	private int point;
	private Engine engine;
	
	public Fighter(Engine engine) {
		this.engine=engine;	
	}
	public String getName() {
		return "Fighter Plane[10-12] with "+ engine.getName();
	}
	public String getNameRun() {//to print with generated point
		
			return "Fighter Plane["+point+"] with "+ engine.getNameRun();
	}
	@Override
	public int getPoint() {
		point = (int)(Math.random()*3+10);
		return point + engine.getPoint();
	}
	public Engine getEngine() {
		return engine;
	}


}