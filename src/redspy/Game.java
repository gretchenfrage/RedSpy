package redspy;

import redspy.mercs.Demo;
import redspy.mercs.Engineer;
import redspy.mercs.Heavy;
import redspy.mercs.Medic;
import redspy.mercs.Pyro;
import redspy.mercs.Scout;
import redspy.mercs.Sniper;
import redspy.mercs.Soldier;
import redspy.mercs.Spy;

public class Game {
	
	private Map map = new Map();
	private Mercenary scout = new Scout(map);
	private Mercenary soldier = new Soldier(map);
	private Mercenary pyro = new Pyro(map);
	private Mercenary engineer = new Engineer(map);
	private Mercenary heavy = new Heavy(map);
	private Mercenary demo = new Demo(map);
	private Mercenary medic = new Medic(map);
	private Mercenary sniper = new Sniper(map);
	private Mercenary spy = new Spy(map);
	private Player player = new Player(this);

	public static void main(String[] args) {
		Game game = new Game();
		game.play();
	}
	
	public void play() {
		System.out.println("You are checking up on the mercenaries, standing in the main room of the fort, when you hear the familiar alarm...");
		System.out.println("ADMINISTRATOR: The red spy is in the base!");
		player.describeRoom();
		player.takeUserTurn();
	}
	
	public Map getMap() {
		return map;
	}

}
