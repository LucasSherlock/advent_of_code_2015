package question_6;

public class Command {
	private int _startX;
	private int _startY;
	private int _finX;
	private int _finY;
	private Action _action;
	
	public Command(int startX, int startY, int finX, int finY, Action a) {
		_startX = startX;
		_startY = startY;
		_finX = finX;
		_finY = finY;
		_action = a;
	}
	
	public int getStartX() {
		return _startX;
	}
	
	public int getStartY() {
		return _startY;
	}
	
	public int getFinX() {
		return _finX;
	}
	
	public int getFinY() {
		return _finY;
	}
	
	public Action getAction() {
		return _action;
	}
	
	public void print() {
		System.out.println("Start:("+_startX+","+_startY+"), Fin:("+_finX+","+_finY+"), Command:"+_action.asString());
	}
	
	
	
	
	
	
}
