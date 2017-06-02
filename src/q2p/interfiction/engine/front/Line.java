package q2p.interfiction.engine.front;

import java.util.ArrayList;
import java.util.LinkedList;

public final class Line {
	Clip prefix;
	final ArrayList<Clip> elements = new ArrayList<Clip>();
	final ArrayList<Clip[]> subLines = new ArrayList<Clip[]>();

	int horizontalMargin = 1;
	int verticalMargin = 1;
	
	int height;
	
	public final void presize(int y, final int leftOffset, final int avilableWidth, final int scale) {
		subLines.clear();
		
		LinkedList<Clip> stack = new LinkedList<Clip>(elements);
		
		int widthLeft = avilableWidth;
		
		LinkedList<Clip> line = new LinkedList<Clip>();
		
		boolean hasLine = false;
		
		while(!stack.isEmpty()) {
			final LinkedList<Clip> word = pullWord(stack);
			
			while(!word.isEmpty()) {
				widthLeft = squezeWord(line, word, widthLeft);
				
				if(widthLeft == 0) {
					widthLeft = avilableWidth;
					final Clip[] fitedLine = new Clip[line.size()];
					
					int i = 0;
					for(final Clip c : line)
						fitedLine[i++] = c;
					
					line.clear();

					height += resizeHeight(y + height, fitedLine);
					
					if(hasLine)
						height += horizontalMargin;
					else
						hasLine = true;
					
					subLines.add(fitedLine);
				}
			}
		}
	}

	private final int resizeHeight(int y, final Clip[] subLine) {
		int maxTop = 0;
		int maxBottom = 0;
		int hh = 0;
		
		for(Clip clip : subLine) {
			if(clip.baseLine > maxTop)
				maxTop = clip.baseLine;
			
			hh = clip.baseHeight - clip.baseLine;
			if(hh > maxBottom)
				maxBottom = hh;
		}
		
		for(Clip clip : subLine)
			clip.y = y + (maxTop - clip.baseLine);
		
		return maxTop + maxBottom;
	}

	private final int squezeWord(final LinkedList<Clip> line, final LinkedList<Clip> word, int widthLeft) {
		if(line.isEmpty()) {
			int width;
			while(!word.isEmpty()) {				
				width = word.getFirst().baseWidth + verticalMargin;
				
				if(width > widthLeft)
					break;
				
				widthLeft -= width;
				line.addLast(word.removeFirst());
			}
		} else {
			int width = 0;
			for(final Clip clip : word)
				width += clip.baseWidth + verticalMargin;
			
			if(width > widthLeft)
				return 0;
			
			for(final Clip clip : word) {
				widthLeft -= clip.baseWidth + verticalMargin;
				line.addLast(clip);
			}
			
			word.clear();
		}
		
		return widthLeft;
	}

	private static final LinkedList<Clip> pullWord(final LinkedList<Clip> stack) {
		final LinkedList<Clip> word = new LinkedList<Clip>();
		
		Clip clip;
		
		do {
			clip = word.getFirst();
			if(!clip.isWhiteSpace)
				break;
			
			word.addLast(stack.removeFirst());
		} while(!stack.isEmpty());
		
		boolean sawWhiteSpace = false;
		
		while(!stack.isEmpty()) {
			clip = word.getFirst();
			
			if(sawWhiteSpace && !clip.isWhiteSpace) {
				break;
			} else if(!sawWhiteSpace && clip.isWhiteSpace) {
				sawWhiteSpace = true;
			}
			
			word.addLast(stack.removeFirst());
		}
		
		return word;
	}
}