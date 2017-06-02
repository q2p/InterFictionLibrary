package q2p.interfiction.engine;

import q2p.interfiction.engine.front.Scenary;

public final class Logic implements Runnable {
	public static String windowTitle;
	
	public static final Thread respondingThread = new Thread(new Logic());
	
	private static CloseListener closeListener;
	
	static void initilze(final String title, final CloseListener closeListener) {
		Logic.windowTitle = title;
		Logic.closeListener = closeListener;
		Scenary.initilize();
		UI.initilize();
		
		respondingThread.start();
	}

	static final void destroy() {
		// TODO:
		UI.destroy();
		if(closeListener != null) {
			closeListener.closed();
			closeListener = null;
		}
		System.exit(0);
	}

	
	public final void run() {
		Timing.init();
		
		while(true) {
			if(Scenary.tick())
				break;
			
			Timing.sleep();
		}
		
		IFW.destroy(); // TODO:
	}
}