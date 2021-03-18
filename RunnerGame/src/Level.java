public enum Level {
		
	Easy (1),
	Moderate (2),
	Hard (3),
	Expert (4);
	
	private int level;
	
	Level (int level){
		this.level = level;
	}//end constructor

	/**
	 * @return int, coefficient of level
	 */
	public int getLevel() {
		return level;
	}//end getLevel 
	
}//end Level enum
