class Solution {
    public int maxDepth(Node root) {
        return height(root);
    }
    
    private int height(Node root){
        
        if(root == null)
            return 0;
        
        int ans = 0;
        for(Node child : root.children){
            ans = Math.max(ans , height(child));
        }
        
        return 1 + ans;
    }
}