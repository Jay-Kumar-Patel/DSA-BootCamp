class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] index = {postorder.length-1};
        HashMap<Integer,Integer> inOrderMap = buildMap(inorder);
        return constructTree(postorder,inorder,index,0,postorder.length-1,inOrderMap);
    }
    
    private TreeNode constructTree(int[] postorder, int[] inorder, int[] index, int start, int end, 
                                   HashMap<Integer,Integer> inOrderMap){
        
        if(start > end || index[0] < 0)
            return null;
        
        int currNodeVal = postorder[index[0]];
        index[0] -= 1;
        
        int i = inOrderMap.get(currNodeVal);
        
        TreeNode currNode = new TreeNode(currNodeVal);
    
        currNode.right = constructTree(postorder,inorder,index,i+1,end,inOrderMap);
        currNode.left = constructTree(postorder,inorder,index,start,i-1,inOrderMap);
        
        return currNode;
    }
    
    private HashMap<Integer,Integer> buildMap(int[] inorder){
        HashMap<Integer,Integer> inOrderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inOrderMap.put(inorder[i] , i);
        }
        return inOrderMap;
    }
}