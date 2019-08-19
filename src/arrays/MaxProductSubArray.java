/**
 * 
 */
package arrays;

/**
 * @author nagendra
 *
 */
public class MaxProductSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a []= {2,3,-2,4};
		
		System.out.println(maxProduct(new int [] {2,3,-2,4}));
		System.out.println(maxProduct(new int [] {-2,3,-4}));
	}
	
	public  static int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int minNegative = 1;
        int currentProduct = 1;
        for (int i=0; i< nums.length;i++){
        	
            currentProduct = Math.max(nums[i], currentProduct*nums[i]);
            maxProduct = Math.max(currentProduct, maxProduct);
            maxProduct = Math.max(maxProduct, minNegative*nums[i]);
            minNegative = Math.min(nums[i],minNegative*nums[i] );
            
           
        }
        
        return maxProduct;
    }

}