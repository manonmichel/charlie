package main;

public class Program {
	
	public static void main(String[] args){
		
		String refbgCharlie = "images/charlie_beach.png";
		String refpatternCharlie = "images/charlie.png";
	
	 	int[][] bgCharlie = Helper.read(refbgCharlie);
	 	int[][] patternCharlie = Helper.read(refpatternCharlie);
	 	
	 	double[][] distance = DistanceBasedSearch.distanceMatrix(patternCharlie, bgCharlie); 			
	 	int[] p = Collector.findBest(distance, true);
	 	Helper.drawBox(p[0], p[1], patternCharlie[0].length, patternCharlie.length, bgCharlie);
	 	Helper.show(bgCharlie, "Found!");
	}	
}
