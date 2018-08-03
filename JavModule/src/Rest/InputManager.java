package Rest;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {

	private static InputManager instance = null;
	private static Event event;
	private Frame gframe;
	private InputListener listener;

	public static InputManager getInstance() {

		if (instance == null) {
			instance = new InputManager();
		}

		return instance;
	}

	public void setFrame(Frame frame) {
		gframe = frame;
		gframe.addKeyListener(this);
	}

	public void setInputListener(InputListener inputlistener) {
		listener = inputlistener;
	}

	public InputManager() {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			listener.onPlayerMove(Event.MOVE_UP);
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			listener.onPlayerMove(Event.MOVE_LEFT);
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			listener.onPlayerMove(Event.MOVE_RIGHT);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			listener.onPlayerMove(Event.MOVE_DOWN);
		} else if (e.getKeyCode() == KeyEvent.VK_C) {
			listener.onPlayerAttack();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	public enum Event {
		MOVE_LEFT, MOVE_RIGHT, MOVE_UP, MOVE_DOWN, ATTACK;
	}

	public Event getAction() {
		return event;
	}

}
