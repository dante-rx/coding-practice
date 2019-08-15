package string;

/**
 * 
 * @author nagendra
 *
 */
public class StringReplaceMultipleCharsWithSingle {

	public static void main(String[] args) {
		System.out.println(replaceEWithSingleE("heheheh heeee hee"));
		System.out.println(replaceEWithSingleE("hehehsssssssggggeeeeeeh heeee hee"));
	}

	private static String replaceEWithSingleE(String str) {
		
		StringBuilder sb = new StringBuilder();
		for (int i =0 ; i< str.length() ; i++) {
			int count = 0;
			while (i <  str.length() && str.charAt(i) == 'e' ) {
				i++;
				count++ ;
			}
			
			if (count > 0) {
				sb.append('e');
			}
			
			if (i <  str.length())
				sb.append(str.charAt(i));
			
		}
		
		return sb.toString();
	}

}
