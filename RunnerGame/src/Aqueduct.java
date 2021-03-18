public class Aqueduct extends AboveObstacle {
	
	@Override
	public String obstacle() {
		return getClass().getSimpleName();
	}//end toString
	
	
	public void exist() {
		System.out.println("There is an " + obstacle());
	}//end exist
	
}//end Aquedect
