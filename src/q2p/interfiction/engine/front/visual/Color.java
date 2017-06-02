package q2p.interfiction.engine.front.visual;

import java.awt.Graphics2D;

public class Color extends Drawable {
	private java.awt.Color color;

	public final int r;
	public final int g;
	public final int b;
	
	public final float hue;
	public final float starution;
	public final float brightness;

	public static final Color fromHSB(final float hue, final float saturation, final float brightness) {
		return new Color(java.awt.Color.getHSBColor(hue, saturation, brightness));
	}

	public static final Color fromColor(final java.awt.Color color) {
		return new Color(color);
	}

	public static final Color fromRGB(final int rgb) {
		return new Color(new java.awt.Color(rgb));
	}

	public static final Color fromRGB(final int r, final int g, final int b) {
		return new Color(new java.awt.Color(r, g, b));
	}
	
	private Color(final java.awt.Color c) {
		color = c;
		
		r = c.getRed();
		g = c.getGreen();
		b = c.getBlue();

		final float[] buff = java.awt.Color.RGBtoHSB(r, g, b, new float[3]);
		
		this.hue = buff[0];
		this.starution = buff[1];
		this.brightness = buff[2];
		
	}

	
	public void draw(final Graphics2D graphics, final int x, final int y, final int width, final int height) {
		graphics.setColor(color);
		graphics.fillRect(x, y, width, height);
	}
}