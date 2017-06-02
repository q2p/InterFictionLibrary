package q2p.interfiction.engine.events;

public class BindRedirect {
	// States
	static final byte FREE = 0;
	static final byte HOLD = 1;
	static final byte PRESSED = 2;
	static final byte TICKED = 3;
	static final byte RELEASED = 4;
	
	public final int virtual;
	byte state = FREE;
	
	BindRedirect(final int virtual) {
		this.virtual = virtual;
	}

	public void press() {
		state = PRESSED;
	}

	public boolean pressed() {
		return state == PRESSED;
	}
	
	public boolean released() {
		return state == RELEASED;
	}
	
	public boolean holded() {
		return (state == HOLD || state == PRESSED || state == TICKED);
	}
	
	public boolean ticked() {
		return (state == PRESSED || state == TICKED);
	}
}