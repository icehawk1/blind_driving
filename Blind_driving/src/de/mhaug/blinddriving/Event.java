package de.mhaug.blinddriving;

/**
 * This class is used to communicate between the UI and the Simulator. It should
 * be extended when needed.
 * 
 * @author martin
 *
 */
public class Event {
	public final String description;
	public final EventType type;

	public Event(EventType type, String description) {
		this.description = description;
		this.type = type;
	}

	@Override
	public String toString() {
		return type + ": " + description;
	}
}
