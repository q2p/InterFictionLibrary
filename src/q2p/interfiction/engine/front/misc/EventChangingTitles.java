package q2p.interfiction.engine.front.misc;

import q2p.interfiction.engine.front.Event;

public final class EventChangingTitles extends Event {
	public EventChangingTitles(final String[] titles, final int[] milisecs) {
		super("changingTitles");
		
		if(titles == null)
			throw new NullPointerException("titles is null.");
		
		if(milisecs == null)
			throw new NullPointerException("milisecs is null.");
		
		if(titles.length != milisecs.length)
			throw new IndexOutOfBoundsException("Amount of titles and milisecs must be the same.");
		
		for(String title : titles) {
			if(title == null)
				throw new NullPointerException("titles contains null.");
		}
		
		for(int m : milisecs) {
			if(m < 1)
				throw new IllegalArgumentException("milisecs must be at least 1.");
		}
		
		
	}
}