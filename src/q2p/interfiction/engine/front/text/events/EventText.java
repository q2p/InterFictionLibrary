package q2p.interfiction.engine.front.text.events;

import q2p.interfiction.engine.front.Event;
import q2p.interfiction.engine.front.audio.AudioSource;
import q2p.interfiction.engine.front.text.TextStyle;
import q2p.interfiction.engine.front.text.TextType;

public final class EventText extends Event {
	public EventText(final AudioSource typeSound, final TextStyle font, final TextType type, final int showTimeMilisec, final String message) {
		super("tWrite");
	}
}