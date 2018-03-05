package memoriseMe;

import java.util.*;

class TestClass {
  public static void main(String args[] ) throws Exception {

      Scanner s = new Scanner(System.in);
      int N = s.nextInt();
      //ArrayList<Integer> arr= new ArrayList<>(N); //Con ArrayList es poco más lento
      int arr[]= new int[N];
      for(int i=0;i<N;i++){
    	  //arr.add(s.nextInt()); //Con ArrayList
    	  arr[i]=s.nextInt();
      }
      int qs=s.nextInt();
      for (int i = 0; i < qs; i++) {
    	  
          int n=s.nextInt();
          int c=0;
          for(int a:arr) {
        	  if(a==n) c++;
          }
          if(c==0) {
        	  System.out.println("NOT PRESENT");
          }else {
        	  System.out.println(c);
          }
      }
      s.close();
  }
}

