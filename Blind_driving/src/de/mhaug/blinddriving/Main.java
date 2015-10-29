package de.mhaug.blinddriving;

import de.mhaug.blinddriving.simulator.DrivingSimulator;
import de.mhaug.blinddriving.ui.EventListener;

public class Main {

	public static void main(String[] args) {
		DrivingSimulator drivingSimulator = new DrivingSimulator();
		EventListener uiEventListener = new EventListener();

		drivingSimulator.addObserver(uiEventListener);
		uiEventListener.addObserver(drivingSimulator);

		Thread drivingSimulatorThread = new Thread(drivingSimulator);
		drivingSimulatorThread.setName("Driving Simulator");
		drivingSimulatorThread.start();

		Thread uiThread = new Thread(uiEventListener);
		uiThread.setName("User interface");
		uiThread.start();
	}
}
