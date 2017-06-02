package q2p.interfiction.engine;

import java.util.ArrayList;
import q2p.interfiction.engine.front.ContentType;

public final class BufferedData {
	private final ContentType contentType;
	private final byte[] data;
	private static final ArrayList<BufferedData> files = new ArrayList<BufferedData>();
	private static final int maxBufferedFiles = 1024*1024;
	
	public BufferedData(final ContentType contentType, final byte[] data) {
		if(files.size() == maxBufferedFiles)
			throw new IndexOutOfBoundsException("Limit of files reached.");

		if(contentType == null)
			throw new NullPointerException("contentType is null");
		
		if(data == null)
			throw new NullPointerException("data is null");
		
		this.contentType = contentType;
		
		this.data = data;
				
		files.add(this);
	}
	
	public static void checkRequest() {
		if(compactNumber > files.size()) {
			response.sendHeaderNoCache(ResponseCode.NotFound);
			return;
		}
		
		final BufferedData buffered = files.get(compactNumber);
		
		if(request.sameETag(buffered.eTag)) {
			response.sendHeader(ResponseCode.NotModified, true, true, buffered.contentType, false, true, buffered.data.length, Cache.Revalidate, buffered.eTag);
			return;
		}
		
		if(request.method == Method.HEAD)
			response.sendHeader(ResponseCode.OK, true, true, buffered.contentType, false, true, buffered.data.length, Cache.Revalidate, buffered.eTag);
		else {
			if(request.havePartialContent()) {
				final int[] bounds = request.crunchPartitialContent(buffered.data.length);
				response.sendBytes(ResponseCode.OK, true, buffered.contentType, false, true, bounds[0], buffered.data.length, Cache.Revalidate, buffered.eTag, buffered.data, bounds[0], bounds[1]-bounds[0]);
			} else
				response.sendBytes(ResponseCode.OK, true, buffered.contentType, false, false, 0, 0, buffered.data.length, Cache.Revalidate, buffered.eTag, buffered.data);
		}
	}
}