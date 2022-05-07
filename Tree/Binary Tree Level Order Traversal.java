class Solution
{
    static ArrayList <Integer> levelOrder(Node root) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        if(root == null)
            return ans;
            
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            Node currNode = queue.remove();
            ans.add(currNode.data);
            
            if(currNode.left != null)
                queue.add(currNode.left);
            
            if(currNode.right != null)
                queue.add(currNode.right);
        }
        
        return ans;
    }
}
