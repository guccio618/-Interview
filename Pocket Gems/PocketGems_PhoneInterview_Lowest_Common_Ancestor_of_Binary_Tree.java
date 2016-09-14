
public class PocketGems_PhoneInterview_Lowest_Common_Ancestor_of_Binary_Tree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(left != null && right != null){
            return root;
        } else if(left != null){
            return left;
        } else if(right != null){
            return right;
        } else {
            return null;
        }
    }
}
