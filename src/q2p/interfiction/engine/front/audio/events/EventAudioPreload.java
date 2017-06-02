package q2p.interfiction.engine.front.audio.events;

import q2p.interfiction.engine.front.Event;
import q2p.interfiction.engine.front.audio.AudioSpeaker;

public final class EventAudioPreload extends Event {
	public final AudioSpeaker speaker;
	
	public EventAudioPreload(final AudioSpeaker speaker) {
		super("aPreload");
		this.speaker = speaker;
	}
}