package question_7;

import java.lang.Math;

public class ShiftOperation extends Operation {
	
	protected int _sig;
	protected int _shift;

	public ShiftOperation(Wire tgt, Wire s, int shift) {
		super(tgt);
		_sources[0] = s;
		_sig = _sources[0].getSignal();
		_shift = shift;
		if(shift < 0) {
			this.setType(Operator.LSHIFT);
		} else {
			this.setType(Operator.RSHIFT);
		}
		
	}
	
	public void updateSignal() {
		_sig = _sources[0].getSignal();
	}

	
	@Override
	public void doOperation() {
		
		if(_sig >= 0) {
			if(_type.equals(Operator.LSHIFT)) {
				_target.setSignal(_sig << Math.abs(_shift));
			} else {
				_target.setSignal(_sig >> _shift);
			}
		}
	}

}
