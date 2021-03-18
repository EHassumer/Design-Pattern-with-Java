package PlaneAndDecorator;
public class Pulsejet implements Engine {
	private int point;
	
	@Override
	public String getName() {
		return "Pulsejet[2-4]";
	}
	public String getNameRun() {//to print with generated point 
			return "Pulsejet["+point+"]";
	}
	@Override
	public int getPoint() {
		point = (int)(Math.random()*3+2);	
		return point;
	}
	

}
