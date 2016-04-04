import java.util.ArrayList;
import java.util.List;


public class Le_113_Path_Sum_II {
	/*********************************************************************
	 * 此题必须单独判断叶子结点的情况： root.left == null && root.right == null
	 * 求可行的解，通常用递归
	 * 此题为112题目的follow up
	 *      
	 *********************************************************************/
	
	public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null){
            return ans;
        }
        
        List<Integer> path = new ArrayList<Integer>(); 
        dfs(ans, path, root, target);
        return ans;
    }
    
    public void dfs(List<List<Integer>> ans, List<Integer> path, TreeNode node, int target){
        if(node == null){
            return;
        }
        
        path.add(node.val);
        if(node.left == null && node.right == null){
            if(node.val == target){
                ans.add(new ArrayList<Integer>(path));
            }
        } else {
            dfs(ans, path, node.left, target - node.val);
            dfs(ans, path, node.right, target - node.val);
        }
        path.remove(path.size() - 1);
    }
}
