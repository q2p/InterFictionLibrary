package q2p.interfiction.engine.front.audio.events;

import q2p.interfiction.engine.front.Event;
import q2p.interfiction.engine.front.audio.AudioSpeaker;

public final class EventAudioWaitFor extends Event {
	public final AudioSpeaker speaker;
	
	public EventAudioWaitFor(final AudioSpeaker speaker) {
		super("aWait");
		this.speaker = speaker;
	}
}