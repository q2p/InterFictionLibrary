package q2p.interfiction.engine.front.visual;

import q2p.interfiction.engine.front.ContentType;

public enum ImageType implements ContentType {
	;
	
	private final String print;
	private ImageType(final String print) {
		this.print = print;
	}
	public final String print() {
		return print;
	}
}