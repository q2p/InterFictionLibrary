package q2p.interfiction.engine.front.misc;

import q2p.interfiction.engine.front.Event;


// TODO: запуск при загрузке страницы
public class EventExecuteJS extends Event {
	final String command;
	
	protected EventExecuteJS(final String command) {
		super("execute");
		this.command = command;
	}
}