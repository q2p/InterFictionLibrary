package q2p.interfiction.engine.receivers;

public interface DataReceiver {
	public int length();
	public byte[] get(final int from, final int length);
	public void dispose();
}