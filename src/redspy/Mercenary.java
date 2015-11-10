package redspy;

import java.util.ArrayList;

public class Mercenary implements GetName {
	
	public static enum Status {
		NORMAL, UNCONSCIOUS, DEAD
	}
	
	private Map map;
	private Room room;
	private Status status = Status.NORMAL;
	
	public Mercenary(Map mapIn) {
		map = mapIn;
		ArrayList<Room> domain = getDomain();
		Room startRoom = domain.get((int) (Math.random() * domain.size()));
		room = startRoom;
		startRoom.addMercenary(this);
	}
	
	public String getName() {
		return "Mercenarius Genericus";
	}
	
	public int getPerceptionModifier() {
		return 0;
	}
	
	public int getCombatModifier() {
		return 0;
	}
	
	public void wander() {
		ArrayList<Room> possibilities = room.getExits();
		goTo(possibilities.get((int) (Math.random() * possibilities.size())));
	}
	
	public final void takeTurn() {
		if (status == Status.NORMAL) {
			takePassiveTurn();
		}
	}
	
	public void takePassiveTurn() {
		wander();
	}
	
	public ArrayList<Room> getDomain() {
		ArrayList<Room> out = new ArrayList<Room>();
		for (Map.RoomAccessor a : Map.RoomAccessor.values()) {
			out.add(map.getRoom(a));
		}
		return out;
	}
	
	public final Status getStatus() {
		return status;
	}
	
	public final void setStatus(Status statusIn) {
		status = statusIn;
	}
	
	public final void goTo(Room newRoom) {
		if (room != null) {
			room.removeMercenary(this);
			room.addChat(getName() + " leaves " + room.getName());
		}
		newRoom.addMercenary(this);
		newRoom.addChat(getName() + " enters " + newRoom.getName());
		room = newRoom;
	}
	
	public String getBanter() {
		return "damn spies...";
	}
	
	public final Map getMap() {
		return map;
	}
	
	public final Room getRoom() {
		return room;
	}
	
}
