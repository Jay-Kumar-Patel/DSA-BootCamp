class Solution {
    public int sumOfLeftLeaves(TreeNode root){
        return sumLeft(root,false);
    }
    
    private int sumLeft(TreeNode root, Boolean onLeftSide){
        
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null){
            if(onLeftSide == true)
                return root.val;
            else
                return 0;
        }
        
        int leftAns = sumLeft(root.left, true);
        int rightAns = sumLeft(root.right, false);
        
        return leftAns + rightAns;
    }
}


//Using BFS
/*
class Pair{
    TreeNode node;
    boolean isLeftNode;
    
    Pair(TreeNode node, boolean isLeftNode){
        this.node = node;
        this.isLeftNode = isLeftNode;
    }
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        
        Queue<Pair> queue = new LinkedList<>();
        int ans = 0;
        
        queue.add(new Pair(root,false));
        
        while(!queue.isEmpty()){
            Pair currPair = queue.remove();
            TreeNode currNode = currPair.node;
            boolean isLeft = currPair.isLeftNode;
            
            if(currNode.left == null && currNode.right == null && isLeft == true){
                ans += currNode.val;
            }
            
            if(currNode.left!=null)
                queue.add(new Pair(currNode.left,true));
            if(currNode.right!=null)
                queue.add(new Pair(currNode.right,false));
        }
        
        return ans;
    }
} */