package q2p.interfiction.engine.front.text;

import q2p.interfiction.engine.front.ContentType;

public enum FontType implements ContentType {
	;
	
	private final String print;
	private FontType(final String print) {
		this.print = print;
	}
	public final String print() {
		return print;
	}
}