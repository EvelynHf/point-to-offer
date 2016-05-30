package printFromTopToBottom;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintFromTopToBottom {

}


class Solution {
	
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
		if(null == root) return new ArrayList<Integer>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			list.add(temp.val);
			if(null != temp.left){
				queue.offer(temp.left);
			}
			if(null != temp.right){
				queue.offer(temp.right);
			}
		}
		return list;
	}
	
}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}