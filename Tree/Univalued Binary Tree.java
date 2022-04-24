class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return checkUnivalTree(root,root.val);
    }
    
    private boolean checkUnivalTree(TreeNode root, int val){
        
        if(root == null)
            return true;
        
        if(root.val != val)
            return false;
        
        return checkUnivalTree(root.left,val) && checkUnivalTree(root.right,val);
    }
}