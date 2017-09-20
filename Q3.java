import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Code for Day 3
 * @author Lucas Sherlock
 *
 */
public class Q3 {
	public static final String INPUT = "AoC15_Q3_input.txt";
	public static void main(String[] args) {
		String input = null;
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> visited_coords = new ArrayList<String>();
		visited_coords.add("0,0");
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
				
				if(!visited_coords.contains(x+","+y)) {
					visited_coords.add(x+","+y);
				}
			}
			System.out.println("Number of Houses visited: "+ visited_coords.size());
			
		} catch(IOException e) {
			e.printStackTrace();
		}


	}

}
