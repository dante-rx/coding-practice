/**
 * 
 */
package random;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author nagendra
 *
 */
public class RandomLineInFile {

	public static void main(String[] args) throws Exception {
		 System.out.println(readRandomLine("tree.MD"));
		 System.out.println(readRandomLine2("tree.MD"));
		

	}

	/**
	 * Just simply use an array and use it. Brute force and naive approach
	 * @param myfile
	 * @return
	 * @throws FileNotFoundException
	 */
	private static String readRandomLine(String myfile) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(myfile));
		List<String> list = new ArrayList<>();
		while(sc.hasNext()) {
			list.add(sc.next());
		}
		sc.close();
		
		Random random = new Random();
		int nextInt = random.nextInt(list.size()-1);
		return list.get(nextInt);
	}

	
	/**
	 * Effiecient and optimal. This is also called Reservoir sampling
	 * @param myfile
	 * @return
	 * @throws FileNotFoundException
	 */
	private static String readRandomLine2(String myfile) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File(myfile));
		Random random = new Random();
		int n=0;
		String result = null;
		while(sc.hasNext()) {
			n++;
			String nextLine = sc.nextLine();
			if (random.nextInt(n) == 0) {
				result=nextLine;
			}
		}
		sc.close();
		return result;
	}
}
