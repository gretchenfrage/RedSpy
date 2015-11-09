package redspy.mercs;

import redspy.Map;
import redspy.Mercenary;

public class Demo extends Mercenary {

	private boolean stickysDeployed = false;
	
	public Demo(Map mapIn) {
		super(mapIn);
	}

	@Override
	public String getName() {
		return "Demo";
	}

	@Override
	public String getBanter() {
		return "Bloody spies, infesting the damn place like rats, I'll teach em'...";
	}

	@Override
	public int getCombatModifier() {
		if (stickysDeployed) {
			stickysDeployed = false;
			return 30;
		} else {
			return 0;
		}
	}

	@Override
	public void takePassiveTurn() {
		stickysDeployed = true;
	}

}
