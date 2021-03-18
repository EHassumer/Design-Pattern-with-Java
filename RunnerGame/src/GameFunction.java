
public class GameFunction<T> {
	
	/**
	 * 1 for easy level, 2 for moderate level, 3 for hard level, 4 for expert level.
	 * @return Level
	 */
	public Level createLevel() {
		int num=(int)(Math.random()*4)+1;
		Level level=null;
		switch(num) {
		case 1:
			level=Level.Easy;
			break;
		case 2:
			level=Level.Moderate;
			break;
		case 3:
			level=Level.Hard;
			break;
		case 4:
			level=Level.Expert;
			break;
		}
		return level;
	}//end createLevel
	
	/**
	 * This probability will be generated each time the hero needs to avoid an obstacle.
	 * @return boolean, true or false
	 */
	public boolean isSuccess() {
		boolean result;
		double num=Math.random();
		if(num<0.05) {
			
			result= false;
		}else
			result= true;
		return result;
	}//end isSuccess
	
	/**
	 * The currencies and the obstacles will be placed along the run track
	 * @param frequency
	 * @param path , perimeter of run track
	 * @return boolean, true or false
	 */
	public boolean create(int frequency,int path) {
		boolean create = false ;
		if(path % frequency == 0) {
			create = true; 
		}
		return create;
	}//end create
	
	public Obstacle createObstacle() {
		Obstacle obstacle=null;
		int num=(int)(Math.random()*4)+1;
		switch(num) {
		case 1:
			obstacle=new Saw();
			break;
		case 2:
			obstacle=new Rock();
			break;
		case 3:
			obstacle=new Aqueduct();
			break;
		case 4:
			obstacle=new FelledTree();
			break;
	    }
		return obstacle;
	}//end create obstacle
	
	public ICurrency createCurrency() {
		ICurrency currency=null;
		int num=(int)(Math.random()*3)+1;
		switch(num) {
		case 1:
			currency=new Coin();
			break;
		case 2:
			currency=new Diamond();
			break;
		case 3:
			currency = new Magnetic();
			break;
		}
		return currency;
	}//end create Currency
	
}//end game functions
