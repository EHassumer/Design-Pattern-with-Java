public class Diamond implements ICurrency{
  
    private int point;
	
	public Diamond() {
		this.point = 400;
	}//end constructor
	
	@Override
	public int getPoint() {
		return this.point;
	}//end getPoint

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}//end toString
	
	/**
	 * Print collected diamond
	 */
	@Override
	public void gained() {
		System.out.println("Hero collected a diamond");
	}//end gained
	
}//end Diamond
