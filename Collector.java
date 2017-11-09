package main;

import java.util.ArrayList;

public class Collector {

	/**
	 * Find the row, column coordinates of the best element (biggest or smallest) for the given matrix
	 * @param matrix : an 2D array of doubles
	 * @param smallestFirst : a boolean, indicates if the smallest element is the best or not (biggest is then the best)
	 * @return an array of two integer coordinates, row first and then column
	 */
	public static int[] findBest(double[][] matrix, boolean smallestFirst) {
		
		// Initialization of output matrix
		int[] bestCoord = new int[2];
		
		if (smallestFirst) { // If we need the smallest element
			
			double bestdistance = Double.POSITIVE_INFINITY; // The initial value is as big as possible
			
			// Computation: compares the elements two by two 
			//              and keeps the smallest value each time		
	
			for (int currentRow = 0; currentRow < matrix.length; currentRow++) {
				for (int currentCol = 0; currentCol < matrix[0].length; currentCol++) {
					if (bestdistance>matrix[currentRow][currentCol]) { 
						bestdistance = matrix[currentRow][currentCol]; 
						bestCoord[0]=currentRow;
						bestCoord[1]=currentCol;
					}
				}
			}
		}
		
		else { // If we need the biggest element
			
			double bestdistance = Double.NEGATIVE_INFINITY; // The initial value is as small as possible
				
			// Computation: compares the elements two by two
			//      			and keeps the biggest value each time
			
			for (int currentRow = 0; currentRow < matrix.length; currentRow++) {
				for (int currentCol = 0; currentCol < matrix[0].length; currentCol++) {
					if (bestdistance<matrix[currentRow][currentCol]) {
						bestdistance = matrix[currentRow][currentCol];
						
						bestCoord[0] = currentRow;
						bestCoord[1] = currentCol;
					}

					
				}
			}
		}
		//Requirement: matrix has to be of length 2
		assert (bestCoord.length == 2);
		
		// Output: coordinates of the best element
		return bestCoord;
	}

	
	/**
	 * Find the row, column coordinate-pairs of the n best (biggest or smallest) elements of the given matrix
	 * @param n : an integer, the number of best elements we want to find 
	 * @param matrix : an 2D array of doubles
	 * @param smallestFirst : a boolean,  indicates if the smallest element is the best or not (biggest is the best)
	 * @return an array of size n containing row, column-coordinate pairs
	 */
	public static int[][] findNBest(int n, double[][] matrix, boolean smallestFirst) {
		// Creating copy of matrix in order to not modify the original
		double [][] matrixCopy = new double [matrix.length][matrix[0].length] ; 
		for (int currentRow = 0; currentRow < matrix.length; currentRow++) {
			for (int currentCol = 0; currentCol < matrix[0].length; currentCol++) {
				matrixCopy[currentRow][currentCol] = matrix[currentRow][currentCol] ;
			}
		}
		
		// Computation: n best coordinates
		int [][] bestNCoord = new int [n][2] ; 
		for (int currentN = 0; currentN < n; currentN++) {
			int [] bestCoord = findBest(matrixCopy, smallestFirst) ; 
			bestNCoord[currentN][0] = bestCoord[0] ;
			bestNCoord[currentN][1] = bestCoord[1] ;
		
		// Eliminating best coordinate by replacing with infinite value 
			if (smallestFirst) {
				matrixCopy[bestCoord[0]][bestCoord[1]] = Double.POSITIVE_INFINITY ;
			} else {
				matrixCopy[bestCoord[0]][bestCoord[1]] = Double.NEGATIVE_INFINITY ;
			}
			
		}
		// Output: coordinates of n best elements
		return bestNCoord;
	}
	
	

	/**
	 * BONUS 
	 * Notice : Bonus points are underpriced ! 
	 * 
	 * Sorts all the row, column coordinates based on their pixel value
	 * Hint : Use recursion !
	 * @param matrix : an 2D array of doubles
	 * @return A list of points, each point is an array of length 2.
	 */
	public static ArrayList<int[]> quicksortPixelCoordinates(double[][] matrix) {

		// TODO implement me correctly for "underpriced" bonus!
		return new ArrayList<int[]>();
	}

	
	/**
	 * BONUS
	 * Notice : Bonus points are underpriced !
	 * 
	 * Use a quick sort to find the row, column coordinate-pairs of the n best (biggest or smallest) elements of the given matrix
	 * Hint : return the n first or n last elements of a sorted ArrayList  
	 * @param n : an integer, the number of best elements we want to find 
	 * @param matrix : an 2D array of doubles
	 * @param smallestFirst : a boolean, indicate if the smallest element is the best or not (biggest is the best)
	 * @return an array of size n containing row, column-coordinate pairs
	 */
	public static int[][] findNBestQuickSort(int n, double[][] matrix, boolean smallestFirst) {

    	// TODO implement me correctly for underpriced bonus!
		return new int[][]{};
	}
}
