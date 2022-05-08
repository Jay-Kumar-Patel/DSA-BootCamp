class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p == null && q == null)
            return true;
        
        if(p == null || q == null || p.val != q.val)
            return false;
        
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}


//Using BFS
/*
class Pair{
    TreeNode p;
    TreeNode q;
    
    Pair(TreeNode p, TreeNode q){
        this.p = p;
        this.q = q;
    }
}

class Solution {
    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add( new Pair(t1,t2));
        
        while(!queue.isEmpty()){
            
            Pair currPair = queue.remove();
            
            TreeNode p = currPair.p;
            TreeNode q = currPair.q;
            
            if(p == null && q == null)
                continue;
            
            if(p == null || q == null || p.val!=q.val)
                return false;
            
            if(p.left != null || q.left != null)
                queue.add(new Pair(p.left,q.left));
            
             if(p.right != null || q.right != null)
                queue.add(new Pair(p.right,q.right));
            
        }
        return true;
    }
}
*/