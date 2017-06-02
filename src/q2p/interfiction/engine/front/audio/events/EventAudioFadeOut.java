package q2p.interfiction.engine.front.audio.events;

import q2p.interfiction.engine.front.Event;
import q2p.interfiction.engine.front.audio.AudioSpeaker;

public final class EventAudioFadeOut extends Event {
	public final AudioSpeaker speaker;
	public final double secounds;
	public final boolean waitFor;
	
	public EventAudioFadeOut(final AudioSpeaker speaker, final double secounds, final boolean waitFor) {
		super("aFade");
		this.speaker = speaker;
		this.secounds = secounds;
		this.waitFor = waitFor;
	}
}