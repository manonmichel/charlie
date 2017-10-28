package main;

public class Program {
	
	public static void main(String[] args){
		
		String refBgCharlie = "images/charlie_beach.png";
		String refPatternCharlie = "images/charlie.png";
	
	 	int[][] bgCharlie = Helper.read(refBgCharlie);
	 	int[][] patternCharlie = Helper.read(refPatternCharlie);
	 	
	 	double[][] distance = DistanceBasedSearch.distanceMatrix(patternCharlie, bgCharlie); 			
	 	int[] p = Collector.findBest(distance, true);
	 	Helper.drawBox(p[0], p[1], patternCharlie[0].length, patternCharlie.length, bgCharlie);
	 	Helper.show(bgCharlie, "Found!");
	}	
}
