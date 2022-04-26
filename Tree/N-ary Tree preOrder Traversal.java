class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        preorderTraversal(root, ans);
        return ans;
    }
    
    private void preorderTraversal(Node root, List<Integer> ans){
        
        if(root == null)
            return;
        
        ans.add(root.val);
        List<Node> child = root.children;
        for(Node currChild : child){
            preorderTraversal(currChild, ans);
        }
        
        return;
    }
}

//Iterative approach (without recursion)

/*class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        
        if(root == null)
            return ans;
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            Node currNode = stack.pop();
            ans.add(currNode.val);
            
            List<Node> childrens = currNode.children;
            for(int i=childrens.size()-1; i>=0; i--){
                stack.push(childrens.get(i));
            }
        }
        
        return ans;
    }
} */
