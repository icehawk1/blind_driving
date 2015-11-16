package de.mhaug.blinddriving.simulator;

import de.mhaug.blinddriving.Event;
import de.mhaug.blinddriving.EventType;

public class Accident_ahead extends Situation {

	@Override
	protected void begin_situation() {

	}

	@Override
	protected void in_situation(int duration) {
		simulator.sendEvent(new Event(EventType.INFO, "Vehicle on sideline", true, false));
		sleep(5 + rand.nextInt(5));
		simulator.sendEvent(new Event(EventType.INFO, "Vehicle on sideline has emergency lights on"));
		System.out.println("Supervisor should brake now");
		sleep(5);
		simulator.sendEvent(new Event(EventType.INFO, "Person lying on sideline"));
	}

	@Override
	protected void leave_situation() {

	}

	@Override
	protected String getDescription() {
		return "There is an accident and we need to stop and help. The car does not realise that.";
	}

}
