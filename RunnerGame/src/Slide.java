public class Slide extends Move{
	
    private final int point;
	
	public Slide() {
		super();
		point = 2;
	}//end constructor
	
	public int getPoint() {
		return point;
	}//end getPoint
	
    public  void move() {
		System.out.println("Hero slide");
	}//end move
	
    @Override
	public String toString() {
		return getClass().getSimpleName();
	}//end toString

}//end Slide
