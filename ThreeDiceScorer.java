/** This class inherits the values of methods from the ThreeDice class. Using the equations performed in the
*   ThreeDice method we only need to assign point values to the outcomes of various dice rolls.
*   This results in the getScore method which we can call in the Game class to retrieve the score of any given roll.
*   Additionally the result method is called upon to find out what the outcome of a players dice roll was.
*/

public class ThreeDiceScorer extends ThreeDice {
	
	// Declaring variables
	int SumOfDie;
	int score;
	
	// Constructor 
	// Passes the dice rolls from ThreeDice class
	public ThreeDiceScorer(int s1, int s2, int s3) {
		super (s1, s2, s3);
	
		SumOfDie = getDie1() + getDie2() + getDie3(); //Calculation summing three dice rolls 
		
		// Using printResult method in ThreeDice class we can check what the players roll was scored as
		// If the printResult returns runOfThree then we know to add 40 to the sum of the players dice roll
		if (threeSame()) {			// If a player rolls threeSame we take the sum of their dice and add 60
			score = SumOfDie + 60;
		}
		else if (runOfThree()) {
			score = SumOfDie + 40;
		}
		else if (pair()) {
			score = SumOfDie + 20;
		}
		else if (allDifferent()) {
			score = SumOfDie;
		}
	}
	
		// Returns the value of score
		public int getScore() {
			return score;
		}
	
	
	//Prints the resulting points from a players roll depending on which player called the method.
	public void result() {
		
        System.out.print(getDie1() + " " + getDie2() + " " + getDie3() + "   ");
		if (threeSame()) {
			System.out.println("Three the same");
			System.out.println("You scored: " + score);
			System.out.println();
		 }
		else if (runOfThree()) {
			System.out.println("Run of three");
			System.out.println("You scored: " + score);
			System.out.println();
		 }
		else if (pair()) {
            System.out.println("Pair");
			System.out.println("You scored: " + score);
			System.out.println();
		 }
		 else if (allDifferent()) {
            System.out.println("All different");
			System.out.println("You scored: " + score);
			System.out.println();
		 }
	}
	
}
