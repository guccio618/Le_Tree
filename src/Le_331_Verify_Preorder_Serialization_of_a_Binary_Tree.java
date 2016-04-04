import java.util.Stack;


public class Le_331_Verify_Preorder_Serialization_of_a_Binary_Tree {
	/****************************************************************************
	 * 对于一个string的字符串，如：[9,3,4,#,#,1,#,#,2,#,6,#,#], 6,#,# 表示一个叶子结点，
	 * 需要回溯到之前的结点，因此考虑用栈。
	 *  (1). 采用叶子结点删除法，如：6,# 遇到#， 弹出6,#，表示此叶子结点已访问过，
	 *  	 然后将当前的"#"入栈， 相当于将此叶子结点置为null， 即将其删除。
	 *  (2). 最后栈里应该剩余一个"#"，相当于所有其他叶子结点均合理被删除，只剩下null，
	 *  	 否则就返回 false。
	 *      
	 ****************************************************************************/
	
	public boolean isValidSerialization(String preorder) {
        if(preorder == null){
            return true;
        }
        
        String[] nodes = preorder.split(",");
        int n = nodes.length;
        Stack<String> stack = new Stack<String>();
        
        for(int i = 0; i < n; ++i){
        	// 这样的判断方式结构很nice！
            while(nodes[i].equals("#") && !stack.isEmpty() && stack.peek().equals("#")){
                stack.pop();
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
            
            stack.push(nodes[i]);
        }
        
        return (stack.size() == 1 && stack.peek().equals("#"));
     }
}
