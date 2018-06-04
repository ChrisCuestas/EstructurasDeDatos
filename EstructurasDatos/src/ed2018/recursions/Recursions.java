package ed2018.recursions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Recursions {

	public long[] array ;
	public long[][] matrix;
	
	public int mcdEuclides(int a, int b){
		if(b==0) return a;
		else return mcdEuclides(b, a%b);
	}
	
	public int factorial(int x){
		if(x > 1)
			return x * factorial(x - 1);
		else
			return 1;
	}
	
	public void fibbonacci(int a) throws IOException {
		array= new long[a+1];
		
		array[0] = 0;
		array[1] = 1;

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(array[0] + " " + array[1]+" ");
		bw.flush();
		
		for(int i = 2; i<array.length; i++) {
			array[i]=array[i-1]+array[i-2];
			
			bw.write(array[i] + " ");
			bw.flush();
		}
		bw.write("\n");
		bw.flush();
	}
	
	public void pascalMatrix(int n) throws IOException  {
		
		for(int i=0; i<n; i++) {
			matrix[i][0]=1;
			matrix[i][i]=1;
		}
		
		for(int i=2; i<n-1;i++) {
			for(int j=1; j<i; j++) {
				matrix[i][j]= matrix[i-1][j-1]+matrix[i-1][j];
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				bw.write(matrix[i][j] + " ");
				bw.flush();
				if (j+1==i) {
					bw.write("\n");
					bw.flush();
				}
				
			}
		}
	}
	
	public int multiplicacion(int a, int b) {
		return -1;
	}
	
	public String inversaCadena(String cadena){
		if(cadena.length() == 1)
			return cadena;
		else
			return cadena.substring(cadena.length() - 1) + inversaCadena(cadena.substring(0, cadena.length() - 1));
	}
	
	public boolean isPalindrome(String cadena)
	{
		return cadena.equals( inversaCadena(cadena) ) ? true : false;
	}
	
	public static void main(String[] args) throws IOException {

		long startTime = System.currentTimeMillis();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine().trim());
		Recursions r = new Recursions();
		
		r.matrix = new long[n][n];
		r.pascalMatrix(n);	
		
		System.out.println(r.matrix[n/2][n/2]);
		
		bw.write(r.factorial(15) + "\n"); // output: 2004310016
		
		r.fibbonacci(25); // output: 75025
		
		bw.write(r.multiplicacion(654, 97) + "\n"); // output: 63438
		
		bw.write(r.mcdEuclides(369, 1218) + "\n"); // output: 3
		
		bw.write(r.inversaCadena("asdfghjkl") + "\n"); // output: lkjhgfdsa
		
		r.pascalMatrix(10); 
		/*
		 * 1	
		 * 1	1	
		 * 1	2	1	
		 * 1	3	3	1	
		 * 1	4	6	4	1	
		 * 1	5	10	10	5	1	
		 * 1	6	15	20	15	6	1	
		 * 1	7	21	35	35	21	7	1	
		 * 1	8	28	56	70	56	28	8	1	
		 * 1	9	36	84	126	126	84	36	9	1
		 */
		
		bw.flush();
		bw.close();
		br.close();
		
		long stopTime = System.currentTimeMillis();
		long elapsedTime = (stopTime - startTime);
		System.out.println(elapsedTime);
	}

}