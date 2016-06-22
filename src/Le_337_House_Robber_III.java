
public class Le_337_House_Robber_III {
	/**********************************************************
	 * 当前结点的最大值取决于左右结点的最大值的和，因此考虑用DP
	 * 	(1). 用一个二维数组, [0]表示当前房子被抢， [1]表示当前房子不抢
	 *      
	 **********************************************************/
	
	public int rob(TreeNode root) {
		if(root == null){
			return 0;
		}
		
		int[] ans = dfs(root);
		return Math.max(ans[0], ans[1]);
	}
	
	public int[] dfs(TreeNode node){
		if(node == null){
			return new int[2];
		}
		
		int[] current = new int[2];
		int[] leftTree = dfs(node.left);
		int[] rightTree = dfs(node.right);
		// [0]表示当前的结点被取值, [1]表示当前的结点不取值 
		current[0] = leftTree[1] + rightTree[1] + node.val;         // 这里是“+”, 左右子树只和
		current[1] = Math.max(leftTree[0], leftTree[1]) + Math.max(rightTree[0], rightTree[1]);    // 需要注意这里，current不偷，其子树层可偷可不偷！！！
		return current;
	}
}
