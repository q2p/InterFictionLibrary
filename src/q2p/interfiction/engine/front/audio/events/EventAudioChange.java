package q2p.interfiction.engine.front.audio.events;

import q2p.interfiction.engine.front.Event;
import q2p.interfiction.engine.front.audio.AudioSpeaker;
import q2p.interfiction.engine.front.audio.AudioTrack;

public final class EventAudioChange extends Event {
	public final AudioSpeaker speaker;
	public final AudioTrack track;
	
	public EventAudioChange(final AudioSpeaker speaker, final AudioTrack track) {
		super("aChange");
		this.speaker = speaker;
		this.track = track;
	}
}