package q2p.interfiction.engine;

import q2p.interfiction.help.Assist;

public class Timing {
	private static final short FPS = 50;
	private static final short milisecPerFrame = 1000/FPS;
	private static final short penalty = 250;
	private static final short maxDelta = 2000;
	public static short delta;
	public static double deltaF;
	private static long lastTime;
	
	static final void sleep() {
		final long toSleep = lastTime+milisecPerFrame-System.currentTimeMillis();
		
		if(toSleep > 1) {
			try {
				Thread.sleep(toSleep);
			} catch (InterruptedException e) {}
		}

		delta = (short)Assist.limit(0, (int)(System.currentTimeMillis()-lastTime), maxDelta);
		
		deltaF = (double)delta/1000d;
		
		lastTime += milisecPerFrame;
		
		if(System.currentTimeMillis() - lastTime > penalty) lastTime = System.currentTimeMillis();
	}
	
	static final void init() {
		lastTime = System.currentTimeMillis();
	}
}