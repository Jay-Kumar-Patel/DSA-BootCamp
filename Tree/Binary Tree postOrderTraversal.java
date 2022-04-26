class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }
    
    private void postorder(TreeNode root, List<Integer> ans){
        
        if(root == null)
            return;
    
        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
        
        return;
    }
}

//Iterative approach (without recursion)
/*class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if(root == null)
            return ans;
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode currNode = stack.pop();
            
            if(currNode.left != null){
                stack.push(currNode.left);
            }
            
            if(currNode.right != null){
                stack.push(currNode.right);
            }
            
            ans.add(currNode.val);
        }
        
        Collections.reverse(ans);
        return ans;
    } 
} */
