package question_7;

public class NotOperation extends Operation {
	
	protected int _sig;
	
	public NotOperation(Wire target, Wire source) {
		super(target);
		_sources[0] = source;
		_sig = _sources[0].getSignal();
		this.setType(Operator.NOT);
	}
	
	public void updateSignal() {
		_sig = _sources[0].getSignal();
	}

	@Override
	public void doOperation() {
		if(_sig >= 0) {
			_target.setSignal(~_sig + 65536);
		}
	}

}
