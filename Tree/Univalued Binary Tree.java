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


//Using BFS
/*class Solution {
    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int requiredValue = root.val;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            TreeNode currNode = queue.remove();
            
            if(currNode.val != requiredValue)
                return false;
            
            if(currNode.left != null)
                queue.add(currNode.left);
            
            if(currNode.right != null)
                queue.add(currNode.right);
            
        }
        return true;
    }
} */