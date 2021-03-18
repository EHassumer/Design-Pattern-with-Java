public class Magnetic implements ICurrency{

	private int point;
	
	public Magnetic() {
		this.point = 200;
	}//end constructor
	
	@Override
	public int getPoint() {
		return this.point;
	}//end getPoint

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}// toString
	
	/**
	 * Print collected magnetic coin
	 */
	@Override
	public void gained() {
		System.out.println("Hero collected a magnetic coin");
	}//end gained
}//end Magnetic
