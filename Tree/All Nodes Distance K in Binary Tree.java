class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        HashMap<TreeNode, TreeNode> parentMap = findParent(root);
        return findNodesAtKDistance(root,target,k,parentMap);
    }
    
    private List<Integer> findNodesAtKDistance(TreeNode root, TreeNode target, int k, HashMap<TreeNode,TreeNode> parentMap){
        
        List<Integer> ans = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        
        iterateTree(target,k,parentMap,visited,ans);
        return ans;
    }
    
    private void iterateTree(TreeNode currNode, int k, HashMap<TreeNode,TreeNode> parentMap, HashSet<TreeNode> visited, List<Integer> ans){
        
        if(currNode == null || visited.contains(currNode))
            return;
        
        visited.add(currNode);
        
        if(k == 0){
            ans.add(currNode.val);
            return;
        }
        
        iterateTree(currNode.left,k-1,parentMap,visited,ans);
        iterateTree(currNode.right,k-1,parentMap,visited,ans);
        iterateTree(parentMap.get(currNode),k-1,parentMap,visited,ans);
    }
    
    private HashMap<TreeNode, TreeNode> findParent(TreeNode root){
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        iterateTree(root, null, parentMap);
        return parentMap;
    }
    
    private void iterateTree(TreeNode currNode, TreeNode currParent, HashMap<TreeNode, TreeNode> parentMap){
        
        if(currNode == null)
            return;
        
        parentMap.put(currNode,currParent);
        
        iterateTree(currNode.left, currNode, parentMap);
        iterateTree(currNode.right, currNode, parentMap);
        
        return;
    }
}