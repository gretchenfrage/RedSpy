package redspy.mercs;

import redspy.Map;
import redspy.Mercenary;

public class Heavy extends Mercenary {

	public Heavy(Map mapIn) {
		super(mapIn);
	}

	@Override
	public String getName() {
		return "Heavy";
	}

	@Override
	public int getCombatModifier() {
		return 30;
	}

	@Override
	public String getBanter() {
		return "Some spies think they can outsmart me... Maybe... I have yet to see spy who can outsmart bullet!";
	}

}
