package q2p.interfiction.engine.front.text.events;

import q2p.interfiction.engine.front.Event;

public final class EventPause extends Event {
	public EventPause(final int milisec) {
		super("pause");
	}
}