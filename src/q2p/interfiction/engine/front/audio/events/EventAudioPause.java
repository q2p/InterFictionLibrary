package q2p.interfiction.engine.front.audio.events;

import q2p.interfiction.engine.front.Event;
import q2p.interfiction.engine.front.audio.AudioSpeaker;

public final class EventAudioPause extends Event {
	public final AudioSpeaker speaker;
	
	public EventAudioPause(final AudioSpeaker speaker) {
		super("aPause");
		this.speaker = speaker;
	}
}