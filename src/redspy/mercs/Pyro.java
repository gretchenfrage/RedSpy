package redspy.mercs;

import redspy.Map;
import redspy.Mercenary;

public class Pyro extends Mercenary {

	public Pyro(Map mapIn) {
		super(mapIn);
	}

	@Override
	public int getCombatModifier() {
		return 20;
	}

	@Override
	public String getName() {
		return "Pyro";
	}

	@Override
	public int getPerceptionModifier() {
		return -15;
	}

	@Override
	public String getBanter() {
		return "Murr hurr mphuphurrur, hurr mph phrr.";
	}

}
