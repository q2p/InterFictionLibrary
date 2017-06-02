package q2p.interfiction.engine.front.visual;

import q2p.interfiction.engine.front.ContentType;

public enum VideoType implements ContentType {
	;
	
	private final String print;
	private VideoType(final String print) {
		this.print = print;
	}
	public final String print() {
		return print;
	}
}