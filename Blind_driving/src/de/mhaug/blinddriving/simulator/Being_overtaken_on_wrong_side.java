package de.mhaug.blinddriving.simulator;

import de.mhaug.blinddriving.Event;
import de.mhaug.blinddriving.EventType;

public class Being_overtaken_on_wrong_side extends Situation {
	public Being_overtaken_on_wrong_side(DrivingSimulator simulator) {
		super(simulator);
	}

	@Override
	protected void begin_situation() {
		simulator.sendEvent(new Event(EventType.INFO, "Vehicle approaching on the left lane with 80 kph"));
	}

	@Override
	protected void in_situation(int duration) {
		sleep(5 + rand.nextInt(15));
		simulator.sendEvent(new Event(EventType.WARNING, "Vehicle overtaking on left side with 80 kph", true, false));
		sleep(rand.nextInt(15));
	}

	@Override
	protected void leave_situation() {
	}

	@Override
	protected String getDescription() {
		return "A vehicle is overtaking on the wrong side";
	}
}
