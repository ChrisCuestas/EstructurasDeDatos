package ed2018.inverseList;

import java.util.*;

class TestClass {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int t, n, i;
		t = sc.nextInt();
		for(int z=0;z<t;z++) {
			n = sc.nextInt();
			int[] a = new int[n + 1];
			for(i = 1; i < n + 1; i++) {
				a[i] = sc.nextInt();
			}
			int[] b = new int[n + 1];
			for(i = 1; i <= n; i++) {
				b[a[i]] = i;
			}	
			for(i = 1; i <= n; i++) {
				if(a[i] != b[i]) {
					break;
				}
			}
			if(i == n + 1) {
				System.out.println("inverse");
			} else {
				System.out.println("not inverse");
			}
		}
		sc.close();
	}
}