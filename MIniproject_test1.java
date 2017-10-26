package main;
public class MIniproject_test1 {
		public static void main(String[] args){
			//System.out.println(getRGB(127, 127, 127) );
			testGrayscale() ;
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
	    
	    public static void testGetGreen() { 
			int color = 0b11110000_00001111_01010101;
			System.out.println(Integer.toBinaryString(color));
			int ref = 0b00001111;
			int green = getGreen(color);
			if (green == ref) {
				System.out.println("Test passed   " + ref);
			} else {
				System.out.println("Test failed. Returned value = " + green + " Expected value = " + ref);
			}
	    }
	    
	    public static int getRGB(int red, int green, int blue) {
	    		String rgb =  String.format("%1$02x",red) + String.format("%1$02x",green) + String.format("%1$02x",blue);
	    		int valueOf = Integer.valueOf(rgb, 16) ;
	    		return valueOf ; 
	    	}
	    
	    public static int getRed(int rgb) {
			int red = rgb >> 16;
			return red; 
	    }
	    
	    public static int getGreen(int rgb) {
			int green = rgb >> 8;
			green = green & 0b11111111 ;
			return green; 
	    }
	    
	    public static int getBlue(int rgb) {
    			int blue=rgb & 0b11111111; // using mask &
    			return blue;
	    }
	    
		public static int power(int a, int b) {
			int result = 1;
			for (int i = 1; i <= b; i++) {
			   result *= a;
			}
			return result ; 
		}
		
	    public static void testGrayscale() {
	    	System.out.println("Test Grayscale");
	     	int[][] image = Helper.read("images/food.png");
	    	double[][] gray = toGray(image);
	    	Helper.show(toRGB(gray), "test bw");
	    }
	    
	    	public static int getRGB(double gray) {
			int grayRound = (int) Math.round(gray);
			int graytoRGB = getRGB(grayRound,grayRound,grayRound);
			return graytoRGB;
	    }
	    
	    public static double[][] toGray(int[][] image) {
    		double[][] grayImage = new double [image.length][image[0].length] ;
    		for (int i=0; i < image.length; i++) {
    			for (int j=0; j<image[i].length; j++)  {
    				grayImage [i][j] = getGray(image[i][j]) ;
    			}
    		}
    		return grayImage;
    		
	    }
	
	 public static int[][] toRGB(double[][] gray) {
    		int[][] colorImage = new int [gray.length][gray[0].length];
    		for (int i=0; i < gray.length; ++i ) {
    			for (int j=0; j < gray[i].length; j++) {
    			colorImage[i][j] = getRGB(gray[i][j]);
    			}	
    		}
    	return colorImage;
    	}
    		
    	    public static double getGray(int rgb) {
        		double moyenne = (getRed(rgb)+getGreen(rgb)+getBlue(rgb))/3.0;
        		return moyenne;
        }
    	    

    	    
}

