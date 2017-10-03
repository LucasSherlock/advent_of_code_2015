package question_6;

public class ToggledLight implements Light{
	private boolean _isSwitchedOn;
	
	public ToggledLight() {
		_isSwitchedOn = false;
	}
	
	@Override
	public void switchOn() {
		_isSwitchedOn = true;
	}
	
	@Override
	public void switchOff() {
		_isSwitchedOn = false;
	}
	
	@Override
	public void toggle() {
		_isSwitchedOn = !_isSwitchedOn;
	}
	
	@Override
	public int brightness() {
		int bright = 0;
		if(_isSwitchedOn) {
			bright = 1;
		}
		return bright;
	}
}
