package q2p.interfiction.engine;

import q2p.interfiction.engine.front.Event;

public final class IFW {
	private static boolean wasInitilized = false;
	private static boolean wasDestroyed = false;
	
	public static final void initilize(final String title, final CloseListener closeListener) {
		if(wasDestroyed)
			throw new RuntimeException("Server can't be restarted.");
		
		if(wasInitilized)
			throw new RuntimeException("Server is already started.");

		wasInitilized = true;

		Logic.initilze(title, closeListener);
	}
		
	public static final void initilize(final String title) {
		initilize(title, null);
	}
	
	// TODO: synchronized
	public static synchronized final void destroy() {
		if(wasDestroyed)
			throw new RuntimeException("Server was already destroyed.");
		
		if(!wasInitilized)
			throw new RuntimeException("Server was not initilized.");
		
		wasDestroyed = true;
		wasInitilized = false;
		Logic.destroy();
	}

	public static final void pushEvents(final Event ... events) { 
		checkStates();
		
		if(events == null)
			throw new NullPointerException("events is null.");
	}
	
	private static final void checkStates() {
		if(wasDestroyed)
			throw new RuntimeException("Server was destroyed.");
		
		if(!wasInitilized)
			throw new RuntimeException("Server was not initilized.");
	}
}