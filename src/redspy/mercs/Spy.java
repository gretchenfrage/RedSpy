package redspy.mercs;

import redspy.Map;
import redspy.Mercenary;

public class Spy extends Mercenary {

	public Spy(Map mapIn) {
		super(mapIn);
	}

	@Override
	public String getName() {
		return "Spy";
	}

	@Override
	public int getPerceptionModifier() {
		return 20;
	}

	@Override
	public String getBanter() {
		return "I'll find that amatuer fool, and rejoin him in hell.";
	}

}
