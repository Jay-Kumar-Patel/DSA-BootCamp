class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        postorderTraversal(root, ans);
        return ans;
    }
    
    private void postorderTraversal(Node root, List<Integer> ans){
        
        if(root == null)
            return;
        
        List<Node> child = root.children;
        for(Node currChild : child){
            postorderTraversal(currChild, ans);
        }
        
        ans.add(root.val);
        
        return;
    }
}

//Iterative approach (without recursion)
/*class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        
        if(root == null)
            return ans;
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            Node currNode = stack.pop();
            ans.add(currNode.val);
            
            List<Node> childrens = currNode.children;
            for(int i=0; i<childrens.size(); i++){
                stack.push(childrens.get(i));
            }
        }
        
        Collections.reverse(ans);
        return ans;
    }
} */