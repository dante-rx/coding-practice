/**
 * 
 */
package codingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author nagendra
 *
 */
public class EmployeeWithLesserThanKBreaks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public static List<List<Integer>> employeeWithLesserThanKBreaks(List<List<Integer>> employeeCalls, int k) {
		List<List<Integer>> list = new ArrayList<>();

		Map<Integer, List<Break>> map = new TreeMap<>();
		for (List<Integer> x : employeeCalls) {
			int id = x.get(0);
			if (!map.containsKey(id)) {
				map.put(id, new ArrayList<>());
			}
			map.get(id).add(new Break(x.get(1), x.get(2)));
		}

		for (Map.Entry<Integer, List<Break>> entry : map.entrySet()) {
			int id = entry.getKey();
			int count = 0;
			List<Break> values = entry.getValue();
			Break current = values.get(0);
			for (int i = 1; i < values.size(); i++) {
				Break next = values.get(i);
				if (next.start <= current.end) {
					// no break;
					current = next;
					continue;
				}
				count++;
			}
			if (count < k) {
				List<Integer> l = new ArrayList<>();
				l.add(id);
				l.add(count);
				list.add(l);
			}
		}

		return list;
	}
}

class Break{
	int start;
	int end;
	Break(int start, int end){
		this.start = start;
		this.end = end;
	}
}
