/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {

    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
            ArrayList<Integer> res = new ArrayList<Integer>();
            if( root == null ){
                return res;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode crt = root;
            while( crt != null || !stack.empty() ){
                while( crt != null ){
                    stack.push(crt);
                    crt = crt.left;
                }
                TreeNode tmp = stack.pop();
                if( tmp.val >= k1 && tmp.val <= k2 ){
                    res.add(tmp.val);
                }
                crt = tmp.right;
            }
            return res;
    }
}
