package q2p.interfiction.engine.receivers;

import java.io.File;
import java.io.RandomAccessFile;

public class FileReceiver implements DataReceiver {
	private RandomAccessFile raf;
	private int length;
	
	public FileReceiver(final String path) {
		try {
			raf = new RandomAccessFile(path, "r");
			length = (int)Math.min(Integer.MAX_VALUE-32, raf.length());
		} catch(final Exception e) {
			dispose();
		}
	}
	
	public FileReceiver(final File file) {
		try {
			raf = new RandomAccessFile(file, "r");
			length = (int)Math.min(Integer.MAX_VALUE-32, raf.length());
		} catch(final Exception e) {
			dispose();
		}
	}
	
	public final int length() {
		return length;
	}

	public final byte[] get(final int from, final int length) {
		byte[] ret = new byte[length];
		try {
			raf.seek(from);
			int pointer = 0; 
			while(pointer != length)
				pointer += raf.read(ret, pointer, length-pointer);
		} catch (final Exception e) {
			dispose();
		}
		return ret;
	}

	public final void dispose() {
		if(raf != null) {
			try { raf.close(); }
			catch(final Exception e) {}
			
			raf = null;
			
			length = 0;
		}
	}
}