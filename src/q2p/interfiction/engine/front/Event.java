package q2p.interfiction.engine.front;

public abstract class Event {
	/* // TODO:
	
	Фон
	Музыка
	Звук воспроизводящийся при проигрывании (отвалилась вентеляция) (ждать завершения или играть параллельно с текстом)
	Задержка перед появлением следующего события
	Кнопка replay
	Ввод при помощи кнопок
	Текст плавающий
	текст трясущийся
	звук вместе с текстом
	скорость появления текста
	затухание амбиента с продолжентем, не дожидаясь окончания или задержкой
	
	*/
	
	private final int sleep;
	
	protected Event(final int sleep) {
		this.sleep = sleep;
	}
	
	public abstract void fire();
}