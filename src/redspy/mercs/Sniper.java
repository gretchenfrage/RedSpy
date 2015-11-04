package redspy.mercs;

import java.util.ArrayList;

import redspy.Map;
import redspy.Mercenary;
import redspy.Room;

public class Sniper extends Mercenary {

	public Sniper(Map mapIn) {
		super(mapIn);
	}

	@Override
	public String getName() {
		return "Sniper";
	}

	@Override
	public ArrayList<Room> getDomain() {
		ArrayList<Room> out = new ArrayList<Room>();
		out.add(getMap().getRoom(Map.RoomAccessor.SNIPERFORT));
		return out;
	}

	@Override
	public String getBanter() {
		return "I'll be sitting right here, and when I see that spy, I'm gonna blow the inside of their head all over four counties!";
	}

}
