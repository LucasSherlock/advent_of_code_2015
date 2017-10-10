package question_7;

public class AssignOperation extends Operation {
	
	protected int _signal;
	
	public AssignOperation(Wire target, int signal) {
		super(target);
		_signal = signal;
		this.setType(Operator.assign);
	}
	
	public AssignOperation(Wire target, Wire source) {
		super(target);
		_sources[0] = source;
		_signal = _sources[0].getSignal();	
		this.setType(Operator.assign);
	}
	
	public void updateSignal() {
		if(_sources[0].getName() != null) {
			_signal = _sources[0].getSignal();
		}
		
	}

	
	@Override
	public void doOperation() {
		if(_signal >= 0) {
			_target.setSignal(_signal);
		}

	}

}
