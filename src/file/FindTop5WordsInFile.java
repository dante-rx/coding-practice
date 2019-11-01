package file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Print Top 5 words most of the times used the file.
 * 
 * @author nagendra
 *
 */
public class FindTop5WordsInFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			/**
			 * Let's gather the list of words
			 */
			Stream<String> lines = Files.lines(new File("LICENSE").toPath());
			List<String> collect = lines.collect(Collectors.toList());
			lines.close();
			// Collect in a map by count
			Map<String, Integer> map = new HashMap<>();
			for(String x:collect) {
				String []y =x.split(" ");
				for (String s:y) {
					map.put(s, map.getOrDefault(s, 0)+1);
				}
			}
			// Create a comparator for treeset
			Comparator<Map.Entry<String,Integer>> mycomp = new Comparator< Map.Entry<String, Integer> >(){
				
				public int compare(Map.Entry<String,Integer> a, Map.Entry<String,Integer> b ) {
					int x = b.getValue() -a.getValue();
					return x == 0 ? 1: x;
				}
			};
			
			Set<Map.Entry<String,Integer>> treeSet = new TreeSet<>(mycomp);
			treeSet.addAll(map.entrySet());
			System.out.println(map);
			System.out.println(treeSet);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
