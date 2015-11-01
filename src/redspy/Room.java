package redspy;

import java.util.ArrayList;

public class Room {
	
	public static enum Type {
		NORMAL, INTEL, ENDGAME
	}

	private String name;
	private ArrayList<Room> exits = new ArrayList<Room>();
	private Type type;
	private ArrayList<Mercenary> mercenaries = new ArrayList<Mercenary>();
	
	public Room(String nameIn, Type typeIn) {
		name = nameIn;
		type = typeIn;
	}
	
	public Room(String nameIn) {
		this(nameIn, Type.NORMAL);
	}
	
	public String getName() {
		return name;
	}
	
	public void addExit(Room room) {
		exits.add(room);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Room> getExits() {
		return (ArrayList<Room>) exits.clone();
	}
	
	public Type getType() {
		return type;
	}
	
	public void addMercenary(Mercenary mercenary) {
		mercenaries.add(mercenary);
	}
	
	public void removeMercenary(Mercenary mercenary) {
		mercenaries.remove(mercenary);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Mercenary> getMercenaries() {
		return (ArrayList<Mercenary>) mercenaries.clone();
	}
	
}