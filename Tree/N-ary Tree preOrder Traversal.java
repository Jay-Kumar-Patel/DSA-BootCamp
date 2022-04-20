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