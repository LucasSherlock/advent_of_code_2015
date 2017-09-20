import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;

/**
 * Code for Advent of Code Day 2
 * @author Lucas Sherlock
 */
public class Q2 {
	public static final String INPUT = "AoC15_Q2_input.txt";
	
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(INPUT);
			br = new BufferedReader(fr);
			String line = null;
			String[] dims = null;
			int total_paper = 0;
			int total_ribbon = 0;
			int height = 0;
			int width = 0;
			int length = 0;
			
			
			while((line = br.readLine()) != null) {
				dims = line.split("x");
				height = Integer.parseInt(dims[0]);
				width = Integer.parseInt(dims[1]);
				length = Integer.parseInt(dims[2]);
				total_paper += findArea(height,width,length);
				total_ribbon += findRibbonLength(height,width,length);
			}
			
			System.out.println("Total ribbon length: " + total_ribbon);
			System.out.println("Total wrapping paper area: " + total_paper);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static int findArea(int h, int w, int l) {
		int area = 0;
		area = 2*(h*w + h*l + w*l) + Math.min(Math.min(h*w, h*l), w*l);
		return area;
	}
	
	public static int findRibbonLength(int h, int w, int l) {
		int length = 0;
		length = Math.min(Math.min(2*(h+w), 2*(h+l)), 2*(l+w)) + h*w*l;
		
		return length;
	}

}
