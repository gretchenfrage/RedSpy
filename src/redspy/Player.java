package redspy;

public class Player {

	private Game game;
	private Room room;
	
	public Player(Game gameIn) {
		game = gameIn;
		room = game.getMap().getRoom(Map.RoomAccessor.MAINROOM);
	}
	
	public Room getRoom() {
		return room;
	}
	
}
