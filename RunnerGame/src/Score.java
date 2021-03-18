/**
 * To calculate score
 * @author G05
 *
 */
public class Score {
	
	private int score;
	
	public Score() {
		this.score = 0;
	}//end constructor
	
	public int getScore() {
		return this.score;
	}//end getScore
	
	public void addScore(int score) {
		this.score += score;
	}//end addScore
		
	public void show() {
		System.out.println("Score: "+ getScore());
	}//end show

}//end score
