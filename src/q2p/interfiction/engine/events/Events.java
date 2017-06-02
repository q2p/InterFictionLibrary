package q2p.interfiction.engine.events;

import java.awt.event.KeyEvent;

public class Events {
	public static final Object LOCK = new Object();
	
	public static boolean closing = false;

	public static boolean enter = false;
	
	public static int pgPresses = 0;
	public static int arrowXPresses = 0;
	public static int arrowYPresses = 0;

	public static int bsPresses = 0;
	public static int delPresses = 0;

	public static boolean PND_enter = false;
	
	public static int PND_pgPresses = 0;
	public static int PND_arrowXPresses = 0;
	public static int PND_arrowYPresses = 0;

	public static int PND_bsPresses = 0;
	public static int PND_delPresses = 0;

	public static String string = "";
	
	public static StringBuilder PND_string = new StringBuilder();
		
	public static final void keyPress(final int code) {
		synchronized (LOCK) {
			switch(code) {
				case KeyEvent.VK_ENTER:
					PND_enter = true;
					break;
				case KeyEvent.VK_PAGE_UP:
					PND_pgPresses--;
					break;
				case KeyEvent.VK_PAGE_DOWN:
					PND_pgPresses++;
					break;
				case KeyEvent.VK_UP:
					PND_arrowYPresses--;
					break;
				case KeyEvent.VK_DOWN:
					PND_arrowYPresses++;
					break;
				case KeyEvent.VK_LEFT:
					PND_arrowXPresses--;
					break;
				case KeyEvent.VK_RIGHT:
					PND_arrowXPresses++;
					break;
			}
		}
	}
	
	public static void iterateNewActions() {
		synchronized (LOCK) {
			pgPresses = PND_pgPresses;
			arrowXPresses = PND_arrowXPresses;
			arrowYPresses = PND_arrowYPresses;
			bsPresses = PND_bsPresses;
			delPresses = PND_delPresses;
			
			PND_pgPresses = 0;
			PND_arrowXPresses = 0;
			PND_arrowYPresses = 0;
			PND_bsPresses = 0;
			PND_delPresses = 0;
			
			if(PND_string.length() != 0) {
				string = PND_string.toString();
				PND_string = new StringBuilder();
			}
						
			if(PND_enter) {
				enter = true;
				PND_enter = false;
			}
		}
	}
	
	
	public static final void keyTyped(final char character) {
		synchronized (LOCK) {
			if(character != KeyEvent.CHAR_UNDEFINED)
				PND_string.append(character);
		}
	}

	
	public static final void closing() {
		synchronized(LOCK) {
			closing = true;
		}
	}
	
	public static final boolean isClosing() {
		synchronized(LOCK) {
			return closing;
		}
	}
}