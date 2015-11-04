package redspy.mercs;

import redspy.Map;
import redspy.Mercenary;

public class Soldier extends Mercenary {

	public Soldier(Map mapIn) {
		super(mapIn);
	}

	@Override
	public int getPerceptionModifier() {
		return -30;
	}

	@Override
	public String getName() {
		return "Soldier";
	}

	@Override
	public int getCombatModifier() {
		return 35;
	}

	@Override
	public String getBanter() {
		return "Let's go get that maggot! Bon voyage, crouton!";
	}

}
