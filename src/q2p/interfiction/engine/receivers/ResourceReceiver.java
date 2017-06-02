package q2p.interfiction.engine.receivers;

import java.io.InputStream;

public class ResourceReceiver implements DataReceiver {
	private String path;
	private int length;
		
	public ResourceReceiver(final String path) {
		this.path = path;
		final InputStream is = ResourceReceiver.class.getResourceAsStream(path);
		
		if(is == null) {
			dispose();
		} else {
			try {			
				length = is.available();
			} catch(final Exception e) {
				dispose();
			}
			
			try { is.close(); }
			catch(final Exception e) {}
		}
	}
	
	public final int length() {
		return length;
	}

	public final byte[] get(final int from, final int length) {
		byte[] ret = new byte[length];
		
		final InputStream is = ResourceReceiver.class.getResourceAsStream(path);
		
		if(is == null) {
			dispose();
		} else {
			try {
				is.skip(from);
				
				int pointer = 0;
				
				while(pointer != length)
					pointer += is.read(ret, pointer, length-pointer);
			} catch(final Exception e) {
				dispose();
			}
			
			try { is.close(); }
			catch(final Exception e) {}
		}
		
		return ret;
	}

	public final void dispose() {
		path = null;
		length = 0;
	}
}