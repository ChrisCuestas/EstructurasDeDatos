package gcdStrings;

import java.util.*;
import java.lang.Math;

class TestClass {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		for(int i=0; i<n; i++) {
			int num =  ( f(sc.nextInt(),sc.nextInt())%((int)Math.pow(10, 9)+7));
			System.out.println(num);
		}
		sc.close();
	}
	private static int f(int a,int b) {
		int[] arr=g(a,b);
		int lenght=arr.length;
		int num=0;
		while(lenght>0) {
			num=num+ (arr[lenght-1]*((int) Math.pow(2,arr.length-lenght)));
			lenght--;
		}
		return num;
	}
	private static int[] g(int a, int b) {
		int[] arr= new int[a];//Sin importar el caso, siempre se va a devlover el arreglo arr de longitud a
		if(a%b==0) {//Si a es divisible por b; caso base
			arr[0]=1; //primer numero: 1
			for(int j=1;j<a;j++) {
				arr[j]=0;//siguientes a-1 números: 0
			}
		}else {
			arr = S(a,b);//al arreglo le es agsignado la cadena S(a,b);
		}
		return arr;
	}
	private static int[] S(int a, int b) {//Sea S un arreglo de los primeros a numeros 
										  //de la cadena binaria infinita S°(g(a,b));
		int[] s= new int[a];//Se crea el arreglo que se va a retornar de tañano a
		int[] arr=g(b, a%b);//Se crea el arreglo g(b,a%b), aqui se impementa de forma recursiva.
		int l = arr.length;//Se halla la longitud del arreglo arr.
		if(l>=a) {//Si la longitud no es menor que la long del arreglo s
			for(int i=0; i<a;l++) {
				s[l]=arr[l];//Se le asigna a s los primeros a valores de arr
			}
		}else {//pero si es menor
			int veces = (int) Math.ceil(a/l);//Se calcula las veces a repetir arr
			for(int k=0; k<veces; k++) {
				for(int m=0; m<l;m++) {//se recorre arr 
					s[k*l+m]=arr[m];		// se le asignan los valores a s
					if(k*l+m==a-1) break;	// cuando se llena el arreglo se sale del ciclo
				}
			}
			while(veces>0) {
				for(int m=0; m<l;m++) {//se recorre arr 
					s[veces*l+m]=arr[m];		// se le asignan los valores a s
					if(veces*l+m==a-1) break;	// cuando se llena el arreglo se sale del ciclo
				}
				veces--;
			}
		}
		return s;
	}
}
