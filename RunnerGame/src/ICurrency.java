/**
 * 
 * @author G05
 *
 */
public interface ICurrency {
    
	/**
	 * Get the value of currency
	 * @return int, The value of currency
	 */
	public int getPoint();
	
	/**
	 * Get the type of currency
	 * @return String, Currency name
	 */
	public String toString();
	
	/**
	 * For subclasses
	 */
	public  void gained();
		
}//end ICurrency
