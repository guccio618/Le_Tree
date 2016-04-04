import java.util.LinkedList;
import java.util.Queue;


public class Le_116_Populating_Next_Right_Pointers_in_Each_Node {
	/*********************************************************************
	 * 此题前提必须是完全二叉树；
	 * 一个指针纪录当前的层parent结点位置，另一个指针纪录下一个层nextParent位置
	 *      
	 *********************************************************************/
	
	// 直接在树本身的结构上实现， space O(1)
	public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        
        TreeLinkNode current = root;
        TreeLinkNode nextHead = root.left;
        root.next = null;
        
        while(nextHead != null){
            while(current != null){
                current.left.next = current.right;
                if(current.next == null){
                    current.right.next = null;
                } else {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            current = nextHead;
            nextHead = nextHead.left;
        }
    }
	
	
	
	// 应用层序遍历，速度比直接在结构上做要慢一些, ， space O(n)
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
