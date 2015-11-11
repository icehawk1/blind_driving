package de.mhaug.blinddriving.simulator;

import de.mhaug.blinddriving.Event;
import de.mhaug.blinddriving.EventType;

public class Traffic_jam extends Situation {

	@Override
	protected void begin_situation() {
	}

	@Override
	protected void in_situation(int duration) {
		simulator.sendEvent(new Event(EventType.INFO, "Vehicle ahead is decelerating"));
		simulator.sendEvent(new Event(EventType.INFO, "Decelerating to speed of vehicle ahead"));
		sleep(15);
		simulator.sendEvent(new Event(EventType.INFO, "Traffic stops"));
		sleep(40);
		simulator.sendEvent(new Event(EventType.INFO, "Vehicle ahead is accelerating"));
		simulator.sendEvent(new Event(EventType.INFO, "Accelerating to speed of vehicle ahead"));
		sleep(10);
	}

	@Override
	protected void leave_situation() {
		simulator.sendEvent(new Event(EventType.INFO, "Reached 50 kph"));
	}

}
