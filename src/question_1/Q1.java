package question_1;
/**
 * Code for AoC 2015 Q1
 * Author: Lucas Sherlock
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q1 {

	public static final String INPUT = "AoC15_Q1_input.txt";
	
	public static void main(String[] args) {
		int floor = 0;
		String input = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(INPUT);
			br = new BufferedReader(fr);
			input = br.readLine();
			for (int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == '(') {
					floor++;
				} else if(input.charAt(i) == ')') {
					floor--;
				}
				
				if(floor == -1) {
					System.out.println(i+1);
				}
			}
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}

		System.out.println(floor);
	}
	

}
