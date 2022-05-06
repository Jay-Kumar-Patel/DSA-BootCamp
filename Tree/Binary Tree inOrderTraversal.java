class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }
    
    private void inorder(TreeNode root, List<Integer> ans){
        
        if(root == null)
            return;
        
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
        
        return;
    }
}


//Iterative approach (without recursion)
/*class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if(root == null)
            return ans;
        
        addLeftSubTree(root,stack);
        
        while(!stack.isEmpty()){
            
            TreeNode currNode = stack.pop();
            ans.add(currNode.val);
            
            if(currNode.right != null){
                addLeftSubTree(currNode.right, stack);
            }
        }
        
        return ans;
    }
    
    private void addLeftSubTree(TreeNode currNode, Stack<TreeNode> stack){
        
        stack.push(currNode);
        
        while(currNode.left != null){
            stack.push(currNode.left);
            currNode = currNode.left;
        }
        
        return;
    }
    
} */