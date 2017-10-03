package question_4;

import java.security.*;
import java.math.*;


/**
 * Code for AoC 2015 Q4
 * Has 1 argument, an integer which is the number of leading zeros to check for.
 * 
 * @author Lucas Sherlock
 *
 */
public class Q4 {
	public static final String INPUT = "ckczppom";
	public static String _hexString;
	public static void main(String[] args) {
		
		
		try{
			int num = 0;
			num--;
			do {
				
				/*
				 * Following code adapted from that found at:
				 * 'https://stackoverflow.com/questions/332079/in-java-how-do-i-
				 * convert-a-byte-array-to-a-string-of-hex-digits-while-keeping-l'
				 */
				byte[] hash = MessageDigest.getInstance("MD5").digest((INPUT+num).getBytes());
			    BigInteger bi = new BigInteger(1, hash);
			    _hexString = String.format("%0" + (hash.length << 1) + "x", bi);
			    num++;

			} while(!nLeadingZeros(Integer.parseInt(args[0]), _hexString));
			num--;
			System.out.println(num);
			
			
			
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
	
	public static boolean nLeadingZeros(int n, String hexCode) {
		boolean hasNLeadingZeros = true;
		for(int i = 0; i < n; i++) {
			if(hexCode.charAt(i) != '0') {
				hasNLeadingZeros = false;
				break;
			}
		}
		return hasNLeadingZeros;
	}
	
	
	
}
