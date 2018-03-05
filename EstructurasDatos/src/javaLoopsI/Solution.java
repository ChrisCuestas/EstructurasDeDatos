package javaLoopsI;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            int N=sc.nextInt();
            sc.close();
            for(int i=1;i<11;i++)
            {
                int x=N*i;
                System.out.println(N+" x "+i+" = "+x);
            }
    }
}