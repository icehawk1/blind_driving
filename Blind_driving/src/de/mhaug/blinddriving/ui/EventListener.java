package de.mhaug.blinddriving.ui;

import java.util.Observable;
import java.util.Observer;

import java.io.*;
import com.sun.speech.freetts.*;

import javax.sound.sampled.*;

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

//		System.out.println("Event (" + event + ") occuredgggg on " + source);
		speakOut(event.getText());
		if(event.getSignalLeft() || event.getSignalRight()){
			// waiting for signals from event to assign left or right
			controlVibrate(event.getSignalLeft(),event.getSignalRight()); 
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
		this.notifyObservers(new Event(EventType.INFO, "Ich bin ein Event vom UI"));
	}
	
	public void speakOut(String text){
		String voiceName = "kevin16"; // kevin, kevin16, alan
		Voice voice;
		VoiceManager vm = VoiceManager.getInstance();
		voice = vm.getVoice(voiceName);
		
		voice.allocate();
		
		try{
			voice.speak(text);
		}catch(Exception e){
			System.out.println("Error speakout: "+e);
		}
		
	}
	
	public void controlVibrate(boolean left, boolean right){
		
		try {
			Clip clip = AudioSystem.getClip();
			File file;
			if(left && right){
				file = new File("res/audio_C.wav");
			} else if(left){
				file = new File("res/audio_L.wav");
			} else{
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
