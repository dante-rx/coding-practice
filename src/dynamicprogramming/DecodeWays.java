package dynamicprogramming;

/**
 * 
 * @author nagendra
 */
/**
 https://leetcode.com/problems/decode-ways/
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given a non-empty string containing only
 * digits, determine the total number of ways to decode it.
 * 
 * Example 1:
 * 
 * Input: "12" Output: 2 Explanation: It could be decoded as "AB" (1 2) or "L"
 * (12). Example 2:
 * 
 * Input: "226" Output: 3 Explanation: It could be decoded as "BZ" (2 26), "VF"
 * (22 6), or "BBF" (2 2 6).
 *
 */
public class DecodeWays {
	public static void main(String a[]) {
		System.out.println(decodeWays("12"));
		System.out.println(decodeWays("123"));
		System.out.println(decodeWays("121212"));
		assert decodeWays("12") == 2;
		assert decodeWays("123") == 3; // ABC, 
		assert decodeWays("1234") == 3; // ABC,
		System.out.println("Assertion check looks good!!");
	}
	
	private static  int decodeWays(String str) {
		int n = str.length();
		int solution[] = new int[n+1];
		solution[0] = 1;
		solution[1] = str.charAt(0) == '0' ? 0 : 1;
		for (int i =2; i<= n ; i++){
			String lastTwo = str.substring(i-2, i);
			String last = str.substring(i-1, i);
			if (isValid(last) == 1 ){
				solution[i] += solution[i-1];
			}
			if (isValid(lastTwo) == 1){
				solution[i] += solution[i-2];
			}
		}
		return solution[n];
	}

	private static int isValid(String last){
		if (last.length() == 1){
			return last.charAt(0) == '0' ? 0 : 1;
		}else if (last.length() == 2){
			int x = Integer.parseInt(last);
			return  x >= 10 && x <= 26 ? 1 : 0;
		}
		return 0;
	}

}
