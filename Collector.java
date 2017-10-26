package main;

import java.util.ArrayList;

public class Collector {

	/**
	 * Find the row, column coordinates of the best element (biggest or smallest) for the given matrix
	 * @param matrix : an 2D array of doubles
	 * @param smallestFirst : a boolean, indicates if the smallest element is the best or not (biggest is then the best)
	 * @return an array of two integer coordinates, row first and then column
	 */
	
	
	
	/** /!\ Les if dans des if me paraissent un peu dangereux though, il faut en discuter! En attendants je mets en mode annotation.
	
public static int[] findBest(double[][] matrix, boolean smallestFirst) {
	
	int[] coordonnees = new int[]{};
	
	double bestdistance = matrix[0][0];
	
	for (int i=0; i<matrix.length;i++) {
		for (int j=0; j<matrix[i].length;j++) {
					
				if (smallestFirst) {
					if (bestdistance < matrix[i][j]) {
						bestdistance+=0;
					}
					else {
						bestdistance=matrix[i][j];
					}
				}
				
				else {
					if (bestdistance > matrix[i][j]) {
						bestdistance+=0;
					}
					else {
						bestdistance=matrix[i][j];
					}
				}
				coordonnees[0]=i;
				coordonnees[1]=j;
		}
	}
	return coordonnees;
} **/
    	

	
	/**
	 * Find the row, column coordinate-pairs of the n best (biggest or smallest) elements of the given matrix
	 * @param n : an integer, the number of best elements we want to find 
	 * @param matrix : an 2D array of doubles
	 * @param smallestFirst : a boolean,  indicates if the smallest element is the best or not (biggest is the best)
	 * @return an array of size n containing row, column-coordinate pairs
	 */
	public static int[][] findNBest(int n, double[][] matrix, boolean smallestFirst) {

    	// TODO implement me !
		return new int[][]{};
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
