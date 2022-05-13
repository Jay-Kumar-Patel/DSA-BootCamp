class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] index = {0};
        HashMap<Integer,Integer> inOrderMap = buildMap(inorder);
        return constructTree(preorder,inorder,index,0,preorder.length-1,inOrderMap);
    }
    
    private TreeNode constructTree(int[] preorder, int[] inorder, int[] index, int start, int end, 
                                   HashMap<Integer,Integer> inOrderMap){
        
        if(start > end || index[0] >= preorder.length)
            return null;
        
        int currNodeVal = preorder[index[0]];
        index[0] += 1;
        
        int i = inOrderMap.get(currNodeVal);
        
        TreeNode currNode = new TreeNode(currNodeVal);
    
        currNode.left = constructTree(preorder,inorder,index,start,i-1,inOrderMap);
        currNode.right = constructTree(preorder,inorder,index,i+1,end,inOrderMap);
        
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