class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if(root == null)
            return false;
        
        return isPathPossible(root, targetSum);
    }
    
    private Boolean isPathPossible(TreeNode root, int targetSum){
        
        if(root == null)
            return false;
        
        if(root.left == null && root.right == null){
            if(targetSum - root.val == 0)
                return true;
        }
        
        return isPathPossible(root.left, targetSum - root.val) || isPathPossible(root.right, targetSum - root.val); 
    }
}