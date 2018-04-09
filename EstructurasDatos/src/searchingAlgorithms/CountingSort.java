package data;

public class CountingSort {

	private int[] array;
	
	public CountingSort(int[] array) {
		this.array = array;
	}
	
	public void sort() {
		int max = Integer.MIN_VALUE;
		int[] aux;
		int index = 0;
		
		for(int i=0; i<this.array.length;i++) 
			if(this.array[i]>max) 
				max= this.array[i];
		
		aux= new int[max+1];
		
		for(int i=0; i<this.array.length;i++) 
			aux[this.array[i]]+=1;
		
		for(int i=0; i<aux.length;i++)
			for(int j=0; j<aux[i];j++) {
				this.array[index]=i;
				
			}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
