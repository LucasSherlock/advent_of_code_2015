package question_3;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Code for AoC 2015 Q3
 * @author Lucas Sherlock
 *
 */
public class Q3 {
	public static final String INPUT = "AoC15_Q3_input.txt";
	private static ArrayList<String> _visitedCoords;
	
	public static void main(String[] args) {
		pt1();
		pt2();
		
	}
	
	public static void pt1() {
		String input = null;
		FileReader fr = null;
		BufferedReader br = null;
		_visitedCoords = new ArrayList<String>();
		_visitedCoords.add("0,0");
		int x = 0;
		int y = 0;
		
		try {
			fr = new FileReader(INPUT);
			br = new BufferedReader(fr);
			input = br.readLine();
			for (int i = 0; i < input.length(); i++) {
				
				if(input.charAt(i) == '^') {
					y++;
				} else if(input.charAt(i) == '>') {
					x++;
				} else if(input.charAt(i) == 'v') {
					y--;
				} else if(input.charAt(i) == '<') {
					x--;
				}
				
				if(!_visitedCoords.contains(x+","+y)) {
					_visitedCoords.add(x+","+y);
				}
			}
			System.out.println("Number of Houses visited with just Santa: "+ _visitedCoords.size());
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void pt2() {
		String input = null;
		FileReader fr = null;
		BufferedReader br = null;
		_visitedCoords = new ArrayList<String>();
		_visitedCoords.add("0,0");
		int x0 = 0;
		int y0 = 0;
		int x1 = 0;
		int y1 = 0;
		
		try {
			fr = new FileReader(INPUT);
			br = new BufferedReader(fr);
			input = br.readLine();
			for (int i = 0; i < input.length(); i++) {
				if(i%2 == 0) {
					if(input.charAt(i) == '^') {
						y0++;
					} else if(input.charAt(i) == '>') {
						x0++;
					} else if(input.charAt(i) == 'v') {
						y0--;
					} else if(input.charAt(i) == '<') {
						x0--;
					}
					
					if(!_visitedCoords.contains(x0+","+y0)) {
						_visitedCoords.add(x0+","+y0);
					} 
				} else if(i%2 == 1) {
						if(input.charAt(i) == '^') {
							y1++;
						} else if(input.charAt(i) == '>') {
							x1++;
						} else if(input.charAt(i) == 'v') {
							y1--;
						} else if(input.charAt(i) == '<') {
							x1--;
						}
						
						if(!_visitedCoords.contains(x1+","+y1)) {
							_visitedCoords.add(x1+","+y1);
						}
				}
				
				
			}
				
			
			System.out.println("Number of Houses visited with RoboSanta: "+ _visitedCoords.size());
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
