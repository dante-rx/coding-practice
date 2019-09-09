/**
 * 
 */
package javacoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * @author nagendra
 *
 */
public class RandomCode1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// checking seed for Random function
		randomString(-229985452);
		System.out.println("------------");
		randomString(-229985452);

		// Checking uuid generation
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());

		// List<String> to String[];
		List<String> list = new ArrayList<>();
		list.add("sss");
		list.add("eee");
		list.add("kkk");

		String a[] = list.toArray(new String[0]); // This is much faster than new String[list.length]
		// https://stackoverflow.com/questions/4042434/converting-arrayliststring-to-string-in-java
		System.out.println(Arrays.toString(a));

		long time1 = System.currentTimeMillis();
		usingStringConcatenation(100000);
		System.out.println("usingStringConcatenation " + (System.currentTimeMillis() - time1) + " ms");

		time1 = System.currentTimeMillis();
		usingStringBuilder(100000);
		System.out.println("usingStringBuilder " + (System.currentTimeMillis() - time1) + " ms");

	}

	private static void usingStringBuilder(int n) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < n; i++)
			str.append("myBigString");
	}

	private static void usingStringConcatenation(int n) {
		String str = "";
		for (int i = 0; i < n; i++)
			str += "myBigString";
	}

	private static void randomString(int i) {
		Random ran = new Random(i);
		System.out.println(ran.nextInt());
		System.out.println(ran.nextInt());
		System.out.println(ran.nextInt());
		System.out.println(ran.nextInt());
		System.out.println(ran.nextInt());

	}

}
