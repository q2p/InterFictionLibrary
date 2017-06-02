package q2p.interfiction.engine.front;

import q2p.interfiction.engine.front.visual.Drawable;

public abstract class Clip {
	int y;
	
	int baseLine = 0;
	int baseWidth = 0;
	int baseHeight = 0;
	boolean isWhiteSpace = false;
	
	Drawable drawable = null;
}