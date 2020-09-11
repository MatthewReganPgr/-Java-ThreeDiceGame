public class Average {
	
	// Main method
	public static void main (String args[]){
		
		// Declaring variables
		double averagePoints = 0;
		int totalCombinations = 0;
	
			// Triple loop which will run 6x6x6 times. while x equals 1 y will also equal 1 and z will loop 6 times.
			// This will give us every result where dice 1 and dice 2 rolls anywhere between 1 and 6.
			// Once z equals 6, y will begin to count to 6 then x will count to 6, giving us are 6x6x6 possible outcomes of a dice roll.
			for (int x = 0; x < 7; x++) {
				for (int y = 0; y < 7; y++) {
					for (int z = 0; z < 7; z++) {
						
						// New dice object is created with the values of x, y and z
						ThreeDiceScorer average = new ThreeDiceScorer (x, y, z);
						// We want to find all possible outcomes of three dice in terms of points not dice values
						// So we need to call the getScore method
						totalCombinations += x + y + z + average.getScore();
					}
				}
			}
		
		// Math.pow is a mathematical function in Java to calculate a number to a power
		// In this case we are calculating 6 to the power of 3 or 6x6x6
		averagePoints = totalCombinations / Math.pow(6, 3);
		System.out.println(averagePoints);
	}
}