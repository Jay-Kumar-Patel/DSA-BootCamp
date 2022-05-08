class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            int currLevel = queue.size();
            int currLevelSize = currLevel;
            double sumOfCurrLevelNodes = 0;
            
            while(currLevel > 0){
                
                TreeNode currNode = queue.remove();
                sumOfCurrLevelNodes += currNode.val;
                
                if(currNode.left != null)
                    queue.add(currNode.left);
                
                if(currNode.right != null)
                    queue.add(currNode.right);
                
                currLevel -= 1;
            }
            
           ans.add(sumOfCurrLevelNodes/currLevelSize); 
        }
        
        return ans;
    }
}