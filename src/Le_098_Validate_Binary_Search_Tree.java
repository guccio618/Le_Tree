import java.util.Stack;


public class Le_098_Validate_Binary_Search_Tree {
	/***********************************************
	 * BST的特征为左边小右边大，可以理解为按前序遍历，
	 * 前面的结点必须比后面的结点小；
	 * 考虑用前序遍历
	 * 
	 ***********************************************/
	// by Jackie using iterator
	public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        } 
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        long preVal = Long.MIN_VALUE;    // 设置成最小值，防止输入就一个结点，且为Integer.MIN_VALUE的情况
        
        while(!s.isEmpty() || root != null){
            while(root != null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(preVal >= root.val){
                return false;
            }
            preVal = root.val;
            root = root.right;
        }
        
        return true;
    }
	
	
	
	/************************************************/
	// by other using recursive
	private long preVal = Long.MIN_VALUE;
    
    public boolean isValidBST2(TreeNode root) {
        if(root == null){
            return true;
        }
        
        boolean leftFlag = isValidBST(root.left);  // 执行完此句，preVal ＝ 左子树的val
        if(preVal >= root.val){
            return false;
        }
        preVal = root.val;         // 把preVal写在这里，表示所去取的是当前结点的val; 
        boolean rightFlag = isValidBST(root.right);
        return leftFlag && rightFlag;
    }
}
