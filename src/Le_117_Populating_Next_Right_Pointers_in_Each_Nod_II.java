import java.util.LinkedList;
import java.util.Queue;


public class Le_117_Populating_Next_Right_Pointers_in_Each_Nod_II {
	/*********************************************************************
	 * 此题为116题的follow up
	 *  (1). 不同于116的完全二叉树，此题中只有当current.left和current.right不为null时，
	 *       才进行操作   
	 *       
	 *********************************************************************/
	
	// by other, 在树的结构上实现，space O(1)
	public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
    
        TreeLinkNode nextHead = null;
        TreeLinkNode nextElement = null;
        TreeLinkNode current = root;
        root.next = null;
        
        while(current != null){
            while(current != null){
                if(current.left != null){
                    if(nextElement == null){
                        nextHead = current.left;
                    } else {
                        nextElement.next = current.left;
                    } 
                    nextElement = current.left;
                }
                
                if(current.right != null){
                    if(nextElement == null){
                        nextHead = current.right;
                    } else {
                        nextElement.next = current.right;
                    } 
                    nextElement = current.right;
                }
                
                current = current.next;
            }
            
            current = nextHead;
            nextHead = null;
            nextElement = null;
        }
    }
	
	
	// by Jackie, 使用层序遍历实现，space O(n)
	public void connect2(TreeLinkNode root) {
        if(root == null){
            return;
        }
        
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        int size = 1;
        
        while(!q.isEmpty()){
            TreeLinkNode node = q.poll();
            if(node.left != null){
                q.offer(node.left);
            }
            if(node.right != null){
                q.offer(node.right);
            }
            if(--size == 0){
                size = q.size();
                node.next = null;
            } else {
                node.next = q.peek();
            }
        }
    }
}
