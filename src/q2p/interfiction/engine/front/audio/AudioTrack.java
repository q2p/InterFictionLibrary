package q2p.interfiction.engine.front.audio;

public final class AudioTrack {
	public final AudioSource[] audiosSources;
	
	public AudioTrack(final AudioSource ... audiosSources) {
		this.audiosSources = audiosSources;
	}
}