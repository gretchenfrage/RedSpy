package redspy;

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
	
	public void takeUserTurn() {
		System.out.println("What do you do?");
		if (room.getExits().size() > 0) {
			System.out.println("[go to " + GetName.toSlashSeperatedString(room.getExits()) + "]");
		}
		if (room.getConsciousMercenaries().size() > 0) {
			System.out.println("[shoot " + GetName.toSlashSeperatedString(room.getConsciousMercenaries()) + "]");
			System.out.println("[talk to " + GetName.toSlashSeperatedString(room.getConsciousMercenaries()) + "]");
		}
		if (room.getUnconsciousMercenaries().size() > 0) {
			System.out.println("[resuscitate " + GetName.toSlashSeperatedString(room.getUnconsciousMercenaries()) + "]");
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
			System.out.println("ERROR: \"" + input + "\" is not a valid action! Try again:");
			undergoUserInput();
		}
	}
	
	private void shoot(String targetName) {
		Mercenary target = (Mercenary) GetName.getItemWithName(room.getConsciousMercenaries(), targetName);
		if (target == null) {
			System.out.println("ERROR: " + targetName + " is not a valid person to shoot! Try again:");
			undergoUserInput();
		} else {
			if (target instanceof Mercenary) {
				target.setStatus(Mercenary.Status.DEAD);
				System.out.println("You shoot " + target.getName() + ". He does not turn red. You have killed your friend.");
			} //TODO: else statement for if it's an instance of Enemy
		}
	}
	
	private void talkTo(String targetName) {
		Mercenary target = (Mercenary) GetName.getItemWithName(room.getConsciousMercenaries(), targetName);
		if (target == null) {
			System.out.println("ERROR: " + targetName + " is not a valid person to talk to! Try again:");
			undergoUserInput();
		} else {
			
		}
	}
	
	private void resuscitate(String targetName) {
		Mercenary target = (Mercenary) GetName.getItemWithName(room.getUnconsciousMercenaries(), targetName);
		if (target == null) {
			System.out.println("ERROR: " + targetName + " is not a valid person to resuscitate! Try again:");
			undergoUserInput();
		} else {
			
		}
	}
	
	private void goTo(String targetName) {
		Room target = (Room) GetName.getItemWithName(room.getExits(), targetName);
		if (target == null) {
			System.out.println("ERROR: " + targetName + " is not a valid room to go to! Try again:");
			undergoUserInput();
		} else {
			
		}
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
