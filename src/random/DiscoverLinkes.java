/**
 * 
 */
package random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author nagendra
 *
 */

/*
 input
log = [
  { 'user': 'A', 'page': 1},
  { 'user': 'B', 'page': 5},
  { 'user': 'A', 'page': 2},
  { 'user': 'A', 'page': 1},
  { 'user': 'B', 'page': 2},
  { 'user': 'C', 'page': 7},
  { 'user': 'C', 'page': 3},
  { 'user': 'A', 'page': 3},
  { 'user': 'C', 'page': 1},
]

please implement
discover_site_map(log)

discover_site_map returns a representation of the links between pages, using whatever data structure you think is suitable:
1 -> 2, 3
2 -> 1
3 -> 1
5 -> 2
7 -> 3  
 */
public class DiscoverLinkes {

	public static void main(String[] args) {
		List<Page> list = new ArrayList<>();
		list.add(new Page('A', 1));
		list.add(new Page('B', 5));
		list.add(new Page('A', 2));
		list.add(new Page('A', 1));
		list.add(new Page('B', 2));
		list.add(new Page('C', 7));
		list.add(new Page('C', 3));
		list.add(new Page('A', 3));
		list.add(new Page('C', 1));
		
		Map<Character , Integer> map = new HashMap<>();
		Map<Integer, Set<Integer>> links = new HashMap<>();
		
		for (Page p: list) {
			if (!map.containsKey(p.c)) {
				map.put(p.c, p.number);
			}else {
				int prev = map.get(p.c);
				if (!links.containsKey(prev)) {
					links.put(prev, new HashSet<>());
				}
				links.get(prev).add(p.number);
				map.put(p.c, p.number);
			}
		}
		System.out.println(links);
		

	}

}

class Page{
	char c;
	int number;
	
	public Page(char x, int n) {
		this.c = x;
		this.number = n;
	}
}
