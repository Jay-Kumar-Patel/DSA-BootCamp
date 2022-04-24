class Solution {
    public int sumRootToLeaf(TreeNode root){
        int[] ans = {0};
        sumOfLeaf(root, "" + Integer.toString(root.val), ans);
        return ans[0];
    }
    
    private void sumOfLeaf(TreeNode root, String currentPath, int[] ans){
        
        if(root.left == null && root.right == null){
            ans[0] += Integer.parseInt(currentPath,2);
            return;
        }
        
        if(root.left != null)
            sumOfLeaf(root.left, currentPath + Integer.toString(root.left.val), ans);
        
        if(root.right != null)
            sumOfLeaf(root.right, currentPath + Integer.toString(root.right.val), ans);
        
        return;
    }
}