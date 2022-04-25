class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null)
            return null;
        
        TreeNode leftAns = invertTree(root.left);
        TreeNode rightAns = invertTree(root.right);
        
        root.left = rightAns;
        root.right = leftAns;
        
        return root;
    }
}