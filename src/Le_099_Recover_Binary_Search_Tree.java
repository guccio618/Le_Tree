
public class Le_099_Recover_Binary_Search_Tree {
	/***********************************************
	 * 递归版的前序遍历的结构：
	 * 	travel(node.left)
	 * 		...一些列操作
	 * 	travel(node.right);
	 * 
	 ***********************************************/	
	
	private TreeNode firstElement = null;   // 给定初始值null, 用于后续判断
    private TreeNode secondElement = null;  // 给定初始值null, 用于后续判断
    private TreeNode preElement = new TreeNode(Integer.MIN_VALUE);  // preElement初始值给最小，防止[0, 1]的情况
	
	public void recoverTree(TreeNode root) {
        travel(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    public void travel(TreeNode node){
        if(node == null){
            return;
        }
        travel(node.left);
        if(firstElement == null && node.val < preElement.val){  // 找到第一个元素
            firstElement = preElement;
        } 
        if(firstElement != null && node.val < preElement.val){  // 找到第二个元素
            secondElement = node;
        }
        preElement = node;    // 执行完后才进行preElement的update， 等同于操作之后，进行node = node.next
        travel(node.right);
    }
}
