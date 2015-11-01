package redspy;

import java.util.ArrayList;

public class Mercenary {
	
	public static enum Status {
		NORMAL, UNCONSCIOUS, DEAD
	}
	
	private Map map;
	private Room room;
	private Status status = Status.NORMAL;
	
	public Mercenary(Map mapIn) {
		map = mapIn;
		ArrayList<Room> domain = getDomain();
		goTo(domain.get((int) (Math.random() * domain.size())));
	}
	
	public String getName() {
		return "Mercenarius Genericus";
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status statusIn) {
		status = statusIn;
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
