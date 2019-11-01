package file;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Just simple read and write to -> from a file
 * 
 * @author nagendra
 *
 */
public class FileReadAndWrite {

	public static void main(String a[]) throws Exception {
		/**
		 * Using BufferedReader
		 */
		BufferedReader bf = new BufferedReader(new FileReader(new File("Log.txt")));
		String str = bf.readLine();
		while (str != null) {
			System.out.println(str);
			str = bf.readLine();
		}
		bf.close();

		/**
		 * Using scanner
		 */
		System.out.println("Scanner");
		Scanner sc = new Scanner(new File("Log.txt"));
		while (sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
		sc.close();

		/**
		 * Using Java native I/O APIs
		 */
		System.out.println("Files");
		List<String> collect = Files.lines(new File("Log.txt").toPath()).filter(f -> f.contains("7"))
				.collect(Collectors.toList());
		System.out.println(collect);

		Files.lines(new File("Log.txt").toPath()).filter(f -> f.contains("Error")).collect(Collectors.toList());

	}

}