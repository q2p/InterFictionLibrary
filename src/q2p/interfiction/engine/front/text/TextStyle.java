package q2p.interfiction.engine.front.text;

import q2p.interfiction.engine.front.visual.Color;

public class TextStyle {
	public final Font font;
	public final Color color;
	public final float size;
	
	private TextStyle(final Font font, final Color color, final float size) {
		this.font = font;
		this.color = color;
		this.size = size;
	}
}