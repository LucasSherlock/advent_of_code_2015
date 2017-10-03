package question_6;

public class BrightLight implements Light {
	
	private int _brightnessLevel;
	
	public BrightLight() {
		_brightnessLevel = 0;
	}

	@Override
	public void switchOn() {
		_brightnessLevel++;

	}

	@Override
	public void switchOff() {
		_brightnessLevel--;
		if(_brightnessLevel < 0) {
			_brightnessLevel = 0;
		}
	}

	@Override
	public void toggle() {
		_brightnessLevel = _brightnessLevel + 2;

	}

	@Override
	public int brightness() {
		return _brightnessLevel;
	}

}
