package question_5;

import java.io.BufferedReader;
import java.io.FileReader;

public class Q5 {

	private static final String INPUT = "AoC15_Q5_input.txt";
	private static final String _vowels = "aeiou";
	private static final String[] _badStrings = new String[]{"ab","cd","pq","xy"};
	public static void main(String[] args) {
		int goodStrings = 0;
		String input = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try{
			fr = new FileReader(INPUT);
			br = new BufferedReader(fr);
			
			while((input = br.readLine()) != null) {
				if(isGood(input)) {
					goodStrings++;
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(goodStrings);
		
	}
	
	public static boolean isGood(String input) {
		boolean isGood = false;
		if(containsThreeVowels(input) && noBadStrings(input) && containsRepeat(input)) {
			isGood = true; 
		}
		return isGood;
	}
	
	public static boolean containsRepeat(String input) {
		boolean hasRepeat = false;
		for(int i = 0; i < (input.length()-1); i++) {
			if(input.charAt(i) == input.charAt(i+1)) {
				hasRepeat = true;
				break;
			}
		}
		return hasRepeat;
	}
	public static boolean noBadStrings(String input) {
		boolean hasNoBadStrings = true;
		for(int i = 0; i < 4; i++) {
			if(input.contains(_badStrings[i])) {
				hasNoBadStrings = false;
				break;
			}
		}
		return hasNoBadStrings;
	}
	
	public static boolean containsThreeVowels(String input) {
		int numVowels = 0;
		boolean hasThreeVowels = false;
		for(int i = 0; i < input.length(); i++) {
			if(_vowels.contains(""+input.charAt(i))) {
				numVowels++;
			}
			if(numVowels == 3) {
				hasThreeVowels = true;
			}
		}
		
		return hasThreeVowels;
	}
	
}
