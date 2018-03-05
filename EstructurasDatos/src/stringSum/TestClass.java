package stringSum;

import java.util.*;

class TestClass {

	static char abc[]= {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public static void main(String[] args)throws Exception {
		Scanner s = new Scanner(System.in);
	      String str = s.next().trim();
	      char ch;
	      int sum = 0;
	      for(int i=0; i<str.length();i++) {
		      ch = str.charAt(i);
		      for(int a=0;a<27;a++) {
	        	  if(((Character)ch).equals(abc[a])) {
	        		  sum += a;
	        	  }
	          }
	      }
	      s.close();
	      System.out.println(sum);
	}
}
