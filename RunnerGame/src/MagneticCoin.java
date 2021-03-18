
public class MagneticCoin extends Currency {
	private final int point;
	

	public MagneticCoin() {
		super();
		this.point = 200;
	}


	public int getPoint() {
		return point;
	}
	public void gain() {
		System.out.println("Hero collected "+ getClass().getName());

	}

}
