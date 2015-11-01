package redspy;

public class Player {

	private Game game;
	private Room room = game.getMap().getRoom(Map.RoomAccessor.MAINROOM);
	
	public Player(Game gameIn) {
		game = gameIn;
	}
	
}
