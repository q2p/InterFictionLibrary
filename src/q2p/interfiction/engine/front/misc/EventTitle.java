package q2p.interfiction.engine.front.misc;

import q2p.interfiction.engine.front.Event;

public final class EventTitle extends Event {
	public EventTitle(final String title) {
		super("title");
		if(title == null)
			throw new NullPointerException("title is null.");
	}
}