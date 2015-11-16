package de.mhaug.blinddriving;

import de.mhaug.blinddriving.simulator.DrivingSimulator;
import de.mhaug.blinddriving.ui.EventListener;

/**
 * This class starts the Prototype and adds the UI/Simulator as Observer of each
 * other. The later means that they can send and receive Events from each other.
 */
public class Main {

	public static void main(String[] args) {
		EventListener uiEventListener = new EventListener();
		DrivingSimulator simulator = new DrivingSimulator();

		simulator.addObserver(uiEventListener);
		uiEventListener.addObserver(simulator);

		Thread drivingSimulatorThread = new Thread(simulator);
		drivingSimulatorThread.setName("Driving Simulator");
		drivingSimulatorThread.start();

		Thread uiThread = new Thread(uiEventListener);
		uiThread.setName("User interface");
		uiThread.start();
	}
}
