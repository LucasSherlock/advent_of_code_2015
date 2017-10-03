package question_6;

public enum Action {
	toggle("toggle"), switchOn("on"), switchOff("off");
	private String _asString;
	
	private Action(String s) {
		_asString = s;
	}
	
	public String asString() {
		return _asString;
	}
	
	
}
