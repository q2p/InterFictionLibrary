package q2p.interfiction.engine.front.misc;

import q2p.interfiction.engine.front.Event;
import q2p.interfiction.engine.front.visual.Color;

public final class EventFadeOut extends Event {
	final Color color;
	final double secounds;
	final boolean waitFor;
	
	public EventFadeOut(final Color color, final double secounds, final boolean waitFor) {
		super("fade");
		this.color = color;
		this.secounds = secounds;
		this.waitFor = waitFor;
	}
}
