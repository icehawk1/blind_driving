package de.mhaug.blinddriving.simulator;

import de.mhaug.blinddriving.Event;
import de.mhaug.blinddriving.EventType;

public class Motorbike_drives_by extends Situation {
	public Motorbike_drives_by(DrivingSimulator simulator) {
		super(simulator);
	}

	@Override
	protected void begin_situation() {
		simulator.sendEvent(new Event(EventType.INFO, "Traffic stops"));
		simulator.sendEvent(new Event(EventType.INFO, "Car stopping"));
		simulator.sendEvent(new Event(EventType.INFO, "Car waiting in queue"));
	}

	@Override
	protected void in_situation(int duration) {
		sleep(15);
		if (rand.nextBoolean())
			simulator.sendEvent(new Event(EventType.WARNING, "Motorcyclist driving by on left side", true, false));
		else
			simulator.sendEvent(new Event(EventType.WARNING, "Motorcyclist driving by on right side", false, true));
		sleep(5);
		simulator.sendEvent(new Event(EventType.INFO, "Vehicle ahead accelerates"));
		simulator.sendEvent(new Event(EventType.INFO, "Car accelerating to 15 kph"));
		System.out.println("Supervisor should step on brake now");
		sleep(30);
	}

	@Override
	protected void leave_situation() {
		simulator.sendEvent(new Event(EventType.INFO, "Accelerating to 50 kph"));
	}

	@Override
	protected String getDescription() {
		return "Motorbike drives by between two queues. The car thinks he can start and the supervisor has to stop him.";
	}
}
