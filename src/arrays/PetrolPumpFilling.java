package arrays;

/**
 * 
 * @author nagendra
 *
 */
public class PetrolPumpFilling {

	public static void main(String[] args) {
		int petrols [] = {5,6,9,4};//{4,6,7,4};
		int distance [] = {4,8,5,7};//{6,5,3,5};
		
		int []gaps = new int [petrols.length];
		for (int i =0; i< petrols.length; i++){
			gaps[i] = petrols[i]- distance[i];
		}
		int startIndex =0, currentSum=gaps[0], totalSum= gaps[0];
		for (int i=1; i< gaps.length; i++){
			
			if(gaps[i] <= currentSum+gaps[i]){
				currentSum = currentSum+gaps[i];
			}else if (gaps[i] > currentSum+gaps[i]){
				currentSum = gaps[i];
				startIndex = i;				
			}
			totalSum+=gaps[i];
			
		}
		if (totalSum >= 0){
			System.out.println(startIndex);
		} else{
			System.out.println("Not possible");
		}
		
		
	}

}
