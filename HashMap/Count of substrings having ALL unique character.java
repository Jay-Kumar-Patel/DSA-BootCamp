public class Main {

	public static int solution(String str) {
		int ans = 0;
		HashMap<Character,Integer> memo = new HashMap<>();
		int release = 0;

		for(int acquire=0; acquire<str.length(); acquire++){
			Character currChar = str.charAt(acquire);

			while(release<acquire && memo.containsKey(currChar)){
				Character discard = str.charAt(release);
				memo.remove(discard);
				release += 1;
			}

			memo.put(currChar, 1);
			ans += acquire - release + 1;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}