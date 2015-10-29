package de.mhaug.blinddriving.simulator;

import java.util.Observable;
import java.util.Observer;

import de.mhaug.blinddriving.Event;
import de.mhaug.blinddriving.EventType;

/**
 * This class simulates a journey with an autonomous car and sends out events
 * when the Car should communicate with the Driver. It also listens for commands
 * from the Driver.
 */
public class DrivingSimulator extends Observable implements Runnable, Observer {
	@Override
	public void run() {
		try {
			runActually();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void runActually() throws InterruptedException {
		sendEvent(EventType.INFO, "Starting engine");
		sendEvent(EventType.INFO, "Fuel at 80 percent");
		sendEvent(EventType.INFO, "Status normal, no defects");
		Thread.sleep(10000);

		sendEvent(EventType.INFO, "Road clean, sunny weather, no pedestrians, low traffic");
		Thread.sleep(2000);
		sendEvent(EventType.INFO, "Entering road");
		sendEvent(EventType.INFO, "Drive mode: Normal");
		sendEvent(EventType.INFO, "Driving at 50 kph");

		Thread.sleep(5000);
		sendEvent(EventType.INFO, "Decelerating to 20 kph");
		Thread.sleep(1000);
		sendEvent(EventType.INFO, "Turning left into Bond street");
		Thread.sleep(3000);
		sendEvent(EventType.INFO, "Accelarating to 50 kph");

		Thread.sleep(30000);
		sendEvent(EventType.INFO, "Children on the sidewalk");
		sendEvent(EventType.INFO, "Drive mode: Careful");
		sendEvent(EventType.INFO, "Decelarating to 20 kph");
		Thread.sleep(10000);
		sendEvent(EventType.INFO, "Drive mode: Normal");
		sendEvent(EventType.INFO, "Accelarating to 50 kph");

		Thread.sleep(40000);
		sendEvent(EventType.INFO, "Target on left side");
		sendEvent(EventType.INFO, "Parking");
		Thread.sleep(30000);
		sendEvent(EventType.INFO, "You can turn the engine off now");
	}

	private void sendEvent(EventType type, String description) {
		this.setChanged();
		this.notifyObservers(new Event(type, description));
	}

	@Override
	public void update(Observable source, Object rawEvent) {
		assert rawEvent instanceof Event;
		Event event = (Event) rawEvent;

		System.out.println("Event (" + event + ") occured on " + source);
	}
}
