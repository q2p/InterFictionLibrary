package q2p.interfiction.engine.front.audio.events;

import q2p.interfiction.engine.front.Event;
import q2p.interfiction.engine.front.audio.AudioSpeaker;

public final class EventAudioPlay extends Event {
	public final AudioSpeaker speaker;
	
	public EventAudioPlay(final AudioSpeaker speaker) {
		super("aPlay");
		this.speaker = speaker;
	}
}