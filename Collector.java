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

	int[] bestCoord = new int[2];

	if (smallestFirst) {

		double bestdistance = Double.POSITIVE_INFINITY;

		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length;j++) {
				//System.out.print(matrix [i][j]) ;
				if (bestdistance>matrix[i][j] && matrix[i][j]!=0) {  // Pour corriger des erreurs liées à la valeur 0
					bestdistance = matrix[i][j]; 
					bestCoord[0]=i;
					bestCoord[1]=j;
				}
			}
			//System.out.println();
		}
	}

	else {

		double bestdistance = Double.NEGATIVE_INFINITY;

		for (int i=0;i<matrix.length;i++) {
			for (int j=0; j<matrix[i].length;j++) {
				if (bestdistance<matrix[i][j]) {
					bestdistance = matrix[i][j];

					bestCoord[0]=i;
					bestCoord[1]=j;
				}


			}
		}
	}
	//Helper.show(ImageProcessing.matrixToRGBImage(matrix, 0, 255), "Distance 2");
	//System.out.println(matrix[bestCoord[0]][bestCoord[1]]);
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
		// Creating copy of matrix
		double [][] matrixCopy = new double [matrix.length][matrix[0].length] ; 
		for (int i=0; i < (matrix.length); i++) {
			for (int j=0; j<(matrix[i].length); j++)  {
				matrixCopy[i][j] = matrix[i][j] ;
			}
		}
		
		// Computing n best coordinates
		int [][] bestNCoord = new int [n][2] ; 
		for (int k=0; k<n; k++) {
			int [] bestCoord = findBest(matrixCopy, smallestFirst) ; 
			bestNCoord[k][0] = bestCoord[0] ;
			bestNCoord[k][1] = bestCoord[1] ;
		
		// Eliminating best coordinate by replacing with infinite value 
			if (smallestFirst) {
				matrixCopy[bestCoord[0]][bestCoord[1]] = Double.POSITIVE_INFINITY ;
			} else {
				matrixCopy[bestCoord[0]][bestCoord[1]] = Double.NEGATIVE_INFINITY ;
			}
			
		}
		
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
