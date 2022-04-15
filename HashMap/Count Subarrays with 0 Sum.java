public class Solution {

	public static int countSubarrays(int n, int[] arr) {
		int ans = 0;
		int prefixSum = 0;
		HashMap<Integer,Integer> memo = new HashMap<>();
		memo.put(prefixSum,1);
		
		for(int i=0;i<n;i++){
			prefixSum += arr[i];
			if(memo.containsKey(prefixSum)){
				ans += memo.get(prefixSum);
				memo.put(prefixSum, 1+memo.get(prefixSum));
			}
			else{
				memo.put(prefixSum, 1);
			}	
		}
		return ans;
	}
}
