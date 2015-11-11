package de.mhaug.blinddriving.simulator;

import de.mhaug.blinddriving.Event;
import de.mhaug.blinddriving.EventType;

public class Being_overtaken_on_wrong_side extends Situation {

	@Override
	protected void begin_situation() {
		simulator.sendEvent(new Event(EventType.INFO, "Vehicle approaching on the right lane with 80 kph"));
	}

	@Override
	protected void in_situation(int duration) {
		sleep(5 + rand.nextInt(15));
		simulator.sendEvent(new Event(EventType.WARNING, "Vehicle overtaking on right side with 80", false, true));
		sleep(rand.nextInt(15));
	}

	@Override
	protected void leave_situation() {
	}
}
