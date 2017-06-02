package q2p.interfiction.engine.front.audio;

import q2p.interfiction.engine.front.ContentType;

public enum AudioType implements ContentType {
	AUDIO_OGG("audio/ogg"),
	AUDIO_AAC("audio/aac"),
	AUDIO_WAV("audio/wav"),
	AUDIO_MPEG_MP3("audio/mpeg"),
	AUDIO_WEBM("audio/webm"),
	AUDIO_MP4("audio/mp4");
	
	private final String print;
	private AudioType(final String print) {
		this.print = print;
	}
	public final String print() {
		return print;
	}
}