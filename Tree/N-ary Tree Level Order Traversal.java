class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        if(root == null)
            return ans;
            
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int currSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            
            while(currSize > 0){
                
                Node currNode = queue.remove();
                currLevel.add(currNode.val);

                for(Node currChild : currNode.children)
                    queue.add(currChild);
                
                currSize -= 1;
            }
            
            ans.add(currLevel);
        }
        
        return ans;
    }
}
