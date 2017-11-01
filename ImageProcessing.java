package main;
public final class ImageProcessing {
	
	
	public static int verif(int value) { // Method that deals with values that 
										// are not between 0 and 255
		if (value<0) {
			value=0;
		}
		else if (value>255) {
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
		int red = rgb >> 16; // masks green and blue values
		red = red & 0b11111111 ; // masks alpha value 
		
		// Requirement: output between 0 and 255
		assert red>=0 && red<256 ; 
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
		int green = rgb >> 8;  // using shift
		green = green & 0b11111111 ; // using mask &
		
		// Requirement: output between 0 and 255 
		assert green>=0 && green<256 ; 
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
    		int blue=rgb & 0b11111111; // using mask &
    		
    		// Requirement: output between 0 and 255 
    		assert blue>=0 && blue<256 ; 
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
    		// Computation 
		double mean = (getRed(rgb)+getGreen(rgb)+getBlue(rgb))/3.0;
		
		// Requirement: output between 0 and 255 
		assert mean>=0 && mean<256 ; 
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
    	
    		int rgb = (red << 16) | (green << 8) | blue ; 
		return rgb ; 
    }  

    /**
     * Returns packed RGB components from given gray-scale value.
     * @param gray : a double 
     * @return a 32-bits RGB color
     * @see #getGray
     */
    	public static int getRGB(double gray) {
    		// Requirement: inputs between 0 and 255 
		int grayRound = (int) Math.round(gray);
		gray = verif(grayRound) ; 
		
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
		// Requirement: valid image (at least one pixel)
		assert (image.length > 0) ;
    		
    		
    	
		double[][] grayImage = new double [image.length][image[0].length] ;
		for (int i=0; i < image.length; i++) {
			for (int j=0; j<image[i].length; j++)  {
				grayImage [i][j] = getGray(image[i][j]) ;
			}
		}
		// Requirement: non-null output table 
		assert grayImage != null ; 
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
    	
	    	int[][] rgb = new int [gray.length][gray[0].length];
	    	for (int i=0; i < gray.length; ++i ) {
	    		for (int j=0; j < gray[i].length; j++) {
	    			rgb[i][j] = getRGB(gray[i][j]);
	    		}
	    	}
		// Requirement: non-empty output table 
		assert (rgb.length > 0) ;
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
	    testMatrix(matrix) ; 
	    double[][] grayImage = new double [matrix.length][matrix[0].length] ; 
	    	for (int i=0; i < matrix.length; ++i ) {
	    		for (int j=0; j < matrix[i].length; j++) {
	    			grayImage[i][j] = ((matrix[i][j]-min)/max)*255 ; 
	    		}
	    	}
    	return toRGB(grayImage); 
    }
    
    public static void testMatrix(double[][] matrix) {
    		if (matrix.length<1 || matrix[0].length<1) {
    			System.out.print("Error: The matrix is not valid");
    			return ; 
    		}
    }
}
