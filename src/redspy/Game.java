package redspy;

public class Game {
	
	private Map map = new Map();
	private Mercenary scout = new Mercenary(map);
	private Mercenary soldier = new Mercenary(map);
	private Mercenary pyro = new Mercenary(map);
	private Mercenary engineer = new Mercenary(map);
	private Mercenary heavy = new Mercenary(map);
	private Mercenary demo = new Mercenary(map);
	private Mercenary medic = new Mercenary(map);
	private Mercenary sniper = new Mercenary(map);
	private Mercenary spy = new Mercenary(map);
	private Player player = new Player(this);

	public static void main(String[] args) {
		Game game = new Game();
		game.play();
	}
	
	public void play() {
		System.out.println("You are checking up on the mercenaries, standing in the main room of the fort, when you hear the familiar alarm...");
		System.out.println("ADMINISTRATOR: red spy is in the base!");
		player.getRoom().describe();
		player.takeUserTurn();
	}
	
	public Map getMap() {
		return map;
	}

}
