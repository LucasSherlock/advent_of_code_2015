package question_7;

import java.util.ArrayList;


/**
 * Code for AoC day 7, takes 1 argument, the name of the input file.
 * 
 * @author Lucas Sherlock
 *
 */
public class Q7 {
	
	private static String INPUT;
	private static String wireSignalToFind = "a";
	
	public static void main(String[] args) {
	
		
		INPUT = args[0];
		OperationList opList = new OperationList(INPUT);
		
		int aSig = findSignal(opList, wireSignalToFind);
		System.out.println("a1= "+aSig);
		
		OperationList opList2 = new OperationList(INPUT);
		ArrayList<Operation> list = opList2.getList();
		for(Operation o : list) {
			if(o.getTarget().getName().equals("b")) {
				list.remove(o);
				break;
			}
		}
		list.add(new AssignOperation(new Wire("b"), aSig));
		opList2.setList(list);
		int aSig2 = findSignal(opList2, wireSignalToFind);
		System.out.println("a2= "+aSig2);
		
		
		
	}
	
	public static int findSignal(OperationList ol, String wireName) {
		ArrayList<Operation> list = ol.getList();
		for(Operation o : list) {
			if(o.getTarget().getName().equals(wireName)) {
				//o.print();
				o.doOperation();
				if(!o.getTarget().hasSignal()) {
					if(!(o.getSources()[0].getName() == null)) {
						o.getSources()[0].setSignal(findSignal(ol, o.getSources()[0].getName()));
						o.updateSignal();
					}
					if(!(o.getSources()[1].getName() == null)) {
						o.getSources()[1].setSignal(findSignal(ol, o.getSources()[1].getName()));
						o.updateSignal();
					}
					o.doOperation();
					return o.getTarget().getSignal();
				} else {
					return o.getTarget().getSignal();
				}
			}
		}
		return -1;
	}

}
