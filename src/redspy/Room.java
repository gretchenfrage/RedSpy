package redspy;

import java.util.ArrayList;

public class Room implements GetName {
	
	public static enum Status {
		NORMAL, INTEL, ENDGAME
	}

	private String name;
	private ArrayList<Room> exits = new ArrayList<Room>();
	private Status type;
	private ArrayList<Mercenary> mercenaries = new ArrayList<Mercenary>();
	private ArrayList<String> chatBuffer = new ArrayList<String>();
	
	public Room(String nameIn, Status typeIn) {
		name = nameIn;
		type = typeIn;
	}
	
	public Room(String nameIn) {
		this(nameIn, Status.NORMAL);
	}
	
	public void addChat(String chat) {
		chatBuffer.add(chat);
	}
	
	public void clearBuffer() {
		chatBuffer = new ArrayList<String>();
	}
	
	public void flushBuffer() {
		for (String s : chatBuffer) {
			System.out.println(s);
		}
		clearBuffer();
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
	
	public ArrayList<Mercenary> getMercenariesOfStatus(Mercenary.Status status) {
		ArrayList<Mercenary> out = new ArrayList<Mercenary>();
		for (Mercenary m : mercenaries) {
			if (m.getStatus() == status) {
				out.add(m);
			}
		}
		return out;
	}
	
	public ArrayList<Mercenary> getConsciousMercenaries() {
		return getMercenariesOfStatus(Mercenary.Status.NORMAL);
	}
	
	public ArrayList<Mercenary> getUnconsciousMercenaries() {
		return getMercenariesOfStatus(Mercenary.Status.UNCONSCIOUS);
	}
	
	public ArrayList<Mercenary> getDeadMercenaries() {
		return getMercenariesOfStatus(Mercenary.Status.DEAD);
	}
	
	public void describe() {
		if (mercenaries.size() == 0) {
			System.out.println("You are alone");
		} else {
			if (getConsciousMercenaries().size() > 0) {
				System.out.println("Standing in the room with you" + (getConsciousMercenaries().size() > 1 ? " are " : " is ") + GetName.toCommaSeperatedString(getConsciousMercenaries()));
			}
			if (getUnconsciousMercenaries().size() > 0) {
				System.out.println("Lying down unconscious but breathing"+ (getUnconsciousMercenaries().size() > 1 ? " are " : " is ") + GetName.toCommaSeperatedString(getUnconsciousMercenaries()));
			}
			if (getDeadMercenaries().size() > 0) {
				System.out.println("Lying down dead" + (getDeadMercenaries().size() > 1 ? " are " : " is ") + GetName.toCommaSeperatedString(getDeadMercenaries()));
			}
		}
	}
	
}
