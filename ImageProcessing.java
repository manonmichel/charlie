package main;
public final class ImageProcessing {
	
	
	public static int verif(int value) { // Method that deals with values that 
										// are not between 0 and 255
		if (value<0) {					// Every negative value becomes 0
			value=0;
		}
		else if (value>255) {			// Every value > 255 becomes 255
			value=255;
		}
		
		return value;
	} 
	
	
    /**
     * Returns red component from given packed color.
     * @param rgb : a 32-bits RGB color
     * @return an integer,  between 0 and 255
     * @see #getGreen
     * @see #getBlue
     * @see #getRGB(int, int, int)
     */
    public static int getRed(int rgb) {
    		// Computation
		int red = rgb >> 16; // masks the first (from the right) 16 bits (green and blue)
		red = red & 0b11111111 ; // masks everything (the alpha value) except for the first (from the right) 8 bits (red)
		
		// Requirement: output between 0 and 255
		assert red>=0 && red<256 ; 
		// Output: red component of the RGB value
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
    		// Computation
		int green = rgb >> 8;  // masks the first (from the right) 8 bits (blue)
		green = green & 0b11111111 ; // masks everything (alpha and red) except for the first (from the right) 8 bits (green)
		
		// Requirement: output between 0 and 255 
		assert green>=0 && green<256 ; 
		// Output: green component of the RGB value
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
    		// Computation
    		int blue=rgb & 0b11111111; // masks everything (alpha, red, green) except for the first (from the right) 8 bits (blue) 
    		
    		// Requirement: output between 0 and 255 
    		assert blue>=0 && blue<256 ; 
    		//  Output: blue component of the RGB value
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
    		// Computation : divides the sum of red, green and blue components by the number of components 
		double mean = (getRed(rgb)+getGreen(rgb)+getBlue(rgb))/3.0;
		
		// Requirement: output between 0 and 255 
		assert mean>=0 && mean<256 ; 
		// Output: average of the red, green and blue components
	    	return mean;
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
    		// Requirement: inputs between 0 and 255
    		red = verif(red) ; 
    		green = verif(green) ;
    		blue = verif(blue) ;
    	    // Computation: encodes the 3 components in an integer
    		int rgb = (red << 16) | (green << 8) | blue ; 
    		// Output: RGB color
		return rgb ; 
    }  

    /**
     * Returns packed RGB components from given gray-scale value.
     * @param gray : a double 
     * @return a 32-bits RGB color
     * @see #getGray
     */
    	public static int getRGB(double gray) {
    		// Requirements: inputs between 0 and 255 
    		//				 gray to be rounded
		int grayRound = (int) Math.round(gray);
		grayRound = verif(grayRound) ; 
		// Computation: encodes the 3 components, which have the same value grayRound, in an int
		int graytoRGB = getRGB(grayRound,grayRound,grayRound); 
		// Output: RGB color
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
		// Requirement: valid image (at least one pixel)
		assert (image.length > 0) ;
    		
    		// Computation: pixel by pixel, converts RGB values into gray-scale values
		double[][] grayImage = new double [image.length][image[0].length] ;
		for (int i=0; i < image.length; i++) {
			for (int j=0; j<image[i].length; j++)  {
				grayImage [i][j] = getGray(image[i][j]) ;
			}
		}
		// Requirement: non-null output table 
		assert grayImage != null ; 
		
		// Output: double array containing the gray-scale value of each pixel
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
		// Requirement: non-empty table 
		assert (gray.length > 0) ;
    	
		// Computation: pixel by pixel, converts gray-scale values into RGB values
	    	int[][] rgb = new int [gray.length][gray[0].length];
	    	for (int i=0; i < gray.length; ++i ) {
	    		for (int j=0; j < gray[i].length; j++) {
	    			rgb[i][j] = getRGB(gray[i][j]);
	    		}
	    	}
		// Requirement: non-empty output table 
		assert (rgb.length > 0) ;
		
		// Output: double array containing the RGB value of each pixel
	    	return rgb;
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
		// Requirement: non-empty matrix 
		assert (matrix.length > 0) ;
    	
		// Computation: converts double matrix to integer matrix
	    double[][] grayImage = new double [matrix.length][matrix[0].length] ; 
	    	for (int i=0; i < matrix.length; ++i ) {
	    		for (int j=0; j < matrix[i].length; j++) {
	    			grayImage[i][j] = ((matrix[i][j]-min)/(max-min))*255 ; 
	    		}
	    	}
	    	
	    	// Output: array containing a RGB mapping of the matrix  	
	    return toRGB(grayImage); 
    }
    

}
