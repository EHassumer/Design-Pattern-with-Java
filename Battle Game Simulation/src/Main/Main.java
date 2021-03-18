package Main;
import java.util.Scanner;

import ItemAndDecorator.Rocket;
import PlaneAndDecorator.Bomb;
import PlaneAndDecorator.Engine;
import PlaneAndDecorator.Fighter;
import PlaneAndDecorator.MachineGun;
import PlaneAndDecorator.Missile;
import PlaneAndDecorator.Plane;
import PlaneAndDecorator.Pulsejet;
import PlaneAndDecorator.Turbojet;
import ShipAndDecorator.Cannon;
import ShipAndDecorator.Destroyer;
import ShipAndDecorator.Ship;
import ShipAndDecorator.Torpedo;

public class Main {
	public static void main(String[] args) {
		
		BattleGame game=new BattleGame();
		game.menu();
		
	}

	
	
}
