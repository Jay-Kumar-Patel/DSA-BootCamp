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