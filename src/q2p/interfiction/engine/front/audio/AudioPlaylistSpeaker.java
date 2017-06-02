package q2p.interfiction.engine.front.audio;

import java.util.LinkedList;

public final class AudioPlaylistSpeaker {
	public final String name;
	
	public LinkedList<AudioTrack> tacks = new LinkedList<AudioTrack>();
	
	public final boolean randomized;
	
	public AudioPlaylistSpeaker(final String name, final boolean randomized) {
		this.name = name;
		
		this.randomized = randomized;
	}
}