package q2p.interfiction.engine.front.audio.events;

import q2p.interfiction.engine.front.Event;
import q2p.interfiction.engine.front.audio.AudioSpeaker;

public final class EventAudioDestroy extends Event {
	public final AudioSpeaker speaker;
	
	public EventAudioDestroy(final AudioSpeaker speaker) {
		super("aDestroy");
		this.speaker = speaker;
	}
}