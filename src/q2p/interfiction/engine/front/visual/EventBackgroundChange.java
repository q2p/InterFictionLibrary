package q2p.interfiction.engine.front.visual;

import q2p.interfiction.engine.front.Event;
import q2p.interfiction.engine.front.Scenary;

public final class EventBackgroundChange extends Event {
	public final Drawable newBackground;
	
	public EventBackgroundChange(final float time, final Drawable newBackground) {
		super(0);
		this.newBackground = newBackground;
	}

	public void fire() {
		Scenary.background = newBackground;
	}
}