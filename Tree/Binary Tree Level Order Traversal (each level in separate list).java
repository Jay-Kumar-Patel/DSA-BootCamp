class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root == null)
            return ans;
            
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int currSize = queue.size();
            
            List<Integer> currLevel = new ArrayList<>();
            
            while(currSize > 0){
                
                TreeNode currNode = queue.remove();
                
                currLevel.add(currNode.val);

                if(currNode.left != null)
                    queue.add(currNode.left);

                if(currNode.right != null)
                    queue.add(currNode.right);
                
                currSize -= 1;
            }
            
            ans.add(currLevel);
        }
        
        return ans;
        
    }
}