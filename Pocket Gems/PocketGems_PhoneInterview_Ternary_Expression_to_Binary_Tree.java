import java.util.Stack;

public class PocketGems_PhoneInterview_Ternary_Expression_to_Binary_Tree {
	public TreeNode convert(char[] expr) {
		if (expr.length == 0) {
			return null;
		}

		TreeNode root = new TreeNode(expr[0]);
		Stack<TreeNode> stack = new Stack<>();

		for (int i = 1; i < expr.length; i += 2) {
			TreeNode node = new TreeNode(expr[i + 1]);

			if (expr[i] == '?') {
				stack.peek().left = node;
			}

			if (expr[i] == ':') {
				stack.pop();
			
				while (stack.peek().right != null) {
					stack.pop();
				}
				
				stack.peek().right = node;
			}

			stack.push(node);
		}

		return root;
	}
}
