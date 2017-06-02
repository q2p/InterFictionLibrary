package q2p.interfiction.engine.receivers;

import java.util.Arrays;

public class BytesReceiver implements DataReceiver {
	private byte[] bytes;
	
	public BytesReceiver(final byte[] bytes) {
		this.bytes = bytes;
	}
	
	public final int length() {
		return bytes == null ? 0 : bytes.length;
	}

	public final byte[] get(final int from, final int length) {
		return Arrays.copyOfRange(bytes, (int)from, (int)(from+length));
	}

	public final void dispose() {
		bytes = null;
	}
}