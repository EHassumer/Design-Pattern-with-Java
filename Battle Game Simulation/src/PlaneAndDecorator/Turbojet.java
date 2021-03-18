package PlaneAndDecorator;
public class Turbojet implements Engine {
	private int point;
	
	@Override
	public String getName() {
		return "Turbojet[5-7]";
	}
	public String getNameRun() {//to print with generated point
		return "Turbojet["+point+"]";
}
	@Override
	public int getPoint() {
		point = (int)(Math.random()*3+5);
		return point;
	}
	

}