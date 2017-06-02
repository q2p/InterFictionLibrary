package q2p.interfiction.engine.front.input;

import q2p.interfiction.engine.front.Event;

public final class EventButtonsSelect extends Event {
	public EventButtonsSelect(final Button ... buttons) {
		super("buttons");
	}
}