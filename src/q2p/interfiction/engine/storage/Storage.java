package q2p.interfiction.engine.storage;

import java.io.IOException;
import java.io.InputStream;

public final class Storage {
	public static final int hardBuffer = 4*1024;
	public static final byte[] getResource(final String path) {
		try {
			final InputStream is = Storage.class.getClassLoader().getResourceAsStream("res/"+path);
			final byte[] ret = new byte[is.available()];
			is.read(ret);
			is.close();
			return ret;
		} catch(final IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
}