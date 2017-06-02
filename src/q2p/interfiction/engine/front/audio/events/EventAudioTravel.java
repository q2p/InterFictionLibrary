package q2p.interfiction.engine.front.audio.events;

import q2p.interfiction.engine.front.Event;
import q2p.interfiction.engine.front.audio.AudioSpeaker;

public final class EventAudioTravel extends Event {
	public final AudioSpeaker speaker;
	public final double secounds;
	
	public EventAudioTravel(final AudioSpeaker speaker, final double secounds) {
		super("aTravel");
		this.speaker = speaker;
		this.secounds = secounds;
	}
}