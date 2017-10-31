package main;

public class DistanceBasedSearch {

	/**
	 * Computes the mean absolute error between two RGB pixels, channel by channel.
	 * @param patternPixel : a integer, the second RGB pixel.
	 * @param imagePixel : a integer, the first RGB pixel.
	 * @return a double, the value of the error for the RGB pixel pair. (an integer in [0, 255])
	 */
	public static double pixelAbsoluteError(int patternPixel, int imagePixel) {
		// Initialization of variables
		int EA = 0; 
		
		// Computation: Sum of absolute difference for each color composition
		//              and division by cardinality 
		EA += Math.abs(ImageProcessing.getRed(patternPixel)-ImageProcessing.getRed(imagePixel)) ;
		EA += Math.abs(ImageProcessing.getGreen(patternPixel)-ImageProcessing.getGreen(imagePixel)) ;
		EA += Math.abs(ImageProcessing.getBlue(patternPixel)-ImageProcessing.getBlue(imagePixel)) ;
		EA /= 3.0 ; 
		
		// Output
		return EA ; 
	}
	

	/**
	 * Computes the mean absolute error loss of a RGB pattern if positioned
	 * at the provided row, column-coordinates in a RGB image
	 * @param row : a integer, the row-coordinate of the upper left corner of the pattern in the image.
	 * @param column : a integer, the column-coordinate of the upper left corner of the pattern in the image.
	 * @param pattern : an 2D array of integers, the RGB pattern to find
	 * @param image : an 2D array of integers, the RGB image where to look for the pattern
	 * @return a double, the mean absolute error
	 * @return a double, mean absolute error value at position (row, col) between the pattern and the part of
	 * the base image that is covered by the pattern, if the pattern is shifted by x and y.
	 */
	public static double meanAbsoluteError(int row, int col, int[][] pattern, int[][] image) {
		// Requirement: pattern and image contain at least 1 pixel 
		assert (pattern.length > 0) && (image.length > 0) ; 
		
		// Initialization of variables & constants
		double EAM = 0;
		int d = (pattern.length * pattern[0].length) ;
		
		// Computation
		for (int i=0; i<pattern.length; i++) {
			for (int j=0; j<pattern[i].length; j++) {
				EAM += pixelAbsoluteError(pattern[i][j], image[row + i][col + j]) ; 
			}
		}
		// Output : division of the sum of absolute errors by number of pixels
		return EAM /= d; 
	}

	/**
	 * Compute the distanceMatrix between a RGB image and a RGB pattern
	 * @param pattern : an 2D array of integers, the RGB pattern to find
	 * @param image : an 2D array of integers, the RGB image where to look for the pattern
	 * @return a 2D array of doubles, containing for each pixel of a original RGB image, 
	 * the distance (meanAbsoluteError) between the image's window and the pattern
	 * placed over this pixel (upper-left corner) 
	 */
	public static double[][] distanceMatrix(int[][] pattern, int[][] image) {
		// Requirement: pattern and image contain at least 1 pixel 
		assert (pattern.length > 0) && (image.length > 0) ; 
		// Requirement: pattern can be contained fully in image
		assert (image.length >= pattern.length) && (image[0].length >= pattern[0].length) ; 
		
		// Initialization of output matrix
		double[][] distanceMatrix = new double [image.length][image[0].length] ;
		
		// Computation: implementation of mean absolute error between 
		//              pattern and image for each pixel of image
		for (int i=0; i < (image.length-pattern.length); i++) {
			for (int j=0; j<(image[i].length-pattern[0].length); j++)  {
				distanceMatrix [i][j] = meanAbsoluteError(i, j, pattern, image) ;
			}
		}
		// Output
		return distanceMatrix; 
	}
}
