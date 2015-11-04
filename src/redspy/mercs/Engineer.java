package redspy.mercs;

import java.util.ArrayList;

import redspy.Map;
import redspy.Mercenary;
import redspy.Room;

public class Engineer extends Mercenary {

	public Engineer(Map mapIn) {
		super(mapIn);
	}

	@Override
	public String getName() {
		return "Engineer";
	}

	@Override
	public ArrayList<Room> getDomain() {
		ArrayList<Room> out = new ArrayList<Room>();
		out.add(getMap().getRoom(Map.RoomAccessor.PLAZA));
		out.add(getMap().getRoom(Map.RoomAccessor.MAINROOM));
		out.add(getMap().getRoom(Map.RoomAccessor.FRONTROOM));
		out.add(getMap().getRoom(Map.RoomAccessor.INTEL));
		return out;
	}

	@Override
	public String getBanter() {
		return "Howdy pardner, ya haven't happened to see a red spy anywhere, I don't reckon?";
	}

	//TODO: implement sentry tier system
	
}
