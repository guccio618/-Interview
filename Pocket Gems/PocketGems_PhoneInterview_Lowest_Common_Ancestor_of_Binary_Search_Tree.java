
public class PocketGems_PhoneInterview_Lowest_Common_Ancestor_of_Binary_Search_Tree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        } else if(p == null){
            return q;
        } else if(q == null){
            return p;
        }
        
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
