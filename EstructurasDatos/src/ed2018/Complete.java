package ed2018;

public class Complete {

	public Complete() {
		// TODO Auto-generated constructor stub
	}
	
	public void in_post2pre(String inOrder, String postOrder) {
		BinaryTree <String> recovery = new BinaryTree<String>();
		recovery = recoverySubtreeInPost(inOrder, postOrder);
		recovery.preOrder(recovery.getRoot());
	}
	
	public void in_pre2post(String inOrder, String preOrder) {
		BinaryTree <String> recovery = new BinaryTree<String>();
		recovery = recoverySubtreeInPre(inOrder, preOrder);
		recovery.preOrder(recovery.getRoot());
	}
	
	public BinaryTree<String> recoverySubtreeInPre(String subPreOrder, String subInOrder){
		
		if(subInOrder.length()==0)
			return new BinaryTree<String>();
		else {
			BinaryTree<String> temp = new BinaryTree<String>();
			if(subInOrder.length()==1){			
				temp.setRoot(new AVLNode<String>(subInOrder));
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
				
				temp.setRoot(new AVLNode<String>(subInOrder.substring(index, index+1)));
				temp.getRoot().left= recoverySubtreeInPre( subPreOrder, subPreOrder.substring(0, index)).getRoot();
				temp.getRoot().right=recoverySubtreeInPre(subPreOrder, subInOrder.substring(index+1)).getRoot();
			}
			return temp;		
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
