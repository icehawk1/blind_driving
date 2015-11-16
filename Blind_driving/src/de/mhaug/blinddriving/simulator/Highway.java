package de.mhaug.blinddriving.simulator;

import de.mhaug.blinddriving.Event;
import de.mhaug.blinddriving.EventType;

public class Highway extends Situation {
	@Override
	protected void begin_situation() {
		simulator.sendEvent(new Event(EventType.INFO, "Entering highway A42"));
		sleep(40);
		simulator.sendEvent(new Event(EventType.INFO, "Accelerating to 130 kph"));
		simulator.sendEvent(new Event(EventType.INFO, "Medium traffic"));
		simulator.sendEvent(new Event(EventType.INFO, "There are three trucks ahead of ous"));
	}

	@Override
	protected void in_situation(int duration) {
		sleep(rand.nextInt(120));
		simulator.sendEvent(new Event(EventType.INFO, "Overtaking three trucks"));
		sleep(30);
	}

	@Override
	protected void leave_situation() {
		simulator.sendEvent(new Event(EventType.INFO, "Leaving highway A42"));
		simulator.sendEvent(new Event(EventType.INFO, "Decelarating to 80 kph"));
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	protected String getDescription() {
		return "We are on a highway and overtake three trucks";
	}
}
