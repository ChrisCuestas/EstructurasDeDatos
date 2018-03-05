package javaEndOfLine;
import java.util.Scanner;



class Solution{
    public static void main(String []argh) {
        Scanner sc = new Scanner(System.in);
        int c=0;
        while(sc.hasNextLine()){
        	c++;
        	System.out.println(c+" "+sc.nextLine());
        }
        sc.close();
    }
}
