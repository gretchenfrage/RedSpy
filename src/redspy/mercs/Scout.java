package redspy.mercs;

import redspy.Map;
import redspy.Mercenary;

public class Scout extends Mercenary {

	public Scout(Map mapIn) {
		super(mapIn);
	}

	@Override
	public String getName() {
		return "Scout";
	}

	@Override
	public String getBanter() {
		return "Come on come on! Let's go batter up that knucklehead!";
	}

}
