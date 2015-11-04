package redspy.mercs;

import redspy.Map;
import redspy.Mercenary;

public class Demo extends Mercenary {

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
	
	//TODO: implement stickybomb buff

}
