package string;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class StringInputStreamConversion {
	public static void main(String a[]) {
		try {
			File file = new File("resources/dummy.txt");
			InputStream is = new FileInputStream(file);
			Scanner sc = new Scanner(is);
			sc.useDelimiter("\\A");
			int count =0;
			while(sc.hasNext()) {
				System.out.println(sc.next());
				
				count++;
			}
			System.out.println(count);
			sc.close();
			is.close();
		}catch(Exception e) {
			
		}
		finally {
			
		}
		
	}

}
