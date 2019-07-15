package algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/**
 * 
 * @author nagendra
 *
 */
public class MRUCache {

	private static final int CAPACITY = 5;
	Map<Integer, LRUItem> map = new HashMap<>();

	public static void main(String a[]) {
		
		MRUCache cache = new MRUCache();
		for (int i=0; i<20; i++){
			int myint = new Random().nextInt()%10;
			cache.set(myint, 100+myint);
		}
		
		for (int i=0; i<20; i++){
			int myint = new Random().nextInt()%10;
			System.out.println(cache.get(myint));
		}
		
		

	}

	public int get(int x) {
		if (map.containsKey(x)) {
			LRUItem item = map.get(x);
			item.accessCount=item.accessCount+1;
			map.put(x, item);
			return map.get(x).y;
		} else {
			return -1;
		}
	}

	public void set(int x, int y) {
		LRUItem item = map.get(x);
		if (item == null){
			// check the map size
			 if (map.size() == CAPACITY){
				//remove least counted item
				 removeleastCountedItemFromMap();
			 }
			 item = new LRUItem();
			 item.y =y;
			 item.accessCount=1;
		}else{
			item.accessCount +=1;
		}
		map.put(x, item);
		
	}
	
	private void removeleastCountedItemFromMap(){
		int minCount =Integer.MAX_VALUE;
		int key =-1;
		for(Entry<Integer, LRUItem> x:map.entrySet()){
			int count =x.getValue().y;
			if(count < minCount){
				minCount = count;
				key = x.getKey();
			}
		}
		
		if(minCount != Integer.MAX_VALUE){
			map.remove(key);
		}
	}
}

class LRUItem {
	int y;
	int accessCount;
}
