package de.mhaug.blinddriving.simulator;

import de.mhaug.blinddriving.Event;
import de.mhaug.blinddriving.EventType;

public class Traffic_jam extends Situation {

	public Traffic_jam(DrivingSimulator simulator) {
		super(simulator);
	}

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
		simulator.sendEvent(new Event(EventType.INFO, "Reached 50 kph, stopping accelerating"));
	}

	@Override
	protected String getDescription() {
		return "There is a traffic jam";
	}
}
