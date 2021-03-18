import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
@SuppressWarnings("rawtypes")
public class GameEngine<T> {
	
	private Level level;
	private Hero hero;
	private RunTrack runtrack;
	private Score score;
	private JavaKeyListener listen;
	private Monster monster;
	private GameFunction function = new GameFunction();
	private JSONFile json; 
	private ArrayList<T> list = new ArrayList<T>();
	
	public GameEngine() {
		level = function.createLevel();
		hero = new Hero();
		runtrack = new RunTrack();
		score = new Score();
		listen = new JavaKeyListener();
		monster = new Monster();
		json = new JSONFile();
	}//end constructor
		
	@SuppressWarnings("unchecked")
	private  ArrayList<T> game(String reason){
		ArrayList<T> game = new ArrayList<T>(10);
		game.add((T) level.name());
		game.add((T) runtrack.getType());
		game.add((T) Integer.toString(runtrack.getPerimeter()));
		game.add((T) reason);
		game.add((T) Integer.toString(hero.getChest().size()));
		game.add((T) Integer.toString(getCollectedDiamond()));
		game.add((T) Integer.toString(score.getScore()));
		return game;
	}//end array write to json file
	
	public void createPath() {
		int path = 0;
		while (path< runtrack.getPerimeter()) {
			path += 1;
			boolean createObstacle = function.create(500,path);
			boolean createCurrency = function.create(50,path);
			if (createObstacle == true) {
				Obstacle obstacle = function.createObstacle();
				runtrack.getRunTrackPath().add((path - 1), obstacle);
			}
			else if (createCurrency == true ) {
				ICurrency currency = function.createCurrency();
				runtrack.getRunTrackPath().add(path - 1, currency);
			}
			
			else
				runtrack.getRunTrackPath().add(path - 1, null);
		}
	}//before the hero starts running path is ready
		
	public void play() throws JSONException, IOException , IncorrectQuitButton  {
		listen.listen();  // to input from keyboard
		String reason = " You pressed the "+ listen.getKey();
		try {
			Thread.sleep(1);
		}catch (InterruptedException e){}
		int path = 0;
		int around = 0;
		System.out.println("......If you want to quit, please enter Q.....");
		System.out.println("Game level is: "+level.name());
		System.out.println("Runtrack perimeter is: "+runtrack.getPerimeter());
		hero.setMove(new Run());
		hero.getMove().move();
	    while (true) {
	    	try {
				Thread.sleep(5);
			}catch (InterruptedException e){}
	    	path += 1;
	    	if(score.getScore() >= 5000) { // if score is over 5000 points, hero has a magnet
	    		if(!hero.hasMagnet()) {
	    			hero.setMagnet(true);
	    			hero.owned(hero.hasMagnet());
	    		}
	    	}//end first if
	    	if(runtrack.getRunTrackPath().get(path) == null) { // hero will gain one point for each meter
	    		score.addScore(hero.getMove().getPoint() * level.getLevel());
	    	}//end second if
	    	if(runtrack.getRunTrackPath().get(path) instanceof ICurrency) { //
	    		ICurrency currency = (ICurrency) runtrack.getRunTrackPath().get(path);
	    		if(score.getScore() <= 5000 && currency instanceof Magnetic) {
	    			// if hero has not magnet
	    		}else {
	    			currency.gained();
	    			hero.getChest().add(currency);
	    			score.addScore(currency.getPoint() * level.getLevel());
	    		}	
	    	}// if object is a currency
	    	if(runtrack.getRunTrackPath().get(path) instanceof Obstacle){ 
	    		Obstacle obstacle = (Obstacle) runtrack.getRunTrackPath().get(path);
	    		obstacle.exist();
	    		if(function.isSuccess()) {
	    			if(obstacle.toString() == "Above") {
	    				hero.setMove(new Slide());
	    				hero.getMove().move();
	    				score.addScore(hero.getMove().getPoint() * level.getLevel());
	    				hero.setMove(new Run());
	    			}
	    			if(obstacle.toString() == "Below") {
	    				hero.setMove(new Jump());
	    				hero.getMove().move();
	    				score.addScore(hero.getMove().getPoint() * level.getLevel());
	    				hero.setMove(new Run());
	    			}
	    		}else  {
	    			System.out.println(obstacle.crush());
	    			score.show();
	    			reason = obstacle.crush();
	    			break;
	    		}	
	    	}//if object is a obstacle
	    	if(path % 1500 == 0) {
	    		if(monster.eat()) {
	    			System.out.println(monster.eating());
	    			reason = monster.eating();
	    			score.show();
	    			break;
	    		}
	    	}// if monster eat hero
	    	if(path == runtrack.getPerimeter() -1) {
	    		around += 1;
	    		path = 0;
	    		System.out.println("***********"+around + " tour"+"***********");
	    	}// if the hero become the starting point again, index equals the zero(circular run track)
	    	getCollectedDiamond();
	    	// if user press q , write the information about game at json 
	    	list = game(reason);
		    json.saveJSON((ArrayList<T>) list);
	    }//end while
	    // if game ended natural way , write the information about game at json 
	    list = game(reason);
	    json.saveJSON((ArrayList<T>) list);
	}//end play
	
	
	public int getCollectedDiamond() {
		int diamond = 0;
    	for (int i=0;i<hero.getChest().size();i++) {
	    	if(hero.getChest().get(i)instanceof Diamond) {
	    		diamond += 1;
	    	}
	    }
    	return diamond;
    }// to calculate number of collected diamond
	
	public void start() throws InterruptedException, JSONException, IncorrectQuitButton, IOException {
		 createPath();
		 play();
		 json.writeJsonFile();
	}// for start the game
			
}//end game engine


