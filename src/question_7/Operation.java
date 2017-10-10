package question_7;

import java.util.ArrayList;

public abstract class Operation {
	protected Wire _target;
	protected Wire[] _sources = new Wire[]{new Wire(), new Wire()};
	protected Operator _type;
	
	public Operation(Wire target) {
		_target = target;
	}
	
	public abstract void updateSignal();
	public abstract void doOperation();
	
	public Wire getTarget() {
		return _target;
	}
	
	public Wire[] getSources() {
		return _sources;
	}
	
	public void setType(Operator o) {
		_type = o;
	}
	
	public void print() {
		System.out.println("tgt= "+_target.getName()+" sources= "+_sources[0].getName()+", "+_sources[1].getName()+" type= "+_type.toString());
	}
}

	

enum Operator {
	
	AND("AND"), NOT("NOT"), OR("OR"), LSHIFT("LSHIFT"), RSHIFT("RSHIFT"), assign("->");
	
	private String _strRep;
	private Operator(String s) {
		_strRep = s;
	}
	
	public String toString() {
		return _strRep;
	}
}
