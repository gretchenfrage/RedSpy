package redspy;

import java.util.ArrayList;

public class Map {
	
	public static enum RoomAccessor {
		INTEL, MAINROOM, PLAZA, MEDICLAB, FRONTROOM, BASEMENT, TUNNEL, BRIDGE, SNIPERFORT
	}
	
	private Room intel = new Room("the intel room", Room.Status.INTEL);
	private Room mainRoom = new Room("the main room");
	private Room plaza = new Room("the plaza");
	private Room medicLab = new Room("Medic's lab");
	private Room frontRoom = new Room("the front room");
	private Room basement = new Room("the basement");
	private Room tunnel = new Room("the tunnel", Room.Status.ENDGAME);
	private Room bridge = new Room("the bridge", Room.Status.ENDGAME);
	private Room sniperFort = new Room("Sniper's fort");
	
	public Map() {
		link(intel, mainRoom);
		link(intel, plaza);
		link(intel, medicLab);
		link(mainRoom, sniperFort);
		link(plaza, frontRoom);
		link(frontRoom, basement);
		link(basement, tunnel);
		link(frontRoom, bridge);
		mainRoom.addExit(frontRoom);
	}
	
	private void link(Room r1, Room r2) {
		r1.addExit(r2);
		r2.addExit(r1);
	}
	
	public Room getRoom(RoomAccessor key) {
		switch (key) {
			case INTEL: return intel;
			case MAINROOM: return mainRoom;
			case PLAZA: return plaza;
			case MEDICLAB: return medicLab;
			case FRONTROOM: return frontRoom;
			case BASEMENT: return basement;
			case TUNNEL: return tunnel;
			case BRIDGE: return bridge;
			case SNIPERFORT: return sniperFort;
			default: return null;
		}
	}
	
	public ArrayList<Room> getAllRooms() {
		ArrayList<Room> out = new ArrayList<Room>();
		for (RoomAccessor accessor : RoomAccessor.values()) {
			out.add(getRoom(accessor));
		}
		return out;
	}
	
	public void clearBuffers() {
		for (Room r : getAllRooms()) {
			r.clearBuffer();
		}
	}
	
}
