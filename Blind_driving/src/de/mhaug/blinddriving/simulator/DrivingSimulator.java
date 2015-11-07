package de.mhaug.blinddriving.simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import de.mhaug.blinddriving.Event;

/**
 * This class simulates a journey with an autonomous car and sends out events
 * when the Car should communicate with the Driver. It also listens for commands
 * from the Driver.
 */
public class DrivingSimulator extends Observable implements Runnable, Observer {
	final List<Situation> possibleSituations = new ArrayList<>();
	private static volatile DrivingSimulator instance = null;

	private DrivingSimulator() {
	}

	@Override
	public void run() {
		try {
			runActually();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static synchronized DrivingSimulator getInstance() {
		if (instance == null) {
			instance = new DrivingSimulator();
		}

		return instance;
	}

	private void runActually() throws InterruptedException {

	}

	void sendEvent(Event event) {
		this.setChanged();
		this.notifyObservers(event);
	}

	@Override
	public void update(Observable source, Object rawEvent) {
		assert rawEvent instanceof Event;
		Event event = (Event) rawEvent;

		System.out.println("Event (" + event + ") occured on " + source);
	}
}
