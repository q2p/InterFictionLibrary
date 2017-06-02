package q2p.interfiction.engine.front.visual;

public class Video extends Visual {
	public final byte[] data;
	
	public Video(final ImageType imageType, final byte[] data) {
		this.data = data;
	}
}