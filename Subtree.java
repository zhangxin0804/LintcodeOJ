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
    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if( T1 == null && T2 == null ){
            return true;
        }
        if( T1 == null && T2 != null ){
            return false;
        }
        if( T1 != null && T2 == null ){
            return  true;
        }
        if( isSameTree(T1, T2) ){
            return true;
        }
        return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }
    
    private boolean isSameTree(TreeNode T1, TreeNode T2){
        if( T1 == null && T2 == null ){
            return true;
        }
        if( (T1 == null && T2 != null) || (T1 != null && T2 == null) ){
            return false;
        }
        if( T1.val != T2.val ){
            return false;
        }
        return isSameTree(T1.left, T2.left) && isSameTree(T1.right, T2.right);
    }
}

/*
public class Solution {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if( T2 == null ){
            return true;
        }else if( T1 == null ){
            return false;
        }
        String t1 = preorderTraversal(T1);
        String t2 = preorderTraversal(T2);
        if( t1.contains(t2) ){
            return true;
        }
        return false;
    }
    private String preorderTraversal(TreeNode T1){
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(T1);
        while( !stack.empty() ){
            TreeNode crt = stack.pop();
            if( crt == null ){
                sb.append("#");
                continue;
            }
            sb.append(crt.val);
            stack.push(crt.right);
            stack.push(crt.left);
        }
        return sb.toString();
    }
}
*/
