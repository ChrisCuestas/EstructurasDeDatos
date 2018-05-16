package ed2018;

public class Complete {

	public Complete() {
		// TODO Auto-generated constructor stub
	}
	
	public BinaryTree<String> recoverySubtree(String subPreOrder, String subInOrder){
		
		if(subInOrder.length()==0)
			return new BinaryTree<String>();
		else {
			BinaryTree<String> temp = new BinaryTree<String>();
			if(subInOrder.length()==1){			
				temp.setRoot(new TreeNode<String>(subInOrder));
			} else {
				int[] indexes = new int[subInOrder.length()];
				int less = Integer.MAX_VALUE, index= -1;
				
				for(int i=0; i<subInOrder.length();i++) 
					indexes[i]=subPreOrder.indexOf(subInOrder.charAt(i)+"");
				
				for(int i=0; i<indexes.length; i++) 
					if(indexes[i]<less) {
						index=i;
						less = indexes[i];
					}
				
				temp.setRoot(new TreeNode<String>(subInOrder.substring(index, index+1)));
				temp.getRoot().left= recoverySubtree( subPreOrder, subPreOrder.substring(0, index)).getRoot();
				temp.getRoot().right=recoverySubtree(subPreOrder, subInOrder.substring(index+1)).getRoot();
			}
			return temp;		
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
