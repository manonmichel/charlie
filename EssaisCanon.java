package main;

public class EssaisCanon {
	
	 public static void main(String[] args) {
	    	testSimilarityBasedSearch();}
	 
	 public static void testSimilarityBasedSearch() {
	    	System.out.println("Test SimilarityBasedSearch");
			int[][] food = Helper.read("images/image-light.png");
	    	int[][] onions = Helper.read("images/pattern.png");
	    	double[][] foodGray = ImageProcessing.toGray(food);
	    	double[][] onionsGray = ImageProcessing.toGray(onions);    	
	    	double[][] similarity = SimilarityBasedSearch.similarityMatrix(onionsGray, foodGray);
	    	
	    	int[][] best = Collector.findNBest(8, similarity, false);    			
	    	for (int[] a : best) {
	    		int r = a[0];
	    		int c = a[1];
	        	Helper.drawBox(r, c, onions[0].length, onions.length, food);
	    	}
	    	Helper.show(food, "Found again!");    	
	    }
	} 