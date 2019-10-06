package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Top K hotels based on the feedback. Sort hotels by top reviews at first
 * 
 * @author nagendra
 *
 */
public class Reviwes {
	public static void main(String[] args) {

		System.out.println(awardTopKHotels("breakfast beach citycenter location metro view staff price", "bad poor",
				Arrays.asList(1, 2, 3), Arrays.asList("breakfast. ,bad", "citycenter, ", "metro was stafF"), 3));
	}

	public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords,
			List<Integer> hotelIds, List<String> reviews, int k) {

		Set<String> positiveSet = new HashSet<>();
		for (String keyword : positiveKeywords.split(" ")) {
			positiveSet.add(keyword.toLowerCase());
		}

		Set<String> negativeSet = new HashSet<>();
		for (String keyword : negativeKeywords.split(" ")) {
			negativeSet.add(keyword.toLowerCase());
		}

		Map<Integer, Integer> hotelReview = new HashMap<Integer, Integer>();
		for (int i = 0; i < hotelIds.size(); i++) {
			String review = reviews.get(i);
			review = review.toLowerCase();
			review = review.replaceAll("\\.|,", "");
			String[] split = review.split(" ");
			int count = 0;
			for (String str : split) {
				if (positiveSet.contains(str)) {
					count++;
				}
				if (negativeSet.contains(str)) {
					count--;
				}
			}
			hotelReview.put(hotelIds.get(i), count);
		}

		List<Integer> sol = new ArrayList<Integer>();
		Comparator<Map.Entry<Integer, Integer>> comp = new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return 2 * (Integer.compare(o2.getValue(), o1.getValue())) + Integer.compare(o1.getKey(), o2.getKey());
			}
		};
		Set<Map.Entry<Integer, Integer>> sets = hotelReview.entrySet();

		hotelReview.entrySet().stream().sorted(comp).forEachOrdered(x -> sol.add(x.getKey()));

		return k < sol.size() ? sol.subList(0, k) : sol;
	}

}
