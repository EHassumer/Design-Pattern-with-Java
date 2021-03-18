
public class Jump extends Move{
	
    private final int point;
	
	public Jump() {
		super();
		point = 2;
	}//end constructor
	
	public int getPoint() {
		return point;
	}//end getPoint
	
	public  void move() {
		System.out.println("Hero jump");
	}//end move
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}//end toString

}//end Jump
