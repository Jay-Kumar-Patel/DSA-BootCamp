class Tree
{
     public ArrayList<Integer> diagonal(Node root)
      {
           ArrayList<Integer> ans = new ArrayList<>();
           HashMap<Integer,ArrayList<Integer>> memo = new HashMap<>();
           int[] maxSlope = {-100000000};
           
           diagonalView(root,0,memo,maxSlope);
           
           for(int i=0;i<=maxSlope[0];i++){
               for(int currVal : memo.get(i)){
                   ans.add(currVal);
               }
           }
           
           return ans;
      }
      
      private void diagonalView(Node root, int slope, HashMap<Integer, ArrayList<Integer>> memo, int[] maxSlope){
          
          if(root == null){
              return;
          }
          
          maxSlope[0] = Math.max(maxSlope[0], slope);
          if(memo.containsKey(slope)){
              memo.get(slope).add(root.data);
          }
          else{
              ArrayList<Integer> current = new ArrayList<>();
              current.add(root.data);
              memo.put(slope, current);
          }
          
          diagonalView(root.left, slope+1, memo, maxSlope);
          diagonalView(root.right, slope, memo, maxSlope);
          
          return;
      }
}