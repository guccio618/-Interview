import java.util.ArrayList;
import java.util.List;


public class PocketGems_PhoneInterview_Find_Leaves_of_Binary_Tree {
	public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        if(root == null){
            return ans;
        }
        
        DFS(root, ans);
        return ans;
    }
    
    public int DFS(TreeNode node, List<List<Integer>> ans){
        if(node == null){
            return -1;
        }
        
        int leftHeight = DFS(node.left, ans);
        int rightHeight = DFS(node.right, ans);
        int curHeight = Math.max(leftHeight, rightHeight) + 1;
        
        if(ans.size() - 1 < curHeight){
            ans.add(new ArrayList<Integer>());
        }
        
        ans.get(curHeight).add(node.val);
        return curHeight;
    }
}
