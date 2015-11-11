package de.mhaug.blinddriving.simulator;

import java.util.Random;

abstract class Situation {
	protected final Random rand = new Random();
	private int time_remaining;
	protected final DrivingSimulator simulator = DrivingSimulator.getInstance();

	public final void generateEvents(int duration) {
		assert duration > 4;
		time_remaining = duration;

		begin_situation();
		sleep(2);
		in_situation(duration - 4);
		sleep(2);
		leave_situation();
	}

	protected abstract void begin_situation();

	protected abstract void in_situation(int duration);

	protected abstract void leave_situation();

	protected abstract String getDescription();

	public void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
			time_remaining -= seconds;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getRemainingTime() {
		return time_remaining;
	}
}
