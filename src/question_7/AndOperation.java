package question_7;

public class AndOperation extends Operation {
	
	protected int _sig1;
	protected int _sig2;
	
	public AndOperation(Wire tgt, Wire s1, Wire s2) {
		super(tgt);
		_sources[0] = s1;
		_sources[1] = s2;
		_sig1 = _sources[0].getSignal();
		_sig2 = _sources[1].getSignal();
		this.setType(Operator.AND);
	}
	
	public AndOperation(Wire tgt, int s1, Wire s2) {
		super(tgt);
		_sources[1] = s2;
		_sig1 = s1;
		_sig2 = _sources[1].getSignal();
		this.setType(Operator.AND);
	}
	
	public AndOperation(Wire tgt, Wire s1, int s2) {
		super(tgt);
		_sources[0] = s1;
		_sig1 = _sources[0].getSignal();
		_sig2 = s2;
		this.setType(Operator.AND);
	}
	
	public AndOperation(Wire tgt, int s1, int s2) {
		super(tgt);
		_sig1 = s1;
		_sig2 = s2;
		this.setType(Operator.AND);
	}
	
	public void updateSignal() {
		
		if(_sources[0].getName() != null) {
			_sig1 = _sources[0].getSignal();
		}
		if(_sources[1].getName() != null) {
			_sig2 = _sources[1].getSignal();
		}
		
	}

	@Override
	public void doOperation() {
		if(_sig1 >= 0 && _sig2 >= 0) {
			_target.setSignal(_sig1 & _sig2);

		}

	}

}
