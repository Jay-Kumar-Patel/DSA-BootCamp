class Solution {
    public Node connect(Node root) {
        
        Queue<Node> queue = new LinkedList<>();
        
        if(root == null)
            return root;
        
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int currSize = queue.size();
            ArrayList<Node> currLevelList = new ArrayList<>();
            
            for(int i=0; i<currSize; i++){
                
                Node currNode = queue.remove();
                currLevelList.add(currNode);
                
                if(currNode.left != null)
                    queue.add(currNode.left);
                
                if(currNode.right != null)
                    queue.add(currNode.right);
            }
            
            for(int i=0; i<currSize; i++){
                
                if(i == currSize-1)
                    currLevelList.get(i).next = null;
                
                else
                    currLevelList.get(i).next = currLevelList.get(i+1);
            }
        }
        return root;
    }
}