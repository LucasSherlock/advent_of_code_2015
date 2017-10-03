package question_6;

public class LightGrid {
	private Light[][] _LightGrid;
	private int _xDim;
	private int _yDim;
	
	public LightGrid(int xDim, int yDim, String s) {
		_xDim = xDim;
		_yDim = yDim;
		_LightGrid = new Light[_xDim][_yDim];
		for(int i = 0; i < _xDim; i++) {
			for(int j = 0; j < _yDim; j++) {
				if(s.equals("A")) {
					_LightGrid[i][j] = new ToggledLight();
				} else if(s.equals("B")) {
					_LightGrid[i][j] = new BrightLight();
				}
				
			}
		}
	}
	
	public void doCommand(Command c) {
		for(int i = c.getStartX(); i <= c.getFinX(); i++) {
			for(int j = c.getStartY(); j <= c.getFinY(); j++) {
				if(c.getAction().equals(Action.toggle)) {
					_LightGrid[i][j].toggle();
				} else if(c.getAction().equals(Action.switchOn)) {
					_LightGrid[i][j].switchOn();
					
				} else {
					_LightGrid[i][j].switchOff();
					
				}
			}
		}
	}
	
	public int countBrightness() {
		int totalBrightness = 0;
		
		for(int i = 0; i < _xDim; i++) {
			for(int j = 0; j < _yDim; j++) {
				totalBrightness += _LightGrid[i][j].brightness();
			}
		}
		return totalBrightness;
	}
	
	public void print() {
		for(int i = 0; i < _yDim; i++) {
			for(int j = 0; j < _xDim; j++) {
				System.out.print("|"+_LightGrid[j][i].brightness());
			}
			System.out.println("|"); 
		}
	}
	
}
