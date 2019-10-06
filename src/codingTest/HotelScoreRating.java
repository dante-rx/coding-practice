package codingTest;
import java.util.*;
/**
 * @author nagendra
 * 
 *
 */

/*
You have rating (0-10) of the hotels per user in this format:

scores = [
    {'hotel_id': 1001, 'user_id': 501, 'score': 7},
    {'hotel_id': 1001, 'user_id': 502, 'score': 7},
    {'hotel_id': 1001, 'user_id': 503, 'score': 7},
    {'hotel_id': 2001, 'user_id': 504, 'score': 10},
    {'hotel_id': 3001, 'user_id': 505, 'score': 5},
    {'hotel_id': 2001, 'user_id': 506, 'score': 5}
]

Any given hotel might have more than one score.

Implement a function, get_hotels(scores, min_avg_score) that returns a list of hotel ids that have average score equal to or higher than min_avg_score.

get_hotels(scores, 5) -> [1001, 2001, 3001]
get_hotels(scores, 7) -> [1001, 2001]
*/  
public class HotelScoreRating {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Hotel> scores = new ArrayList<>();
		scores.add(new Hotel(1001, 501, 7));
		scores.add(new Hotel(1001, 502, 7));
		scores.add(new Hotel(1001, 503, 7));
		scores.add(new Hotel(2001, 504, 10));
		scores.add(new Hotel(3001, 505, 5));
		scores.add(new Hotel(2001, 506, 5));
		scores.add(new Hotel(2001, 507, 9));
		System.out.println(get_hotels(scores, 5));
		System.out.println(get_hotels(scores, 7));
		System.out.println(get_hotels(scores, 8));

	}

	public static List<Integer> get_hotels(List<Hotel> scores, int s) {
		Map<Integer, List<Integer>> map = new LinkedHashMap<>();
		for (Hotel h : scores) {
			if (!map.containsKey(h.id)) {
				map.put(h.id, new ArrayList<Integer>());
			}
			map.get(h.id).add(h.score);
		}
		List<Integer> list = new ArrayList<>();
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			int key = entry.getKey();
			double average = getAverage(entry.getValue());
			if (average >= s) {
				list.add(key);
			}
		}
		return list;
	}

	public static double getAverage(List<Integer> list) {
		if (list.size() == 0) {
			return 0.0d;
		}
		int sum = 0;
		for (int x : list) {
			sum += x;
		}
		return ((double) sum) / list.size();
	}

}

class Hotel {
	int id;
	int userId;
	int score;

	public Hotel(int id, int userid, int score) {
		this.id = id;
		this.userId = userid;
		this.score = score;
	}
}
