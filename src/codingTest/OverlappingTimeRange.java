package codingTest;

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

class TimeRange {
	/*
	 * Represents a time range (the time between a start time and an end time)
	 * 
	 * Example usage: time_range = TimeRange('3-5')
	 * System.out.println(time_range.start) 3.0
	 */
	float start;
	float end;

	TimeRange(String rangeString) {
		String[] rangeSplit = rangeString.split("-");
		this.start = Float.valueOf(rangeSplit[0]);
		this.end = Float.valueOf(rangeSplit[1]);
	}
}

public class OverlappingTimeRange {

	/*
	 * Inputs: A time range to query for (as a TimeRange object) A business's open
	 * hours (as a List of TimeRanges)
	 * 
	 * Output: The fraction OF THE QUERY TIME RANGE that the business is open. (In
	 * other words, the percentage of the query time range in which the business is
	 * open.) Return this number as a float. This function should NOT do any
	 * rounding.
	 * 
	 * Examples of time ranges: (0, 24) the whole day (9, 17) 9 AM to 5 PM (18,
	 * 23.75) 6 PM to 11:45 PM
	 * 
	 * Examples of open hours: [] closed the entire day [(0, 24)] open the entire
	 * day [(9.5, 17)] open from 9:30 AM to 5 PM [(11, 14), (18, 22)] open from 11
	 * AM to 2 PM, and from 6 PM to 10 PM
	 * 
	 * Assume that the open hours time ranges are in order and non-overlapping.
	 * 
	 * Furthermore, all time ranges (start, end) have the property 0 <= start < end
	 * <= 24.
	 * 
	 * Examples: Query Time Range Open Hours Answer (4, 10) [(0, 24)] 1.0 (7, 11)
	 * [(9, 17)] 0.5 (0, 24) [(0, 2), (20, 24)] 0.25 (5, 22) [] 0.0
	 */
	public float openHoursRatio(TimeRange queryTimeRange, List<TimeRange> openHours) {
		float start = queryTimeRange.start;
		float end = queryTimeRange.end;
		float duration = end-start;
		
		float solution = 0.0f;
		for (TimeRange t: openHours) {
			
			float start1 = t.start;
			float end1 = t.end;
			
			if (start1 >= end || end1 <=start) {
				continue;
			}
			
			if (start1 > start ) {
				if (start1 <=end)
				solution+= (end-start1)/duration;
				else if ( end1 <= end) {
					solution+= (end1-start1)/duration;
					
				}
			} else if (start1 <= start && end1 >= start && end1 <= end) {
				solution+= (end1-start)/duration;
			} 
			
			if (start > start1 && end <= end1) {
				return 1.0f;
			}
		}
				
		if (solution >= 1.0f) {
			return 1.0f;
		}
		return solution;
		
	}
	
	public float openHoursRatioOptimal(TimeRange queryTimeRange, List<TimeRange> openHours) {
		float solutionHours = 0.0f;
		for (TimeRange t: openHours) {
			float hours = Math.min(t.end , queryTimeRange.end) - Math.max(queryTimeRange.start, t.start);
			if (hours>0) {
				solutionHours +=hours;
			}
		}
		float duration = queryTimeRange.end- queryTimeRange.start;
		
		if (solutionHours/duration >  1.0f) {
			return 1.0f;
		}
		
		return solutionHours/duration;
	}

	public static void main(String[] args) {
		try {
			// read input
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			TimeRange queryRange = new TimeRange(br.readLine());
			List<TimeRange> openHours = new ArrayList<>();
			String openHoursString = br.readLine();
			// if business has no open hours, then openHours will be an empty list
			if (!openHoursString.equals("")) {
				for (String rangeString : openHoursString.split(", ")) {
					openHours.add(new TimeRange(rangeString));
				}
			}

			// compute answer
			OverlappingTimeRange solution = new OverlappingTimeRange();
			float openHoursRatio = solution.openHoursRatioOptimal(queryRange, openHours);

			// print output to 2 decimal places
			DecimalFormat f = new DecimalFormat("#0.00");
			System.out.println(f.format(openHoursRatio));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
