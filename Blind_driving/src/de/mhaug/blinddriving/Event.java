package de.mhaug.blinddriving;

/**
 * This class is used to communicate between the UI and the Simulator. It should
 * be extended when needed.
 * 
 * @author martin
 */
public class Event {
	public final String description;
	public final EventType type;
	public final boolean vibrate_left;
	public final boolean vibrate_right;

	public Event(EventType type, String description) {
		this.description = description;
		this.type = type;
		this.vibrate_left = false;
		this.vibrate_right = false;
	}

	public Event(EventType type, String description, boolean vibrate_left, boolean vibrate_right) {
		this.description = description;
		this.type = type;
		this.vibrate_left = vibrate_left;
		this.vibrate_right = vibrate_right;
	}

	@Override
	public String toString() {
		return type + ": " + description;
	}
}
