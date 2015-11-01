package redspy;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

	private Scanner scanner = new Scanner(System.in);
	private Game game;
	private Room room;
	
	public Player(Game gameIn) {
		game = gameIn;
		room = game.getMap().getRoom(Map.RoomAccessor.MAINROOM);
	}
	
	public Room getRoom() {
		return room;
	}
	
	@SuppressWarnings("incomplete-switch")
	public void takeUserTurn() {
		System.out.println("What do you do?");
		if (room.getExits().size() > 0) {
			System.out.println("[go to " + GetName.toSlashSeperatedString(room.getExits()) + "]");
		}
		ArrayList<Mercenary> conscious = new ArrayList<Mercenary>();
		ArrayList<Mercenary> unconscious = new ArrayList<Mercenary>();
		for (Mercenary m : room.getMercenaries()) {
			switch (m.getStatus()) {
				case NORMAL:
					conscious.add(m);
					break;
				case UNCONSCIOUS:
					unconscious.add(m);
					break;
			}
		}
		if (conscious.size() > 0) {
			System.out.println("[shoot " + GetName.toSlashSeperatedString(conscious) + "]");
			System.out.println("[talk to " + GetName.toSlashSeperatedString(conscious) + "]");
		}
		if (unconscious.size() > 0) {
			System.out.println("[resuscitate " + GetName.toSlashSeperatedString(unconscious));
		}
		undergoUserInput();
	}
	
	private void undergoUserInput() {
		System.out.print("> ");
		String input = scanner.nextLine();
		if (startsWith(input.toLowerCase(), "shoot") && input.length() >= 7) {
			shoot(input.substring(6, input.length()));
		} else if (startsWith(input.toLowerCase(), "talk to") && input.length() >= 9) {
			talkTo(input.substring(8, input.length()));
		} else if (startsWith(input.toLowerCase(), "resuscitate") && input.length() >= 11) {
			resuscitate(input.substring(10, input.length()));
		} else if (startsWith(input.toLowerCase(), "go to") && input.length() >= 7) {
			goTo(input.substring(6, input.length()));
		} else {
			System.out.println("INVALID INPUT");
			undergoUserInput();
		}
	}
	
	private void shoot(String target) {
		
	}
	
	private void talkTo(String target) {
		
	}
	
	private void resuscitate(String target) {
		
	}
	
	private void goTo(String target) {
		
	}
	
	private static boolean startsWith(String string, String startsWith) {
		if (string.length() >= startsWith.length()) {
			if (string.substring(0, startsWith.length()).equals(startsWith)) {
				return true;
			}
		}
		return false;
	}
	
}
