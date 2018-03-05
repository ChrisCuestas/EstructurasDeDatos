package javaLoopsII;
import java.util.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for(int j=0; j<n; j++){
            	int p= (int) Math.pow((double)2,(double) j);
            	//System.out.println(p);
            	a=a+(p*b);
            	System.out.print(a+" ");
            }
            System.out.print("\n");
        }
        in.close();
    }
}