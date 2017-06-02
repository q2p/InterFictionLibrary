package q2p.interfiction.help;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public final class Expressions {
	public static final byte[] toUTF(final String string) {
		return string.getBytes(StandardCharsets.UTF_8);
	}
	public static final byte[] toASCII(final String string) {
		return string.getBytes(StandardCharsets.US_ASCII);
	}
	public static final String fromUTF(final byte[] buffer) {
		return new String(buffer, StandardCharsets.UTF_8);
	}
	public static final String fromASCII(final byte[] buffer) {
		return new String(buffer, StandardCharsets.US_ASCII);
	}
	public static final String fromUTF(final byte[] buffer, final int offset, final int length) {
		return new String(buffer, offset, length, StandardCharsets.UTF_8);
	}
	public static final String fromASCII(final byte[] buffer, final int offset, final int length) {
		return new String(buffer, offset, length, StandardCharsets.US_ASCII);
	}
	
	public static final String[]           split(final String string, final char pattern, final int amount) {
		final String[] ret = new String[amount];

		int i = 0, pidx = 0;
		
		do {
			final int idx = string.indexOf(pattern, pidx);
			
			if(idx == -1) {
				if(i == amount-1) {
					ret[i] = string.substring(pidx);
					return ret;
				} else if(i == amount)
					return ret;
				else
					return null;
			} else if(i == amount)
				return null;
			
			ret[i] = string.substring(pidx, idx);
			
			pidx = idx+1;
			
			i++;
		} while(true);
	}
	public static final LinkedList<String> split(final String string, final char pattern) {
		final LinkedList<String> ret = new LinkedList<String>();
		
		int idx, pidx = 0;
		while(true) {
			idx = string.indexOf(pattern, pidx);
			if(idx == -1) {
				ret.addLast(string.substring(pidx));
				break;
			}
			ret.addLast(string.substring(pidx, idx));
			pidx = idx+1;
		}
		
		return ret;
	}
}