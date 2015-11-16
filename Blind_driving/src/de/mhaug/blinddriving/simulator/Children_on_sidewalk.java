package de.mhaug.blinddriving.simulator;

import de.mhaug.blinddriving.Event;
import de.mhaug.blinddriving.EventType;

public class Children_on_sidewalk extends Situation {
	public Children_on_sidewalk(DrivingSimulator simulator) {
		super(simulator);
	}

	@Override
	protected void begin_situation() {
		if (rand.nextBoolean())
			simulator.sendEvent(new Event(EventType.WARNING, "Children on the left sidewalk", true, false));
		else
			simulator.sendEvent(new Event(EventType.WARNING, "Children on the right sidewalk", false, true));
		simulator.sendEvent(new Event(EventType.INFO, "Driving mode: Careful"));
		simulator.sendEvent(new Event(EventType.INFO, "Decelarating to 10 kph"));
	}

	@Override
	protected void in_situation(int duration) {
		sleep(30);
		simulator.sendEvent(new Event(EventType.WARNING, "Person on the street 13 meters ahead", true, true));
		simulator.sendEvent(new Event(EventType.INFO, "Stopping car"));
		sleep(20);
		simulator.sendEvent(new Event(EventType.INFO, "Person has left the street"));
		simulator.sendEvent(new Event(EventType.INFO, "Accelerating"));
		sleep(10);
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
