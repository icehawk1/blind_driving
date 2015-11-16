package de.mhaug.blinddriving.simulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import java.util.Scanner;

import de.mhaug.blinddriving.Event;

/**
 * This class simulates a journey with an autonomous car and sends out events
 * when the Car should communicate with the Driver. It also listens for commands
 * from the Driver.
 */
public class DrivingSimulator extends Observable implements Runnable, Observer {
	final List<Situation> possibleSituations = new ArrayList<>();
	private Random rand = new Random();

	public DrivingSimulator() {
		possibleSituations.add(new Children_on_sidewalk(this));
		possibleSituations.add(new Highway(this));
		possibleSituations.add(new StopSign(this));
		possibleSituations.add(new TrafficLight(this));
		possibleSituations.add(new Accident_ahead(this));
		possibleSituations.add(new Being_overtaken_on_wrong_side(this));
		possibleSituations.add(new Motorbike_drives_by(this));
		possibleSituations.add(new Traffic_jam(this));
	}

	@Override
	public void run() {
		try {
			runActually();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void runActually() throws InterruptedException {
		Scanner stdin = new Scanner(System.in);
		Collections.shuffle(possibleSituations);
		for (Situation current : possibleSituations) {
			System.out.println("-------------------------------------------");
			System.out.println(current.getDescription());
			System.out.println("----------");
			System.out.println();

			current.begin_situation();
			current.in_situation(rand.nextInt(120));
			current.leave_situation();

			System.out.println("Please press enter for the next situation");
			stdin.nextLine();
		}
		System.out.println("We are finished. :)");
		stdin.close();
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
