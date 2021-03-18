import java.util.ArrayList;
import java.util.List;

public class Hero {
	
	private List<ICurrency> chest;
	private boolean magnet;
	private Move move;
	
	public Hero() {
		chest = new ArrayList<ICurrency>();
		this.magnet = false;
	}//end constructor
	
	public List<ICurrency> getChest() {
		return chest;
	}//end getChest
	
	public boolean hasMagnet() {
		return magnet;
	}//end hasMagnet
	
	public void setMagnet(boolean magnet) {
		this.magnet = magnet;
	}//end setMagnet
	
	public Move getMove() {
		return move;
	}//end getMove

	public void setMove(Move move) {
		this.move = move;
	}//end setMove
	
	public void owned(boolean magnet) {
		if(magnet == true) {
			System.out.println("*****************Hero owned a magnet****************");
		}		
	}//end owned
	
}//end class
