class Pair{
    Node node;
    int hd;
    
    Pair(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
} 

class Solution
{
    ArrayList<Integer> topView(Node root)
    {
        HashMap<Integer,Integer> memo = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Pair> queue = new LinkedList<>();
        
        int minhd = 100000000;
        int maxhd = -100000000;
        
        queue.add(new Pair(root,0));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0;i<size;i++){
                Pair currPair  = queue.remove();
                Node currNode = currPair.node;
                int hd = currPair.hd;
            
                if(!memo.containsKey(hd)){
                    memo.put(hd, currNode.data);
                    minhd = Math.min(minhd, hd);
                    maxhd = Math.max(maxhd, hd);
                }
                
                if(currNode.left != null){
                    queue.add(new Pair(currNode.left, hd-1));
                }
                
                if(currNode.right != null){
                    queue.add(new Pair(currNode.right, hd+1));
                }
            }
            
        }
        
        for(int i=minhd; i<=maxhd; i++){
            ans.add(memo.get(i));
        }
        
        return ans;
    }
    
}