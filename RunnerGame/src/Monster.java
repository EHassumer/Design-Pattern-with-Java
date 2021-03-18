public class Monster {
	
	private boolean monster;
	
	public Monster() {
		monster = eatHero();
	}//end constructor
	
	public boolean eat() {
		return monster;
	}//end eat
	
	/**
	 * if the probability is less than 0.02, monster eat hero
	 * @return boolean, eat or not
	 */
	private boolean eatHero() {
		boolean result;
		double num=Math.random();
		if(num<0.02){
			result=true;
		}else
			result=false;
		return result;
	}//end eatHero
	
	public String eating() {
		String eat = " ";
		if (eatHero()) {
			eat = "Monster eat the Hero.";
		}
		return eat;
	}//end eat
		
}//end Monster
