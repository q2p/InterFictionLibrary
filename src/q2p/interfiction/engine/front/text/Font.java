package q2p.interfiction.engine.front.text;

public class Font {
	public final FontType type;
	public final byte[] data;
	
	public Font(final FontType type, final byte[] data) {
		this.type = type;
		this.data = data;
	}
}
