package javastream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {

	public static void main(String[] args) {
		System.out.println("createRangeAndSkipFirstK");
		createRangeAndSkipFirstK(2);
		System.out.println("\ncreateRangeAndPrintEven");
		createRangeAndPrintEven();
		System.out.println("\ncreateRangePrintSum");
		createRangePrintSum();
		System.out.println("sortAndPrintFirst");
		sortAndPrintFirst();
		System.out.println("AverageOfSquareOfArrayOfInts");
		averageOfSquareOfArrayOfInts();
		System.out.println("StringFiltersAndCollect");
		stringFiltersAndCollect();
		
		System.out.println("filtersAndCollectInHashMap");
		filtersAndCollectInHashMap();
		
		
		Set<String> set = new HashSet<>(Arrays.asList("Apple", "Banana"));
		List<String> collect = Arrays.stream(new String[] {"Apple", "Banana", "Guava"})
		 .filter(x -> set.contains(x))
		 .collect(Collectors.toList());
		System.out.println(collect);
		
		System.out.println("Checking Function.identity");
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		int[] array = list.stream().mapToInt(x -> x).toArray();
		System.out.println(Arrays.toString(array));

		// This will fail compilation.
		/**
		 * you will get compilation error since mapToInt expects ToIntFunction, which is
		 * not related to Function. Also ToIntFunction doesn't have identity() method.
		 */
//		 int[] array2 = list.stream().
//				 mapToInt( Function.identity())
//				 .toArray();
		
		
		

	}

	 private static void filtersAndCollectInHashMap() {
		 Map<String, Integer> map2=Arrays.stream(new String[] {"Apple,10", "Banana,15", "Guava,20"})
		 .map(x -> x.split(","))
		 .filter(x ->  Integer.parseInt(x[1])>12 )
		 .collect(Collectors.toMap(x -> x[0], x-> Integer.parseInt(x[1])));
		 System.out.println(map2);
		 
	}

	private static void stringFiltersAndCollect() {
		 Arrays.stream(new String[] {"Apple", "Banana", "Guava"})
		 .filter(x -> x.contains("G"))
		 .collect(Collectors.toList()) // This will return List<String>
		 .forEach(x-> System.out.println(x));
		
	}

	static void averageOfSquareOfArrayOfInts() {
		Arrays.stream(new int[] {1,2,4,5,6} )
		.map(x -> x*x)
		.average()
		.ifPresent(System.out::println);
	}

	private static void sortAndPrintFirst() {
		 Stream.of("s", "s1", "p1")
		 .sorted() // Sort it
		 .findFirst() // find first
		 .ifPresent(System.out::println); // consume it
		 
		
	}

	static void createRangePrintSum() {
		System.out.println(IntStream
		.range(1, 10)
		.sum());
		
	}

	static void createRangeAndSkipFirstK(int k) {
		IntStream
		.range(1, 10)
		.skip(k)
		.forEach(x -> System.out.print(x + " "));
	}

	static void createRangeAndPrintEven() {
		IntStream
		.range(1, 10)
		.forEach(x -> printIfEven(x));
	}
	
	

	private static void printIfEven(int x) {
		if (x % 2 == 0) {
			System.out.print(x + " ");
		}
	}

}
