class Solution {
    public int sumOfLeftLeaves(TreeNode root){
        return sumLeft(root,false);
    }
    
    private int sumLeft(TreeNode root, Boolean onLeftSide){
        
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null){
            if(onLeftSide == true)
                return root.val;
            else
                return 0;
        }
        
        int leftAns = sumLeft(root.left, true);
        int rightAns = sumLeft(root.right, false);
        
        return leftAns + rightAns;
    }
}