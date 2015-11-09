package redspy.mercs;

import java.util.ArrayList;

import redspy.Map;
import redspy.Mercenary;
import redspy.Room;

public class Medic extends Mercenary {

	public Medic(Map mapIn) {
		super(mapIn);
	}

	@Override
	public String getName() {
		return "Medic";
	}

	@Override
	public int getPerceptionModifier() {
		return 20;
	}

	@Override
	public ArrayList<Room> getDomain() {
		ArrayList<Room> out = super.getDomain();
		int n = out.size();
		for (int i = 0; i < n; i++) {
			out.add(getMap().getRoom(Map.RoomAccessor.MEDICLAB));
		}
		return out;
	}

	@Override
	public String getBanter() {
		return "Are ve ready to feel some schadenfreude, kamerad? Ha ha ha!";
	}

	@Override
	public void takePassiveTurn() {
		ArrayList<Mercenary> unconscious = getRoom().getUnconsciousMercenaries();
		if (unconscious.size() > 0) {
			unconscious.get((int) (Math.random() * unconscious.size())).setStatus(Mercenary.Status.NORMAL);
		} else {
			wander();
		}
	}

}
