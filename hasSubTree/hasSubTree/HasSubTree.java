package hasSubTree;

public class HasSubTree {

}


class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null) return false;
        if(root2 == null) return false;
        boolean tag = false;
        if(root1.val == root2.val) tag = theSameTree(root1, root2);
        if(tag){
            return true;
        }else if(HasSubtree(root1.left, root2)){
            return true;
        }else if(HasSubtree(root1.right, root2)){
            return true;
        }else{
            return false;
        }
    }
    private boolean theSameTree(TreeNode root1, TreeNode root2){
        if(root1 == null){
            if(root2 == null) return true;
            else return false;
        }
        if(root2 == null) return true;
        if(root1.val != root2.val) return false;
        else return theSameTree(root1.left, root2.left) && theSameTree(root1.right, root2.right);
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