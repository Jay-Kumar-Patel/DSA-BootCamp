class Solution {
    public int maxDepth(TreeNode root) {
        return height(root);
    }
    
    private int height(TreeNode root){
        
        if(root == null)
            return 0;
        
        int left = height(root.left);
        int right = height(root.right);
    
        return 1 + Math.max(left,right);
    }
    
}


//Using BFS
/*class Solution {
    public int maxDepth(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        int height = 0;
        
        if(root == null)
            return height;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int currLevel = queue.size();
            
            while(currLevel > 0){
                
                TreeNode currNode = queue.remove();
                
                if(currNode.left != null)
                    queue.add(currNode.left);
                
                if(currNode.right != null)
                    queue.add(currNode.right);
                
                currLevel -= 1;
            }
            
            height += 1;
        }
        
        return height;
    }
} */