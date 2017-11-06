package main;

public class SimilarityBasedSearch {

	/**
	 * Computes the mean value of a gray-scale image given as a 2D array 
	 * @param image : a 2D double array, the gray-scale Image
	 * @return a double value between 0 and 255 which is the mean value
	 */
	public static double mean(double[][] image) {
		// Requirement: valid image (at least one pixel)
		assert (image.length > 0) ;
		
		// Computation: mean value
		double mean = windowMean(image, 0, 0, image[0].length, image.length) ; 
		
		// Output: mean value
		return mean ; 
	}

	public static double windowMean( double [][] matrix, int row, int col, int width, int height) {
		
		// Requirement: valid image (at least one pixel)
		assert (height > 0) ;
		
		// Initialization of variables
		double mean = 0;
		
		// Computation: sum of each element in matrix divided by dimension of matrix
		for (int currentRow=row ;  currentRow < row + height ; ++currentRow ) {
    			for (int currentCol=col; currentCol < width + col  ; currentCol++) {
    				mean+= matrix[currentRow][currentCol] ; 
    			}
		}
		mean /= (width * height ) ; 
		
		// Requirement: output between 0 and 255 
		assert mean>=0 && mean<256 ; 
		
		// Output: mean value
		return mean ; 
	}
	
	
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
		// Requirement: pattern and image contain at least 1 pixel 
		assert (pattern.length > 0) && (image.length > 0) ; 
		
		// Initialization of variables and constants
		double nccPattern = 0; 
		double nccImage = 0; 
		double innerProduct = 0;
		double nccImageSqrSum = 0;
		double nccPatternSqrSum = 0; 
		double meanPattern = mean(pattern) ; 
		double meanImage = windowMean(image, row, col, pattern[0].length, pattern.length) ;
		
		// Computation: different terms needed to compute normalized cross correlation
		for (int currentRow=0; currentRow < pattern.length; ++currentRow ) {
			for (int currentCol=0; currentCol < pattern[currentRow].length; currentCol++) {
				nccPattern = pattern[currentRow][currentCol] - meanPattern; 
				nccImage = image[currentRow+row][currentCol+col]- meanImage ; 
				innerProduct += (nccImage)*(nccPattern) ; 
				nccImageSqrSum += (nccImage)*(nccImage) ; 
				nccPatternSqrSum += (nccPattern)*(nccPattern) ; 	
			}
		}
		double denom = Math.sqrt(nccImageSqrSum*nccPatternSqrSum) ;
		
		// Verification du cas limite 
		if (denom==0) {
			return -1 ;
		} else {
		// Output: normalized cross corelation
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
		// Requirement: pattern and image contain at least 1 pixel 
		assert (pattern.length > 0) && (image.length > 0) ; 
		
		
		// Initialization of output matrix
		double[][] similarityMatrix = new double [image.length][image[0].length] ;
		
		// Implementation of output matrix 
		for (int currentRow=0; currentRow < (image.length-pattern.length); currentRow++) {
			//start = System.nanoTime();
			for (int currentCol=0; currentCol<(image[currentRow].length-pattern[0].length); currentCol++)  {
				similarityMatrix [currentRow][currentCol] = normalizedCrossCorrelation(currentRow, currentCol, pattern, image) ;
			}

		}
		
		// Output: double-array containing the NCC between the pattern and the background image window
		return similarityMatrix; 
	}

}
