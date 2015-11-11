package de.mhaug.blinddriving.simulator;

import de.mhaug.blinddriving.Event;
import de.mhaug.blinddriving.EventType;

public class StopSign extends Situation {

	@Override
	protected void begin_situation() {
	}

	@Override
	protected void in_situation(int duration) {
		simulator.sendEvent(new Event(EventType.INFO, "Stop sign ahead"));
		if (rand.nextBoolean())
			simulator.sendEvent(new Event(EventType.INFO, "Stopping vehicle"));
		else
			System.out.println("Supervisor should brake now");
		sleep(5);
	}

	@Override
	protected void leave_situation() {
		simulator.sendEvent(new Event(EventType.INFO, "Accelarating to 50 kph"));
	}

	@Override
	protected String getDescription() {
		return "There is a stop sign and we need to stop. If the car does not stop, the supervisor should.";
	}
}
