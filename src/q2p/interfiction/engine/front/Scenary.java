package q2p.interfiction.engine.front;

import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import q2p.interfiction.engine.ResizeListener;
import q2p.interfiction.engine.UI;
import q2p.interfiction.engine.events.Events;
import q2p.interfiction.engine.front.audio.AudioPlaylistSpeaker;
import q2p.interfiction.engine.front.audio.AudioSpeaker;
import q2p.interfiction.engine.front.visual.Color;
import q2p.interfiction.engine.front.visual.Drawable;

// TODO: при ресайзе оставаться на прежней строке. положение строки будет изменятся только при перемещении по странице.

public final class Scenary {
	private static final Object RESIZE_LOCK = new Object();
	
	private static BufferedImage surface;
	private static Graphics2D graphics;
	private static int width;
	private static int height;
	
	private static int newWidth;
	private static int newHeight;

	private static int avilableWidth;
	private static int leftPadding;
	
	private static int scale;

	private static final int basePadding = 32;
	public static final int baseSize = 256;
	
	private static int offsetTop = 0;

	private static final int scrollMultiplier = 24;
	
	private static int totalHeight;
	
	public static final float maxAspect = 2;
	
	public static Drawable background = Color.fromRGB(0, 0, 0);
	
	private static final ArrayList<Event> queue = new ArrayList<Event>();

	private static final ArrayList<AudioSpeaker> audioSpeakers = new ArrayList<AudioSpeaker>();
	private static final ArrayList<AudioPlaylistSpeaker> audioPlaylists = new ArrayList<AudioPlaylistSpeaker>();

	private static final LinkedList<ResizeListener> resizeListeners = new LinkedList<ResizeListener>();
	private static final LinkedList<Runnable> beforeRenderListeners = new LinkedList<Runnable>();
	private static final LinkedList<Runnable> afterRenderListeners = new LinkedList<Runnable>();
	
	private static final LinkedList<Line> lines = new LinkedList<Line>();
	
	private static int totalLinesHeight = 0;
	
	public static final void initilize() {
	}
	
	private static final ArrayList<Event> currentEvents = new ArrayList<Event>();

	public static final void updateEvent() {
		
	}
	
	public static final void pushEvent(final Event event) {
		currentEvents.add(event);
	}
	
	public static boolean tick() {
		wasResized();
		
		for(final Runnable r : beforeRenderListeners)
			r.run();
		
		if(think())
			return true;
		
		render();
		
		for(final Runnable r : afterRenderListeners)
			r.run();
		
		return false;
	}

	private static final boolean think() {
		Events.iterateNewActions();
		
		if(Events.isClosing())
			return true;
		
		return false;
	}

	private static final void presizeLines() {
		totalLinesHeight = 0;
		
		for(final Line line : lines) {
			line.presize(totalLinesHeight, leftPadding, avilableWidth, scale);
			
			totalLinesHeight += line.height+scale*line.horizontalMargin;
		}
		
		if(!lines.isEmpty())
			totalLinesHeight -= scale*lines.getLast().horizontalMargin;
		
		totalHeight = totalLinesHeight+scale*basePadding;
		
		if(offsetTop + height > totalHeight)
			offsetTop = totalHeight - height;
		
		if(offsetTop < 0)
			offsetTop = 0;
	}

	private static void render() {
		graphics.clearRect(0, 0, width, height);
		background.draw(graphics, 0, 0, width, height);
		
		UI.renderSurface(surface);
	}

	public static void wasResized() {
		synchronized(RESIZE_LOCK) {
			if(newWidth == width && newHeight == height)
				return;
			
			width = newWidth;
			height = newHeight;
		}
		
		surface = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration().createCompatibleImage(width, height, Transparency.OPAQUE);
		graphics = (Graphics2D) surface.getGraphics();
		
		scale = Math.min(width, height) / baseSize;
		
		avilableWidth = width - 2*scale*basePadding;
		
		if((float)avilableWidth/height > maxAspect)
			avilableWidth = (int)(maxAspect*scale*baseSize);
		
		leftPadding = (width - avilableWidth)/2;

		for(final ResizeListener r : resizeListeners)
			r.resize(width, height, scale);
		
		presizeLines();
	}
	
	public static void resized(final int width, final int height) {
		synchronized(RESIZE_LOCK) {
			Scenary.newWidth = width;
			Scenary.newHeight = height;
		}
	}
}