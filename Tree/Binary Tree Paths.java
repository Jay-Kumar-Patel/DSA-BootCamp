class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        getTreePaths(root, "" + Integer.toString(root.val), ans);
        return ans;
    }
    
    private void getTreePaths(TreeNode root, String currentPath, List<String> ans){
        
        if(root.left == null && root.right == null){
            ans.add(currentPath);
            return;
        }
        
        if(root.left != null)
            getTreePaths(root.left, currentPath + "->" + Integer.toString(root.left.val), ans);
        
        if(root.right != null)
            getTreePaths(root.right, currentPath + "->" + Integer.toString(root.right.val), ans);
        
        return;
    }
}