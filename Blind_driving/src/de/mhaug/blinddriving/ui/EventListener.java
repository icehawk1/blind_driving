package de.mhaug.blinddriving.ui;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import de.mhaug.blinddriving.Event;
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

		// System.out.println("Event (" + event + ") occuredgggg on " + source);

		speakOut(event.getText());
		if (event.getSignalLeft() || event.getSignalRight()) {
			// waiting for signals from event to assign left or right
			controlVibrate(event.getSignalLeft(), event.getSignalRight());
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setChanged();
	}

	public void speakOut(String text) {
		System.setProperty("mbrola.base", "./res/mbrola");
		String voiceName = "kevin"; // kevin, kevin16, alan, mbrola_us1,
		// mbrola_us2, mbrola_us3
		Voice voice;
		VoiceManager vm = VoiceManager.getInstance();
		voice = vm.getVoice(voiceName);

		voice.allocate();

		try {
			voice.speak(text);
		} catch (Exception e) {
			System.out.println("Error speakout: " + e);
		}

	}

	public void controlVibrate(boolean left, boolean right) {
		try {
			Clip clip = AudioSystem.getClip();
			File file;
			if (left && right) {
				file = new File("res/audio_C.wav");
			} else if (left) {
				file = new File("res/audio_L.wav");
			} else {
				file = new File("res/audio_R.wav");
			}
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(file);
			clip.open(inputStream);
			clip.start();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
