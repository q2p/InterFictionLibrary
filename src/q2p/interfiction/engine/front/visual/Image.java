package q2p.interfiction.engine.front.visual;

public class Image extends Visual {
	public final byte[] data;
	
	public Image(final ImageType imageType, final byte[] data) {
		this.data = data;
	}
}