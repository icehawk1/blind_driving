package de.mhaug.blinddriving.simulator;

import de.mhaug.blinddriving.Event;
import de.mhaug.blinddriving.EventType;

public class Motorbike_drives_by extends Situation {

	@Override
	protected void begin_situation() {
		simulator.sendEvent(new Event(EventType.INFO, "Traffic stops"));
		simulator.sendEvent(new Event(EventType.INFO, "Car stopping"));
		simulator.sendEvent(new Event(EventType.INFO, "Vehicles stopping in queues left and right"));
	}

	@Override
	protected void in_situation(int duration) {
		sleep(rand.nextInt(15));
		simulator.sendEvent(new Event(EventType.WARNING, "Motorcyclist driving by on left side", true, false));
		sleep(3);
		if (rand.nextBoolean()) {
			simulator.sendEvent(new Event(EventType.INFO, "Car accelerating to 15 kph"));
			System.out.println("Supervisor should step on brake now");
		}
		sleep(rand.nextInt(40));
	}

	@Override
	protected void leave_situation() {
		simulator.sendEvent(new Event(EventType.INFO, "Vehicle ahead accelerates"));
		sleep(5);
		simulator.sendEvent(new Event(EventType.INFO, "Accelerating to 50 kph"));
	}

}
