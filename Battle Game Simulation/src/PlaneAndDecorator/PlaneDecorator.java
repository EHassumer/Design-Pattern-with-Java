package PlaneAndDecorator;
public abstract class PlaneDecorator implements Plane{
	protected Plane tempPlane;
	public PlaneDecorator(Plane newPlane) {
		tempPlane= newPlane;
	}
	public String getName() {
		return tempPlane.getName();
	}
	public int getPoint() {
		return tempPlane.getPoint();
	}

}
