/**
 * 
 * @author G05
 *
 */
public abstract class Obstacle {
	/**
	 * To decide what to do to pass the obstacle
	 *  @return String, Below or Above
	 */
	public String toString() { 
		return getClass().getSimpleName();
	}
	
	/**
	 * Which obstacle
	 * @return String, obstacle name
	 */
	public String obstacle() {return " ";} ;
	
	/**
	 * If hero does not pass obstacle
	 * @return String, with obstacle name
	 */
	public String crush() {
		return "Hero crushed the " + obstacle();
	}
	
	/**
	 * If hero come across obstacle
	 */
	public void exist() {
		System.out.println("There is a " + obstacle());
	}
	
}
