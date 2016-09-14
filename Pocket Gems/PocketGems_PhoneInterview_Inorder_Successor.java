
public class PocketGems_PhoneInterview_Inorder_Successor {
	// successor, time complexity is O(logh);
	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null){
            return null;
        }
        
        TreeNode successor = null;
        
        while(root != null){
            if(root.val > p.val){
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            } 
        }
        
        return successor;
    }
	
	// precessor
	public static TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
		if(root == null || p == null){
            return null;
        }
		
		TreeNode predecessor = null;
		
		while(root != null){
			if(root.val < p.val){
				predecessor = root;
				root = root.right;
			} else {
				root = root.left;
			}
		}
		
		return predecessor;
	}
	
	
	
	/********************** main ****************************/
	
	public static void main(String[] args){
		TreeNode root7 = new TreeNode(7);
		TreeNode node5 = new TreeNode(5);
		TreeNode node9 = new TreeNode(9);
		TreeNode node3 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node8 = new TreeNode(8);
		TreeNode node10 = new TreeNode(10);
		
		root7.left = node5;
		root7.right = node9;
		node5.left = node3;
		node5.right = node6;
		node9.left = node8;
		node9.right = node10;
		
		System.out.println(inorderSuccessor(root7, node5).val);
		System.out.println(inorderPredecessor(root7, node5).val);
		
	}
}
