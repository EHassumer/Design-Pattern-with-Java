import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class RunTrack {
	
	private int perimeter;
	private RunTrackType type;
	private List<Object> runTrackPath;

	public RunTrack() {
  		this.perimeter =createPerimeter();
  		this.type = createRunTrackType();
  		runTrackPath = new ArrayList<Object>(perimeter);
  	}//end constructor
  	
	public int getPerimeter() {
		return this.perimeter;
	}//end getPerimeter
	
	public RunTrackType getType() {
		return this.type;
	}//end getType
	
	public List<Object> getRunTrackPath() {
		return runTrackPath;
	}//end getRunTrackPath
	
	/**
	 *  The perimeter of circular run track should be between 1000 – 10 000
	 * @return int, perimeter of run track
	 */
	private int createPerimeter() {
		int perimeter=(int)(Math.random()*9001)+1000;
		return perimeter;
	}//end create perimeter
	
	/**
	 * The type of the run track that can be a mountain or a jungle will be decided randomly.
	 * @return RunTrackType, type of run track
	 */
	private RunTrackType createRunTrackType() {
		Random rand = new Random();
		int num = rand.nextInt(2)+1;
		RunTrackType type=null;
		switch(num) {
		case 1:
			type=RunTrackType.Mountain;
			break;
		case 2:
			type=RunTrackType.Jungle;
			break;
	    }
		return type;
	}//end createRunTrackType
	
	public void print() {
		System.out.print("Hero is running in "+ getType() +" run track");
	}//end print
	
}//end RunTrack
