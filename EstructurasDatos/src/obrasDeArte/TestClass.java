package obrasDeArte;

import java.util.Scanner;

import structures.BinarySearchTree;

public class TestClass {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		try {
		int artistas = s.nextInt();
		int nElementos= s.nextInt();
		Galery galeria =  new Galery();
		for(int i=0; i<artistas;i++){
			BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
			for(int j=0; j<nElementos;j++) {
				tree.insert(s.nextInt());
			}
        	galeria.add(tree);
        }
		System.out.println(galeria.getSize());
		s.close();
		} catch (Exception e) {
			e.printStackTrace();;
		}

	}

}
