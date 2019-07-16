package bitwise;

/**
 * 
 * @author nagendra
 *
 */
public class BitWiseTest1 {

	public static void main(String[] args) {
		int x =39; //(100111)
		int y =12; //(1100)
		//x= x &(~x);
		
		// Let's do And operation
		// x & y = 100=4
		System.out.println("x: "+x+" ,Hexadecimal: "+Integer.toBinaryString(x));
		System.out.println("y: "+y+" ,Hexadecimal: "+Integer.toBinaryString(y));
		int z = x&y;
		System.out.println("And Operation: "+z+ " ,Hexadecimal: "+Integer.toBinaryString(z));
		int z1 = x | y;
		System.out.println("OR Operation: "+z1+ " ,Hexadecimal: "+Integer.toBinaryString(z1));
		int z2 = x ^ y;
		System.out.println("XOR Operation: "+z2+ " ,Hexadecimal: "+Integer.toBinaryString(z2));
		
		// left shift
		int z3 = x <<1;
		System.out.println("Left Shift of  x is : "+z3+ " ,Hexadecimal: "+Integer.toBinaryString(z3));
		z3 =x <<2;
		System.out.println("Left Shift of  x  twice is : "+z3+ " ,Hexadecimal: "+Integer.toBinaryString(z3));
		int z4 = x>>1;
		System.out.println("Right Shift of  x is : "+z4+ " ,Hexadecimal: "+Integer.toBinaryString(z4));
		z4 =x >>2;
		System.out.println("Right Shift of  x  twice is : "+z4+ " ,Hexadecimal: "+Integer.toBinaryString(z4));
		

		
		
		
		
	}

}
