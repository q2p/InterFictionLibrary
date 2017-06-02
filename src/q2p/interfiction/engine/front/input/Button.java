package q2p.interfiction.engine.front.input;

import q2p.interfiction.engine.front.text.TextStyle;
import q2p.interfiction.engine.front.visual.Color;

public final class Button {
	public final Color background;
	public final TextStyle font;
	public final String text;
		
	public Button(final Color background, final TextStyle font, final String text) {
		this.background = background;
		this.font = font;
		this.text = text;
	}
}