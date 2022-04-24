class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> anst1 = new ArrayList<>();
        List<Integer> anst2 = new ArrayList<>();
        
        isSimilar(root1,anst1);
        isSimilar(root2,anst2);
        
        return anst1.equals(anst2);
    }
    
    private void isSimilar(TreeNode root, List<Integer> ans){
        
        if(root == null)
            return;
        
        if(root.left == null && root.right == null){
            ans.add(root.val);
            return;
        }
        
        isSimilar(root.left, ans);
        isSimilar(root.right, ans);
        
        return;
    }
}