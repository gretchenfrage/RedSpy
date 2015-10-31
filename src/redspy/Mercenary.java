package redspy;

import java.util.ArrayList;

public class Mercenary {
	
	private Map map;
	private Room room;
	
	public Mercenary(Map mapIn) {
		map = mapIn;
		ArrayList<Room> domain = getDomain();
		goTo(domain.get((int) (Math.random() * domain.size())));
	}
	
	public String getName() {
		return "Mercenarius Genericus";
	}
	
	public ArrayList<Room> getDomain() {
		ArrayList<Room> out = new ArrayList<Room>();
		for (Map.RoomAccessor a : Map.RoomAccessor.values()) {
			out.add(map.getRoom(a));
		}
		return out;
	}
	
	public final void goTo(Room newRoom) {
		if (room != null) {
			room.removeMercenary(this);
		}
		newRoom.addMercenary(this);
		room = newRoom;
	}
	
}
