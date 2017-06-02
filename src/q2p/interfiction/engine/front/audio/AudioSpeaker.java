package q2p.interfiction.engine.front.audio;

public final class AudioSpeaker {
	public final String name;
	
	public AudioTrack tack = null;
	
	public boolean looped;
	
	public AudioSpeaker(final String name) {
		this.name = name;
	}
}