
public class Le_112_Path_Sum {
	/*********************************************************************
	 * 此题必须单独判断叶子结点的情况： root.left == null && root.right == null
	 * 如果只是判断if(root == null) {return sum == 0;}
	 *    有bug:    2      到达结点3后，其左子树为null, 但此时3不是叶子结点
	 *            /  \
	 *           3    4
	 *            \
	 *             5
	 *      
	 *********************************************************************/
	
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        
        // 必须单独判断叶子结点时的情况
        if(root.left == null && root.right == null){
            return (sum == root.val);
        } else {
            return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
        }
    }
}
