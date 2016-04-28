/*****************************************************************************
 * 解题思路：
 * 		(1). BFS, DFS, 递归和非递归
 * 		(2). BST: 通常可以用中序递归的方法，加上全局变量，具体例题见(98)，(99);
 * 		(3). Tree中表示叶子结点的方法：node.left == null && node.right == null
 * 		(4). 涉及树和其子树关系的，通常用递归方法
 * 		(5). 改变树遍历的顺序，可以考虑用stack或者queue, 例如题(114)
 * 		(6). 树的序列化和非序列化，引入ArrayList, 参见题(297)
 * 		(7). BST的插入，删除操作
 * 		(8). 重点题型：98，*99，113，*117，*124, *255, 297，*331, *333, 337，87
 *   
 *****************************************************************************/

public class Datastructure_Definition {
	
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class TreeLinkNode {
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;
  }
