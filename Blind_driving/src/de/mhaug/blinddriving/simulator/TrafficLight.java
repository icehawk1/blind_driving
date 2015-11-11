package de.mhaug.blinddriving.simulator;

import de.mhaug.blinddriving.Event;
import de.mhaug.blinddriving.EventType;

public class TrafficLight extends Situation {

	@Override
	protected void begin_situation() {
		simulator.sendEvent(new Event(EventType.INFO, "Green traffic light ahead"));
	}

	@Override
	protected void in_situation(int duration) {
		sleep(10);
		simulator.sendEvent(new Event(EventType.INFO, "Traffic light turns yellow"));
		simulator.sendEvent(new Event(EventType.INFO, "Stopping vehicle"));
		simulator.sendEvent(new Event(EventType.INFO, "Traffic light turns red"));
		sleep(rand.nextInt(50));
	}

	@Override
	protected void leave_situation() {
		simulator.sendEvent(new Event(EventType.INFO, "Traffic light turns green"));
		simulator.sendEvent(new Event(EventType.INFO, "Accelerating to 50 kph"));
	}

	@Override
	protected String getDescription() {
		return "We stop before a traffic light";
	}
}
