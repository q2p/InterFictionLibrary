package q2p.interfiction.engine.front.audio.events;

import q2p.interfiction.engine.front.Event;
import q2p.interfiction.engine.front.audio.AudioSpeaker;

public final class EventAudioCreate extends Event {
	public final AudioSpeaker speaker;
	
	public EventAudioCreate(final AudioSpeaker speaker) {
		super("aCreate");
		this.speaker = speaker;
	}
}