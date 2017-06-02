package q2p.interfiction.engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import q2p.interfiction.engine.events.Events;
import q2p.interfiction.engine.front.Scenary;

@SuppressWarnings("serial")
public final class UI extends JFrame implements WindowListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener, ComponentListener {
	private static UI ui;
		
	private static final JPanel panel = new JPanel(null);
		
	UI() throws HeadlessException {
		super("IntFic - " + Logic.windowTitle);
		
		setContentPane(panel);
		
		panel.setPreferredSize(new Dimension(Scenary.baseSize, Scenary.baseSize));
		
		panel.setBackground(Color.BLACK);
		
		setResizable(true);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		pack();
		
		setMinimumSize(getSize());

		setLocationRelativeTo(null);
		
		addWindowListener(this);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		panel.addMouseWheelListener(this);
		
		Scenary.resized(Scenary.baseSize, Scenary.baseSize);
		
		setVisible(true);
	}
	
	public static final void initilize() {
		ui = new UI();
	}

	// TODO: INVOKE LATER
	public static final void destroy() {
		ui.dispose();
		ui = null;
	}
	
	public final void componentResized(final ComponentEvent e) {
		Scenary.resized(panel.getWidth(), panel.getHeight());
	}
	
	public static final void renderSurface(final BufferedImage surface) {
		panel.getGraphics().drawImage(surface, 0, 0, null);
	}
	
	public final void windowClosing(final WindowEvent e) {
		Events.closing();
	}

	public void keyPressed(final KeyEvent e) {
		Events.keyPress(e.getKeyCode());
	}

	public void keyTyped(final KeyEvent e) {
		Events.keyTyped(e.getKeyChar());
	}

	public void mouseWheelMoved(final MouseWheelEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseDragged(final MouseEvent e) {
		mouseMoved(e);
	}

	public void mouseMoved(final MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(final MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(final MouseEvent e) {
		mouseMoved(e);
	}

	public void mouseExited(final MouseEvent e) {
		mouseMoved(e);
	}

	public void mousePressed(final MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(final MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public final void windowActivated(final WindowEvent we) {} // TODO:
	public final void windowClosed(final WindowEvent we) {}
	public final void windowDeactivated(final WindowEvent we) {} // TODO:
	public final void windowDeiconified(final WindowEvent we) {}
	public final void windowIconified(final WindowEvent we) {}
	public final void windowOpened(final WindowEvent we) {}
	public void componentShown(final ComponentEvent e) {}
	public void componentHidden(final ComponentEvent e) {}
	public void componentMoved(final ComponentEvent e) {}
	public void keyReleased(final KeyEvent e) {}
}