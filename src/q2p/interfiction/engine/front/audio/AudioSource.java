package q2p.interfiction.engine.front.audio;

import q2p.interfiction.engine.receivers.DataReceiver;

public class AudioSource {
	public final AudioType audioType;
	public final DataReceiver receiver;
	
	public AudioSource(final AudioType audioType, final DataReceiver receiver) {
		this.audioType = audioType;
		this.receiver = receiver;
	}
	
	public final void dispose() {
		receiver.dispose();
	}
}