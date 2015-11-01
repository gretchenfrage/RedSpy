package redspy;

import java.util.ArrayList;

public class Room {
	
	public static enum Status {
		NORMAL, INTEL, ENDGAME
	}

	private String name;
	private ArrayList<Room> exits = new ArrayList<Room>();
	private Status type;
	private ArrayList<Mercenary> mercenaries = new ArrayList<Mercenary>();
	
	public Room(String nameIn, Status typeIn) {
		name = nameIn;
		type = typeIn;
	}
	
	public Room(String nameIn) {
		this(nameIn, Status.NORMAL);
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
	
	public Status getType() {
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
	
	public void describe() {
		System.out.println("You are in " + name + " " + listMercenaries());
	}
	
	private String listMercenaries() {
		if (mercenaries.size() == 0) {
			return "alone";
		} else if (mercenaries.size() == 1) {
			return "with " + mercenaries.get(0).getName();
		} else if (mercenaries.size() == 2) {
			return "with " + mercenaries.get(0).getName() + " and " + mercenaries.get(1).getName();
		} else {
			String out = "";
			for (int i = 0; i < mercenaries.size(); i++) {
				out += mercenaries.get(i).getName();
				if (i < mercenaries.size() - 2) {
					out += ", ";
				} else if (i == mercenaries.size() - 2) {
					out += ", and ";
				}
			}
			return "with " + out;
		}
	}
	
}
