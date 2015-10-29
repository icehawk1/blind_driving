package de.mhaug.blinddriving.ui;

import java.util.Observable;
import java.util.Observer;

import de.mhaug.blinddriving.Event;
import de.mhaug.blinddriving.EventType;
import de.mhaug.blinddriving.simulator.DrivingSimulator;

/**
 * This class gets notified when there is a new Event from the
 * {@link DrivingSimulator} and sends commands to the simulator when the Driver
 * has interacted with the car.
 */
public class EventListener extends Observable implements Runnable, Observer {

	@Override
	public void update(Observable source, Object rawEvent) {
		assert rawEvent instanceof Event;
		Event event = (Event) rawEvent;

		System.out.println("Event (" + event + ") occured on " + source);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.setChanged();
		this.notifyObservers(new Event(EventType.INFO, "Ich bin ein Event vom UI"));
	}
}
