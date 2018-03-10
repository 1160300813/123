package P1;

import java.util.*;
import java.io.*;

public class MagicSquare {
    public static void main(String[] args) throws IOException{
    	try(
            Scanner input = new Scanner(System.in);)
        {
    		try{
                generateMagicSquare(input.nextInt());
    		}
    		catch(NumberFormatException ex) {
    			System.out.println("Invalid input");
    		}
        }
    	for (int i = 0; i < 6; i++) {
            System.out.println(isLegalMagicSquare("src/P1/txt/" + (i+1) + ".txt")); 
    	}
    }
    
    public static void generateMagicSquare(int n) throws NumberFormatException, IOException{
    	int magic[][] = new int [n][n];
    	int row = 0, col = n / 2, i, j, square = n * n;
    	try (
    		BufferedWriter bw = new BufferedWriter(new FileWriter("src/P1/txt/6.txt"));
    	)
    	{
    		
            if (n < 0 || n % 2 == 0) {
        	    throw new NumberFormatException();
            }
    	    for (i = 1; i <= square; i++) {
    		    magic[row][col] = i;
    		    if (i % n == 0)
    			    row++;
    		    else {
    			    if (row == 0)
    				    row = n - 1;
    			    else
    				    row--;
    			    if (col == (n - 1))
    				    col = 0;
    			    else
    				    col++;
    		    }
    	    }
    	    for (i = 0; i < n; i++) {
    		    for (j = 0; j < n; j++) {
    			    String s = magic[i][j] + "\t";
    			    bw.write(s, 0, s.length());
    		    }
    		    bw.newLine();
    	    }
    	}
    }
    
    public static boolean isLegalMagicSquare(String fileName) throws IOException{
    	try(
    	    BufferedReader br = new BufferedReader(new FileReader(fileName));
        )
    	{
    		boolean flag = true;
    		int r = 1;
    		int[][] Matrix;
    		String Line = br.readLine();
    		String[] Liness = Line.split("\t");
    		int Length = Liness.length;
    		Matrix = new int[Length][Length];
    		for (int i = 0; i < Length; i++) {
    			try {
    				Matrix[0][i] = Integer.valueOf(Liness[i]);
    			}
    			catch(NumberFormatException ex) {
    				flag = false;
    				//System.out.print("Number Format Exception : ");
    				
    				return false;
    			}
    		}
    		while((Line = br.readLine())!=null) {
    			String[] Lines = Line.split("\t");
    			if (Length != Lines.length) {
    				//System.out.print("Array Index Out Of Bounds Exception : ");
    				return false;
    			}
    			if (r == Length) {
    				//System.out.print("COL ");
    				return false;
    			}
    			for (int i = 0; i < Length; i++) {
    				try {
    				    Matrix[r][i] = Integer.valueOf(Lines[i]);
    				}
    				catch(NumberFormatException ex) {
    					flag = false;  
    					//System.out.print("Number Format Exception : ");
    					return false;
    				}
    				catch(ArrayIndexOutOfBoundsException ex) {
    					//System.out.print("out : ");
    					return false;
    				}
    			}
    			r++;
    		}
    		int sum = 0;
    		for (int i = 0; i < Length; i++) {
    			sum += Matrix[0][i];
    		}
    		for (int i = 1; i < Length; i++) {
    			int s = 0;
    			for (int j = 0; j < Length; j++) {
    				s += Matrix[i][j];
    			}
    			if (sum != s) {
    				//System.out.print("");
    				flag = false;
    			}
    		}
    		for (int i = 0; i < Length; i++) {
    			int s = 0;
    			for (int j = 0; j < Length; j++) {
    				s += Matrix[j][i];
    			}
    			if (sum != s) {
    				//System.out.print("");
    				flag = false;
    			}
    		}
    		int s1 = 0;
    		int s2 = 0;
    		for (int i = 0; i < Length; i++) {
    			s1 += Matrix[i][i];
    			s2 += Matrix[i][Length-i-1];
    		}
    		if (sum != s1 || sum != s2) {
    			//System.out.print("");
    			flag = false;
    		}
    	    return flag;
    	    
    	}
    }
}
