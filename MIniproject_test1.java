

public class MIniproject_test1 {
		public static void main(String[] args){
			testGetRed();
	   }
	    public static void testGetRed() { 
			int color = 0b11110000_00001111_01010101;
			System.out.println(Integer.toBinaryString(color));
			int ref = 0b11110000;
			int red = getRed(color);
			if (red == ref) {
				System.out.println("Test passed");
			} else {
				System.out.println("Test failed. Returned value = " + red + " Expected value = " + ref);
			}
	    }
	    public static int getRed(int rgb) {
			String sRGB = Integer.toBinaryString(rgb);
			int red = 0; 
			//System.out.println(sRGB);
			for (int i=0; i<8; i++) {
				int a =  (int) sRGB.charAt(i) -48 ; // pour passer du unicode a int
				System.out.println(sRGB.charAt(i) + "   " + a) ;
				for (int j=7; j>=0; j--) {
					red += (a * power(2, j)) ;
					System.out.print("     " + red + "     ");  // Problem, it does: (1*2^7 + 1*2^6 + ... + 1*2^0)  + (1*2^7 + 1*2^6 + ... + 1*2^0) + ... + (0*2^7 +...)
				}
			}
		System.out.println(red) ;
		return red; 
	}
		public static int power(int a, int b) {
			int result = 1;
			for (int i = 1; i <= b; i++) {
			   result *= a;
			}
			return result ; 
		}
	}

