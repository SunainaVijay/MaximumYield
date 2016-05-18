import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;



public class MaxYield {

	public static void main(String[] args) {
		/* Unit test cases */
		int[] strips1 = { 206, 140, 300, 52, 107}; /* Expected: 613 */
		System.out.println("Maxyield: " + maxYield(strips1));
		
		int[] strips2 = { 147, 206, 52, 240, 300 }; /* Expected: 506 */
		System.out.println("Maxyield: " + maxYield(strips2));
		
		int[] strips3 = { 10, 10, 10, 10 }; /* Expected: 20 */
		System.out.println("Maxyield: " + maxYield(strips3));
		
		int[] strips4 = { 300, 300, 10, 300, 10, 10 }; /* Expected: 610 */
		System.out.println("Maxyield: " + maxYield(strips4));
		
		int[] strips5 = { }; /* Expected: 0 */
		System.out.println("Maxyield: " + maxYield(strips5));
		
		int[] strips6 = { 50 }; /* Expected: 50 */
		System.out.println("Maxyield: " + maxYield(strips6));
	}
	
	/**
	 * 
	 * @param mine_strips
	 * @return maxYield
	 *
	 */
	public static int maxYield(int[] mine_strips) {
		
		List<MineSquare> stripsList = new ArrayList<MineSquare>();
		/* 
		 * Tracking map is used to keep a track of the index of the mines that have been
		 * accounted for while computing the maxYield. This allows us to check if any adjacent
		 * mines have already been accounted for in a fast manner
		 */
		HashMap<Integer,Boolean> trackingMap = new HashMap<Integer,Boolean>();
		int nextidx, previdx;
		
		for(int l=0;l<mine_strips.length;l++) {
			stripsList.add(new MineSquare(l,mine_strips[l]));
		}
		
		/* First sort the input list in descending order */
		Collections.sort(stripsList);
		/* Sum keeps track of the current maxYield */
		int sum=0;
		/* Computed maxYield */
		int maxYield=0;
		int size = stripsList.size();
		
		for (int i=0; i<size; i++) {
			/* Reset the sum and clear the tracking Map */
			sum = 0;
			trackingMap.clear();
			for (int j=i; j<size; j++) {
				nextidx = stripsList.get(j).getIndex() + 1;
				previdx = stripsList.get(j).getIndex() - 1;
				if (((previdx < 0) || (previdx >= 0 && !trackingMap.containsKey(previdx))) &&
				    ((nextidx == size) || (nextidx < size && !trackingMap.containsKey(nextidx))))
				{
					/* 
					 * If previous/next index of the current mine has not already been considered then
					 * it is eligible to be considered in the sum 
					 */
					trackingMap.put(stripsList.get(j).getIndex(), true);
					sum = sum + stripsList.get(j).getStripValue();
				}
				/* Update maxYield only if the current computed sum is higher */
				if (sum > maxYield) {
					maxYield = sum;
				}
			}
		}
		return maxYield;
	}
}
