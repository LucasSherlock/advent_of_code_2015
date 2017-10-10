package question_7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;

public class OperationList {
	public ArrayList<Operation> _operations;
	
	public OperationList(String inputFile) {
		_operations = new ArrayList<Operation>();
		String line = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(inputFile);
			br = new BufferedReader(fr);
			
			while((line = br.readLine()) != null) {
				addOperation(line);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addOperation(String line) {
		String[] splitLine1 = line.split(" -> ");
		String[] splitLine2 = splitLine1[0].split(" ");

		if(splitLine2.length == 1) {
			if(isInt(splitLine2[0])) {
				_operations.add(new AssignOperation(new Wire(splitLine1[1]), Integer.parseInt(splitLine2[0])));
			} else {
				_operations.add(new AssignOperation(new Wire(splitLine1[1]), new Wire(splitLine2[0])));
			}
		} else if(splitLine2.length == 2) {
			_operations.add(new NotOperation(new Wire(splitLine1[1]), new Wire(splitLine2[1])));
		} else if(splitLine2[1].equals(Operator.AND.toString())) {
			if(isInt(splitLine2[0])) {
				if(isInt(splitLine2[2])) {
					_operations.add(new AndOperation(new Wire(splitLine1[1]), Integer.parseInt(splitLine2[0]), Integer.parseInt(splitLine2[2])));
				} else {
					_operations.add(new AndOperation(new Wire(splitLine1[1]), Integer.parseInt(splitLine2[0]), new Wire(splitLine2[2])));
				}
			} else {
				if(isInt(splitLine2[2])) {
					_operations.add(new AndOperation(new Wire(splitLine1[1]), new Wire(splitLine2[0]), Integer.parseInt(splitLine2[2])));
				} else {
					_operations.add(new AndOperation(new Wire(splitLine1[1]), new Wire(splitLine2[0]), new Wire(splitLine2[2])));
				}
			}
			
			
		} else if(splitLine2[1].equals(Operator.OR.toString())) {
			if(isInt(splitLine2[0])) {
				if(isInt(splitLine2[2])) {
					_operations.add(new OrOperation(new Wire(splitLine1[1]), Integer.parseInt(splitLine2[0]), Integer.parseInt(splitLine2[2])));
				} else {
					_operations.add(new OrOperation(new Wire(splitLine1[1]), Integer.parseInt(splitLine2[0]), new Wire(splitLine2[2])));
				}
			} else {
				if(isInt(splitLine2[2])) {
					_operations.add(new OrOperation(new Wire(splitLine1[1]), new Wire(splitLine2[0]), Integer.parseInt(splitLine2[2])));
				} else {
					_operations.add(new OrOperation(new Wire(splitLine1[1]), new Wire(splitLine2[0]), new Wire(splitLine2[2])));
				}
			}
		} else if(splitLine2[1].equals(Operator.LSHIFT.toString())) {
			_operations.add(new ShiftOperation(new Wire(splitLine1[1]), new Wire(splitLine2[0]), Integer.parseInt(splitLine2[2])*-1));
		} else {

			_operations.add(new ShiftOperation(new Wire(splitLine1[1]), new Wire(splitLine2[0]), Integer.parseInt(splitLine2[2])));
		}
	}
	
	public boolean isInt(String s) {
		try {
			int num = Integer.parseInt(s);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
	public ArrayList<Operation> getList() {
		return _operations;
	}
	public void setList(ArrayList<Operation> ol) {
		_operations = ol;
	}
}
