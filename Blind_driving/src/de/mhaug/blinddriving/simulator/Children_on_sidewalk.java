package de.mhaug.blinddriving.simulator;

import de.mhaug.blinddriving.Event;
import de.mhaug.blinddriving.EventType;

public class Children_on_sidewalk extends Situation {
	@Override
	protected void begin_situation() {
		if (rand.nextBoolean())
			simulator.sendEvent(new Event(EventType.WARNING, "Children on the left sidewalk", true, false));
		else
			simulator.sendEvent(new Event(EventType.WARNING, "Children on the right sidewalk", false, true));
		simulator.sendEvent(new Event(EventType.INFO, "Driving mode: Careful"));
		simulator.sendEvent(new Event(EventType.INFO, "Decelarating to 20 kph"));
	}

	@Override
	protected void in_situation(int duration) {
		if (rand.nextBoolean()) {
			sleep(rand.nextInt((int) (duration * 0.8)));
			simulator.sendEvent(new Event(EventType.WARNING, "Person on the street in 13 meters", true, true));
		} else
			sleep(duration);
	}

	@Override
	protected void leave_situation() {
		simulator.sendEvent(new Event(EventType.INFO, "Drive mode: Normal"));
		simulator.sendEvent(new Event(EventType.INFO, "Accelarating to 50 kph"));
	}

	@Override
	public String toString() {
		return "There are children on the sidewalk";
	}

	@Override
	protected String getDescription() {
		return "There are children on the sidewalk and we need to drive carefully";
	}
}
