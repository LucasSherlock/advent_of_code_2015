package question_6;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 
 * Code for AoC 2015 Q6
 * Takes 4 arguments which, in order, are: the input file (e.g. input.txt), 
 * a letter "A" or "B" depending on whether you are solving part a or b of 
 * the question, an integer which is the width of the light array, and finally
 * an integer which is the height of the light array.
 * 
 * @author Lucas Sherlock
 *
 */
public class Q6 {
	private static String INPUT;
	
	public static void main(String[] args) {
		INPUT = args[0];
		LightGrid lights = new LightGrid(Integer.parseInt(args[2]), Integer.parseInt(args[3]), args[1]);
		//lights.print();
		//System.out.println();
		String line = null;
		String[] splitLine;
		int[] startCoords;
		int[] finCoords;
		Command command;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(INPUT);
			br = new BufferedReader(fr);
			
			while((line = br.readLine()) != null) {
				splitLine = line.split(" ");
				if(splitLine.length == 4) {
					startCoords = getCoords(splitLine[1]);
					finCoords = getCoords(splitLine[3]);
					command = new Command(startCoords[0], startCoords[1], finCoords[0], finCoords[1], Action.toggle);
				} else {
					startCoords = getCoords(splitLine[2]);
					finCoords = getCoords(splitLine[4]);
					if(splitLine[1].equals("on")) {
						command = new Command(startCoords[0], startCoords[1], finCoords[0], finCoords[1], Action.switchOn);
					} else {

						command = new Command(startCoords[0], startCoords[1], finCoords[0], finCoords[1], Action.switchOff);
					}
				}
				//command.print();
				lights.doCommand(command);
				//lights.print();
				//System.out.println();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}

		System.out.println(lights.countBrightness());

	}
	
	public static int[] getCoords(String s) {
		int[] coords = new int[]{Integer.parseInt(s.split(",")[0]), Integer.parseInt(s.split(",")[1])};
		return coords;
	}

}
