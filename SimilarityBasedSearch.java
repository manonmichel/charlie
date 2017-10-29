package main;

public class SimilarityBasedSearch {

	/**
	 * Computes the mean value of a gray-scale image given as a 2D array 
	 * @param image : a 2D double array, the gray-scale Image
	 * @return a double value between 0 and 255 which is the mean value
	 */
	public static double mean(double[][] image) {
		double mean = 0;
		for (int i=0; i < image.length; ++i ) {
    			for (int j=0; j < image[i].length; j++) {
    				mean+= image[i][j] ; 
    			}
		}
		mean /= (image.length*image[0].length) ; 
		return mean ; 
	}
	/**
	public static double windowMean( double [][] matrix, int row, int col, int width, int height) {
		double mean = 0;
		for (int i=0; i < matrix.length; ++i ) {
    			for (int j=0; j < matrix[i].length; j++) {
    				mean+= matrix[i][j] ; 
    			}
		}
		mean /= width*height ; 
		return mean ; 
	
	}
	**/ 
	
	/**
	 * Computes the Normalized Cross Correlation of a gray-scale pattern if positioned
	 * at the provided row, column-coordinate in a gray-scale image
	 * @param row : a integer, the row-coordinate of the upper left corner of the pattern in the image.
	 * @param column : a integer, the column-coordinate of the upper left corner of the pattern in the image.
	 * @param pattern : an 2D array of doubles, the gray-scale pattern to find
	 * @param image : an 2D array of double, the gray-scale image where to look for the pattern
	 * @return a double, the Normalized Cross Correlation value at position (row, col) between the pattern and the part of
	 * the base image that is covered by the pattern, if the pattern is shifted by x and y.
	 * should return -1 if the denominator is 0
	 */
	public static double normalizedCrossCorrelation(int row, int col, double[][] pattern, double[][] image) {
		// Initialisation des variables 
		double nccPattern = 0; 
		double nccImage = 0; 
		double innerProduct = 0;
		double nccImageSqrSum = 0;
		double nccPatternSqrSum = 0; 
		
		// Boucles 
		for (int i=0; i < pattern.length; ++i ) {
			for (int j=0; j < pattern[i].length; j++) {
				nccPattern = pattern[i][j] - mean(pattern) ; 
				nccImage = image[i+row][j+col]- mean(image) ; 
				innerProduct += (nccImage)*(nccPattern) ; 
				nccImageSqrSum += (nccImage)*(nccImage) ; 
				nccPatternSqrSum += (nccPattern)*(nccPattern) ; 	
			}
		}
		
		// Verification du cas limite 
		double denom = Math.sqrt(nccImageSqrSum*nccPatternSqrSum) ;
		if (denom==0) {
			return -1 ;
		} else {
			return (innerProduct)/(denom);
		}
		
		 
	}

	
	/**
	 * Compute the similarityMatrix between a gray-scale image and a gray-scale pattern
	 * @param pattern : an 2D array of doubles, the gray-scale pattern to find
	 * @param image : an 2D array of doubles, the gray-scale image where to look for the pattern
	 * @return a 2D array of doubles, containing for each pixel of a original gray-scale image, 
	 * the similarity (normalized cross-correlation) between the image's window and the pattern
	 * placed over this pixel (upper-left corner)
	 */
	public static double[][] similarityMatrix(double[][] pattern, double[][] image) {
		
		// TODO implement me !
		return new double[][]{}; 
	}

}
