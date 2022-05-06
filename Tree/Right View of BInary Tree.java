class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        HashMap<Integer,Integer> memo = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        
        rightSideView(root,0,ans,memo);
        return ans;
    }
    
    private void rightSideView(TreeNode root, int currentLevel, List<Integer> ans, HashMap<Integer,Integer> memo){
        
        if(root == null)
            return;
        
        if(!memo.containsKey(currentLevel)){
            memo.put(currentLevel, root.val);
            ans.add(root.val);
        }
        
        rightSideView(root.right,currentLevel+1,ans,memo);
        rightSideView(root.left,currentLevel+1,ans,memo);
        
        return;
    }
}

//without HashMap
/*
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        
        rightSideView(root,0,ans);
        return ans;
    }
    
    private void rightSideView(TreeNode root, int currentLevel, List<Integer> ans){
        
        if(root == null)
            return;
        
        if(ans.size() == currentLevel){
            ans.add(root.val);
        }
        
        rightSideView(root.right,currentLevel+1,ans);
        rightSideView(root.left,currentLevel+1,ans);
        
        return;
    }
} */