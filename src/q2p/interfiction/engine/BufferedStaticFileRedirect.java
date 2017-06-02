package q2p.interfiction.engine;

import q2p.interfiction.engine.connection.Response;
import q2p.interfiction.engine.connection.Response.Cache;
import q2p.interfiction.engine.connection.Response.ResponseCode;
import q2p.interfiction.engine.connection.request.Request;
import q2p.interfiction.engine.connection.request.Request.Method;
import q2p.interfiction.engine.front.ContentType;
import q2p.interfiction.engine.storage.Storage;
import q2p.interfiction.help.CompactNumber;

public final class BufferedStaticFileRedirect {
	private final ContentType contentType;
	private final boolean isUTF;
	private final String publicPath;
	private final byte[] data;
	
	public BufferedStaticFileRedirect(final String localPath, final ContentType contentType, final boolean isUTF, final String publicPath) {
		this.contentType = contentType;
		this.isUTF = isUTF;
		this.publicPath = publicPath;
		
		data = Storage.getResource(localPath);
	}
	
	public final boolean check(final String publicPath, final Request request, final Response response) {
		if(!this.publicPath.equals(publicPath))
			return false;
		
		if(request.method == Method.POST)
			return response.sendHeaderNoCache(ResponseCode.NotAcceptable);
		
		if(request.sameETag(eTag))
			return response.sendHeader(ResponseCode.NotModified, true, true, contentType, isUTF, true, data.length, Cache.Revalidate, eTag);
		
		if(request.method == Method.HEAD)
			response.sendHeader(ResponseCode.OK, true, true, contentType, isUTF, true, data.length, Cache.Revalidate, eTag);
		else {
			if(request.havePartialContent()) {
				final int[] bounds = request.crunchPartitialContent(data.length);
				response.sendBytes(ResponseCode.OK, true, contentType, isUTF, true, bounds[0], data.length, Cache.Revalidate, eTag, data, bounds[0], bounds[1]-bounds[0]);
			} else
				response.sendBytes(ResponseCode.OK, true, contentType, isUTF, false, 0, 0, data.length, Cache.Revalidate, eTag, data);
		}
		
		return true;
	}
}