package main;
public final class ImageProcessing {
	
    /**
     * Returns red component from given packed color.
     * @param rgb : a 32-bits RGB color
     * @return an integer,  between 0 and 255
     * @see #getGreen
     * @see #getBlue
     * @see #getRGB(int, int, int)
     */
    public static int getRed(int rgb) {
	int red = rgb >> 16; // using shift
	return red; 
    }

    /**
     * Returns green component from given packed color.
     * @param rgb : a 32-bits RGB color
     * @return an integer between 0 and 255
     * @see #getRed
     * @see #getBlue
     * @see #getRGB(int, int, int)
     */
    public static int getGreen(int rgb) {
	int green = rgb >> 8;  // using shift
	green = green & 0b11111111 ; // using mask &
	return green;  
    }

    /**
     * Returns blue component from given packed color.
     * @param rgb : a 32-bits RGB color
     * @return an integer between 0 and 255
     * @see #getRed
     * @see #getGreen
     * @see #getRGB(int, int, int)
     */
    public static int getBlue(int rgb) {
    	int blue=rgb & 0b11111111; // using mask &
        return blue;
    }

   
    /**
     * Returns the average of red, green and blue components from given packed color.
     * @param rgb : 32-bits RGB color
     * @return a double between 0 and 255
     * @see #getRed
     * @see #getGreen
     * @see #getBlue
     * @see #getRGB(int)
     */
    public static double getGray(int rgb) {
	double moyenne = (getRed(rgb)+getGreen(rgb)+getBlue(rgb))/3.0;
    	return moyenne;
    }

    /**
     * Returns packed RGB components from given red, green and blue components.
     * @param red : an integer 
     * @param green : an integer 
     * @param blue : an integer
     * @return a 32-bits RGB color
     * @see #getRed
     * @see #getGreen
     * @see #getBlue
     */
    public static int getRGB(int red, int green, int blue) {
	String rgb =  String.format("%1$02x",red) + String.format("%1$02x",green) + String.format("%1$02x",blue); // converts each value to hex and creates a string with the latter
	int valueOfRGB = Integer.valueOf(rgb, 16) ; // converts hex string to int
	return valueOfRGB ; 
    }

    /**
     * Returns packed RGB components from given gray-scale value.
     * @param gray : a double 
     * @return a 32-bits RGB color
     * @see #getGray
     */
    public static int getRGB(double gray) {
	int grayRound = (int) Math.round(gray);
	int graytoRGB = getRGB(grayRound,grayRound,grayRound);
	return graytoRGB;
    }

    /**
     * Converts packed RGB image to gray-scale image.
     * @param image : a HxW integer array
     * @return a HxW double array
     * @see #encode
     * @see #getGray
     */
    public static double[][] toGray(int[][] image) {
	double[][] grayImage = new double [image.length][image[0].length] ;
	for (int i=0; i < image.length; i++) {
		for (int j=0; j<image[i].length; j++)  {
			grayImage [i][j] = getGray(image[i][j]) ;
		}
	}
	return grayImage ;
    }

    /**
     * Converts gray-scale image to packed RGB image.
     * @param channels : a HxW double array
     * @return a HxW integer array
     * @see #decode
     * @see #getRGB(double)
     */
 
    public static int[][] toRGB(double[][] gray) {
    	int[][] colorImage = new int [gray.length][gray[0].length];
    	for (int i=0; i < gray.length; ++i ) {
    		for (int j=0; j < gray[i].length; j++) {
    			colorImage[i][j] = getRGB(gray[i][j]);
    		}
    	}
    	return colorImage;
    }
	
    /**
     * Convert an arbitrary 2D double matrix into a 2D integer matrix 
     * which can be used as RGB image
     * @param matrix : the arbitrary 2D double array to convert into integer
     * @param min : a double, the minimum value the matrix could theoretically contains
     * @param max : a double, the maximum value the matrix could theoretically contains
     * @return an 2D integer array, containing a RGB mapping of the matrix 
     */
    public static int[][] matrixToRGBImage(double[][] matrix, double min, double max) {
	    	int[][] res = new int [matrix.length][matrix[0].length];
	    	for (int i=0; i < matrix.length; ++i ) {
	    		for (int j=0; j < matrix[i].length; j++) {
	    			res[i][j] = (int) (((matrix[i][j]-min)/max)*255)  ; 
	    		}
	    	}
    	return new int[][]{}; 
    }
}
