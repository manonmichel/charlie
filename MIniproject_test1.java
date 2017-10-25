

public class MIniproject_test1 {
		public static void main(String[] args){
			testGetRed();
	   }
	    public static void testGetRed() { 
			int color = 0b11110000_00001111_01010101;
			int ref = 0b11110000;
			int red = getRed(color);
			//if (red == ref) {
			//	System.out.println("Test passed");
			//} else {
			//	System.out.println("Test failed. Returned value = " + red + " Expected value = " + ref);
			//}
	    }
	    public static int getRed(int rgb) {
			String sRGB = "" + rgb;
			int red = 0; 
			System.out.print(sRGB);
			//for (int i=2; i<10; i++) {
				//int a = (int) sRGB.charAt(i) ; 
				//for (int j=0; j<8; j++) {
					//red += (a * power(2, j)) ;
				//}
			//}
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

