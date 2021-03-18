public class Run extends Move{
	
	private final int point;
	
	public Run() {
		super();
		point = getPoint();
	}//end constructor
	
	public  void move() {
		System.out.println("Hero is running");
	}//end move
	
    @Override
	public String toString() {
		return getClass().getSimpleName();
	}//end toString
}//end Run
