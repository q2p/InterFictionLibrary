package q2p.interfiction.help;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Random;
import com.sun.xml.internal.ws.Closeable;

public final class Assist {
	public static final String alpha = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final byte alphaLength = (byte)alpha.length();
	public static final boolean validAlpha(final String string) {
		for(int i = string.length()-1; i != -1; i--)
			if(alpha.indexOf(string.charAt(i)) == -1)
				return false;
		
		return true;
	}
	public static final String generateAlpha(final int length) {
		char[] ret = new char[length];
		for(int i = length-1; i != -1; i--)
			ret[i] = alpha.charAt(random(alphaLength));
		
		return new String(ret);
	}
	
	private static final Random random = new Random();
	public static synchronized final int random(final int bound) {
		return random.nextInt(bound);
	}
	
	public static final void writePartialyAndFlush(final OutputStream outputStream, final int bufferSize, final byte[] data) throws IOException {
		for(int offset = 0, left = data.length; left != 0;) {
			final int length = Math.min(bufferSize, left);
			outputStream.write(data, offset, length);
			outputStream.flush();
			offset += length;
			left -= length;
		}
	}
	public static final void writePartialyAndFlush(final OutputStream outputStream, final int bufferSize, final byte[] data, int offset, final int length) throws IOException {
		for(int left = length; left != 0;) {
			final int part = Math.min(bufferSize, left);
			outputStream.write(data, offset, part);
			outputStream.flush();
			offset += part;
			left -= part;
		}
	}
	public static final void writePartialyAndFlush(final OutputStream outputStream, final int bufferSize, final byte[] ... data) throws IOException {
		int bufferLeft = bufferSize;
		for(byte[] chunk : data) {
			int chunkOffset = 0;
			int chunkLeft = chunk.length;
			
			while(chunkLeft != 0) {
				final int length = Math.min(bufferLeft, chunkLeft);
				
				outputStream.write(chunk, chunkOffset, length);
				
				chunkOffset += length;
				chunkLeft -= length;
				bufferLeft -= length;
				
				if(bufferLeft == 0) {
					bufferLeft = bufferSize;
					outputStream.flush();
				}
			}
		}
		
		if(bufferLeft != bufferSize)
			outputStream.flush();
	}
	public static final void writePartialyAndFlush(final InputStream inputStream, final OutputStream outputStream, final int bufferSize) throws IOException {
		writePartialyAndFlush(inputStream, outputStream, new byte[bufferSize]);
	}
	public static final void writePartialyAndFlush(final InputStream inputStream, final OutputStream outputStream, final long length, final int bufferSize) throws IOException {
		writePartialyAndFlush(inputStream, outputStream, length, new byte[bufferSize]);
	}
	public static final void writePartialyAndFlush(final InputStream inputStream, final OutputStream outputStream, final byte[] buffer) throws IOException {
		while(inputStream.available() > 0) {
			final int pointer = inputStream.read(buffer);
			outputStream.write(buffer, 0, pointer);
			outputStream.flush();
		}
	}
	public static final void writePartialyAndFlush(final InputStream inputStream, final OutputStream outputStream, long length, final byte[] buffer) throws IOException {
		while(inputStream.available() > 0) {
			int limit = buffer.length;
			if(length < limit)
				limit = (int)length;
			final int pointer = inputStream.read(buffer, 0, limit);
			length -= limit;
			outputStream.write(buffer, 0, pointer);
			outputStream.flush();
		}
	}
	
	public static final void safeClose(final Closeable closeable) {
		if(closeable != null) {
			try { closeable.close(); }
			catch(final Exception e) {}
		}
	}

	public static final void safeClose(final Socket socket) {
		if(socket != null) {
			try { socket.close(); }
			catch(final Exception e) {}
		}
	}
	
	public static final int perfectCeil(final int number, final int devisor) {
		return number/devisor+(number%devisor==0?0:1);
	}
	
	public static final boolean timeLimit(final long limit) {
		return limit > System.currentTimeMillis();
	}
	
	public static final int limit(final int min, final int value, final int max) {
		if(value < min)
			return min;
		
		if(value > max)
			return max;
		
		return value;
	}
}