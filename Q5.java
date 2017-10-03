package question_5;

import java.io.BufferedReader;
import java.io.FileReader;

public class Q5 {

	private static final String INPUT = "AoC15_Q5_input.txt";
	private static final String _vowels = "aeiou";
	private static final String[] _badStrings = new String[]{"ab","cd","pq","xy"};
	public static void main(String[] args) {
		int goodAStrings = 0;
		int goodBStrings = 0;
		String input = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try{
			fr = new FileReader(INPUT);
			br = new BufferedReader(fr);
			
			while((input = br.readLine()) != null) {
				if(isGoodA(input)) {
					goodAStrings++;
				}
				
				if(isGoodB(input)) {
					goodBStrings++;
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("# nice strings by definition A is: " + goodAStrings);
		System.out.println("# nice strings by definition B is: " + goodBStrings);
		
	}
	
	public static boolean isGoodA(String input) {
		boolean isGoodA = false;
		if(containsThreeVowels(input) && noBadStrings(input) && containsRepeat(input)) {
			isGoodA = true; 
		}
		return isGoodA;
	}
	
	public static boolean isGoodB(String input) {
		boolean isGoodB = false;
		if(containsRepeatedPair(input) && containsGapRepeat(input)) {
			isGoodB = true;
		}
		return isGoodB;
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
	
	public static boolean containsRepeatedPair(String input) {
		boolean hasRepeatedPair = false;
		String pair = null;
		int index = -1;
		
		for(int i = 0; i < (input.length() - 3); i++) {
			pair = input.substring(i, i+2);
			index = input.lastIndexOf(pair);
			if(index != -1 && index != i && index != i+1) {
				hasRepeatedPair = true;
				break;
			}
			
		}
		return hasRepeatedPair;
	}
	public static boolean containsGapRepeat(String input) {
		boolean hasGapRepeat = false;
		for(int i = 0; i < (input.length() - 2); i++) {
			if(input.charAt(i) == input.charAt(i+2)) {
				hasGapRepeat = true;
				break;
			}
		}
		return hasGapRepeat;
	}
}
