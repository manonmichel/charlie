package main;

/**
 * 
 * @author Name of the students
 *
 *	Where is Charlie Project 
 *
 */
public final class Main {

	/* 
	 * This class is incomplete!!
	 * 
	 * You are expected to write at least one testcase for each required method.
	 * You will find some examples of testcases below.
	 */
	
    public static void main(String[] args) {
    	testGetRed();
    	testGrayscale();
    	testFindNBest();
    	testDistanceBasedSearch();
    	testSimilarityBasedSearch();   
    	findCharlie();
    }
    
    /*
     * Tests for Class ImageProcessing
     */
    public static void testGetRed() { 
    	int color = 0b11110000_00001111_01010101;
    	int ref = 0b11110000;
    	int red = ImageProcessing.getRed(color);
    	if (red == ref) {
    		System.out.println("Test passed");
    	} else {
    		System.out.println("Test failed. Returned value = " + red + " Expected value = " + ref);
    	}
    }
	
    public static void testGetGreen() { 
		int color = 0b11110000_00001111_01010101;
		int ref = 0b00001111;
		int green = ImageProcessing.getGreen(color);
		if (green == ref) {
			System.out.println("Test passed   " + ref);
		} else {
			System.out.println("Test failed. Returned value = " + green + " Expected value = " + ref);
		}
    }
    
    public static void testGetBlue() { 
		int color = 0b11110000_00001111_01010101;
		int ref = 0b01010101;
		int blue = ImageProcessing.getBlue(color);
		if (blue == ref) {
			System.out.println("Test passed   " + ref);
		} else {
			System.out.println("Test failed. Returned value = " + blue + " Expected value = " + ref);
		}
    }
    
    public static void testGetGray() { 
		int color = 0b11110000_00001111_01010101;
		double ref = 113.33333333333333 ;
		double gray = ImageProcessing.getGray(color);
		if (gray == ref) {
			System.out.println("Test passed   " + ref);
		} else {
			System.out.println("Test failed. Returned value = " + gray + " Expected value = " + ref);
		}
    }
    
    public static void testGetRGB() { 
		int ref = 0b11110000_00001111_01010101;
		int red = 0b11110000;
		int green = 0b00001111;
		int blue = 0b01010101;
		int rgb = ImageProcessing.getRGB(red, green, blue);
		if (rgb == ref) {
			System.out.println("Test passed   " + ref);
		} else {
			System.out.println("Test failed. Returned value = " + rgb + " Expected value = " + ref);
		}
    }
    
    public static void testGetRGBFromGray() { 
		int ref = 0x7f7f7f;
		double color = 127 ;
		int rgb = ImageProcessing.getRGB(color);
		if (rgb == ref) {
			System.out.println("Test passed   " + ref);
		} else {
			System.out.println("Test failed. Returned value = " + rgb + " Expected value = " + ref);
		}
    }
    
    public static void testGrayscale() {
    	System.out.println("Test Grayscale");
     	int[][] image = Helper.read("images/food.png");
    	double[][] gray = ImageProcessing.toGray(image);
    	Helper.show(ImageProcessing.toRGB(gray), "test bw");
    }
	
    public static void testMatrixToRGBImage() {
    	 // TO COMPLETE
    }
    
    //TODO: complete
    
        
    /*
     * Tests for Class Collector
     */
    
    public static void testFindNBest() {
    	System.out.println("Test findNBest");
    	double[][] t = new double[][] {{20, 30, 10, 50, 32}, {28, 39, 51, 78, 91}};
    	int[][] coords = Collector.findNBest(10, t, true);    			
    	for (int[] a : coords) {
    		int r = a[0];
    		int c = a[1];
    		System.out.println("Row=" + r + " Col=" + c + " Val=" + t[r][c]);
    	}    
    }

    //TODO: complete

    /*
     * Tests for Class DistanceBasedSearch
     */
    
    public static void testDistanceBasedSearch() {
    	System.out.println("Test DistanceBasedSearch");
    	int[][] food = Helper.read("images/food.png");
    	int[][] onions = Helper.read("images/onions.png");
    	double[][] distance = DistanceBasedSearch.distanceMatrix(onions, food); 			
    	int[] p = Collector.findBest(distance, true);
    	Helper.drawBox(p[0], p[1], onions[0].length, onions.length, food);
    	Helper.show(food, "Found!");
    }
    
    //TODO: complete
    
    /*
     * Tests for Class SimilarityBasedSearch
     */
	
    public static void testMean() {
    		double [][] tab = { {3, 2, 1}, {0, 4, 2} } ; 
    		double ref = 2.0 ; 
    		double mean = SimilarityBasedSearch.mean(tab) ; 
    		if (mean == ref) {
    			System.out.println("Test passed   " + ref);
    		} else {
    			System.out.println("Test failed. Returned value = " + mean + " Expected value = " + ref);
    		}
    }

    public static void testSimilarityBasedSearch() {
    	System.out.println("Test SimilarityBasedSearch");
		int[][] food = Helper.read("images/food.png");
    	int[][] onions = Helper.read("images/onions.png");
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
    
    public static void findCharlie() {
    	System.out.println("Find Charlie");
		int[][] beach = Helper.read("images/charlie_beach.png");
    	int[][] charlie = Helper.read("images/charlie.png");
    	double[][] beachGray = ImageProcessing.toGray(beach);
    	double[][] charlieGray = ImageProcessing.toGray(charlie);    	

    	System.out.println("Compute Similarity Matrix: expected time about 2 min");
    	double[][] similarity = SimilarityBasedSearch.similarityMatrix(charlieGray, beachGray);

    	System.out.println("Find N Best");
    	int[] best = Collector.findBest(similarity, false);   
    	double max = similarity[best[0]][best[1]];
    	
    	Helper.show(ImageProcessing.matrixToRGBImage(similarity, -1, max), "Similarity");
    	
    	Helper.drawBox(best[0], best[1], charlie[0].length, charlie.length, beach);
    	System.out.println("drawBox at (" + best[0] + "," + best[1] + ")");
    	Helper.show(beach, "Found again!");    	
    }
    
    //TODO: complete
}
