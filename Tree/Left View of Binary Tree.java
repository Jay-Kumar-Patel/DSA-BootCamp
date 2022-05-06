class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
        HashMap<Integer,Integer> memo = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        leftSideView(root,0,ans,memo);
        return ans;
    }
    
    private void leftSideView(Node root, int currentLevel, ArrayList<Integer> ans, HashMap<Integer,Integer> memo){
        
        if(root == null)
            return;
        
        if(!memo.containsKey(currentLevel)){
            memo.put(currentLevel, root.data);
            ans.add(root.data);
        }
        
        leftSideView(root.left,currentLevel+1,ans,memo);
        leftSideView(root.right,currentLevel+1,ans,memo);
        
        return;
    }
}

//without HashMap
/*
class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        
        leftSideView(root,0,ans);
        return ans;
    }
    
    private void leftSideView(Node root, int currentLevel, ArrayList<Integer> ans){
        
        if(root == null)
            return;
        
        if(ans.size() == currentLevel){
            ans.add(root.data);
        }
        
        leftSideView(root.left,currentLevel+1,ans);
        leftSideView(root.right,currentLevel+1,ans);
        
        return;
    }
} */
