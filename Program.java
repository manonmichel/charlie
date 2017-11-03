package main;

public class Program {
	
	public static void main(String[] args){
		
		System.out.println("Find Charlie");
		
	 	int[][] beach = Helper.read("images/charlie_beach.png");
	 	int[][] charlie = Helper.read("images/charlie.png");
	 	double[][] beachGray = ImageProcessing.toGray(beach);
        double[][] charlieGray = ImageProcessing.toGray(charlie);
	 	
        // Search based on the Similarity between gray-scale images beachGray and charlieGray
	 	System.out.println("Compute Similarity Matrix: expected time about 2 minutes.");
	 	double[][] similarity = SimilarityBasedSearch.similarityMatrix(charlieGray, beachGray);
	 	
	 	// Looking for the coordinates of the window that resembles the pattern the most
	 	System.out.println("Find Best");
	 	int[] best = Collector.findBest(similarity, false);   
    	
	 	// Drawing a box around that window
	 	Helper.drawBox(best[0], best[1], charlie[0].length, charlie.length, beach);
	 	System.out.println("drawBox at (" + best[0] + "," + best[1] + ")");
	 	Helper.show(beach, "Found!");
	}	
} 
