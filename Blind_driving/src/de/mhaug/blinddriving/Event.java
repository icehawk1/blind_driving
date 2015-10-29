package de.mhaug.blinddriving;

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
