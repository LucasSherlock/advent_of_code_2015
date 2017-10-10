package question_7;

public class Wire {
	private String _name;
	private int _signal = -1;
	
	public Wire() {
		_name = null;
	}
	
	public Wire(String name) {
		_name = name;
	}
	
	public Wire(String name, int signal) {
		_name = name;
		_signal = signal;
	}
	
	public String getName() {
		return _name;
	}
	
	public int getSignal() {
		return _signal;
	}
	
	public void setSignal(int signal) {
		_signal = signal;
	}
	
	public boolean hasSignal() {
		if(_signal >= 0) {
			return true;
		}
		return false;
	}
}
