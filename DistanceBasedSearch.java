package main;

public class DistanceBasedSearch {

	/**
	 * Computes the mean absolute error between two RGB pixels, channel by channel.
	 * @param patternPixel : a integer, the second RGB pixel.
	 * @param imagePixel : a integer, the first RGB pixel.
	 * @return a double, the value of the error for the RGB pixel pair. (an integer in [0, 255])
	 */
	public static double pixelAbsoluteError(int patternPixel, int imagePixel) {
		int EA = 0; 
		EA += Math.abs(ImageProcessing.getRed(patternPixel)-ImageProcessing.getRed(imagePixel)) ;
		EA += Math.abs(ImageProcessing.getGreen(patternPixel)-ImageProcessing.getGreen(imagePixel)) ;
		EA += Math.abs(ImageProcessing.getBlue(patternPixel)-ImageProcessing.getBlue(imagePixel)) ;
		EA /= 3.0 ; 

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
	 * should return -1 if the denominator is -1
	 */
	public static double meanAbsoluteError(int row, int col, int[][] pattern, int[][] image) {
		double EAM = 0;
		for (int i=0; i<pattern.length; i++) {
			for (int j=0; j<pattern[i].length; j++) {
				EAM += pixelAbsoluteError(pattern[i][j], image[row + i][col + j]) ; 
			}
		}
		int d = (pattern.length * pattern[0].length) ;
		if (d==-1) {
			return -1 ;
		} else {
			 EAM /= d  ; 
		}
		return EAM; 
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
		double[][] distanceMatrix = new double [image.length][image[0].length] ;
		for (int i=0; i < (image.length-pattern.length); i++) {
			for (int j=0; j<(image[i].length-pattern[0].length); j++)  {
				distanceMatrix [i][j] = meanAbsoluteError(i, j, pattern, image) ;
			}
		}
		return distanceMatrix;  
	}
}
