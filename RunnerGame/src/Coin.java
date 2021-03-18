public class Coin implements ICurrency{

	private int point;
	
	public Coin() {
		this.point = 100;
	}//end constructor
	
	@Override
	public int getPoint() {
		return this.point;
	}//end get point

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}//end toString
	
	/**
	 * Print collected coin
	 */
	@Override
	public void gained() {
		System.out.println("Hero collected a coin");
	}//end gained
}//end Coin
