/** The main method exists inside this class so this is where the core of the program will run and compute.
*   In this class we take the users input for the number of rounds to play the game for.
*	We also need to generate a random number within the range of 1 to 6 to simulate the rolling of a dice.
*	Additionally many calculations involving the players score, average etc. are all calculated and output 
*	in this class.
*/


// Importing the Scanner function
import java.util.*; 

public class Game {
	
	// Main method
   public static void main(String[] args) {
	   
	   // Declaring variables
	   int pOnePointChecker = 0;
	   int pTwoPointChecker = 0;
	   int pOneTotalWins = 0;
	   int pTwoTotalWins = 0;
	   int pOneAverage = 0;
	   int pTwoAverage = 0;
	   int pOneTotalPoints = 0;
	   int pTwoTotalPoints = 0;
	   
	   
	   // Creating new Scanner object to register user inputs
	   Scanner input = new Scanner(System.in);
	   System.out.println("Enter the number of rounds you would like to play: ");
	   int numRounds = input.nextInt();		// Records the users next input 
       
	   // The game will not continue until the user enters a valid number of rounds (>0)
	   while (numRounds < 0) {
		   System.out.println("Please enter a number of rounds greater than 0");
		   numRounds = input.nextInt();
	   }
		   
	   // The three dice used in the game will be stored in an array of size 3 for each player
	   int[]pOneRoll = new int[3];
	   int[]pTwoRoll = new int[3];
	   
	   // Loop iterates until i equals the number of rounds the user input
	   for (int i = 0; i < numRounds; i++) {
		   pOneRoll[0] = 1 + (int)(6 * Math.random());	// Random integer between 1 and 6 is generated and stored in array position 1. This represents the first dice being rolled
		   pOneRoll[1] = 1 + (int)(6 * Math.random());	// Likewise random integer is stored in second array position
		   pOneRoll[2] = 1 + (int)(6 * Math.random());
		   
		   ThreeDiceScorer playerOne = new ThreeDiceScorer (pOneRoll[0], pOneRoll[1], pOneRoll[2]); // A new object is created out of the ThreeDiceScorer class and the values of
																									//  each dice roll are stored within
		   
		   pTwoRoll[0] = 1 + (int)(6 * Math.random()); // The same process as above is repeated for player twos dice rolls
		   pTwoRoll[1] = 1 + (int)(6 * Math.random());
		   pTwoRoll[2] = 1 + (int)(6 * Math.random());
		   
		   ThreeDiceScorer playerTwo = new ThreeDiceScorer (pTwoRoll[0], pTwoRoll[1], pTwoRoll[2]);
		   
		   
		   // The result method is called from ThreeDiceScorer class.
		   // This prints the outcome of a players roll each round
		   System.out.println();	
		   System.out.println("Player 1: ");
		   playerOne.result();
		   
		   System.out.println("Player 2: ");
		   playerTwo.result();
		   
		   // Each players dice roll is stored in a variable each round resulting in their total score.
		   pOneTotalPoints += playerOne.getScore();
		   pTwoTotalPoints += playerTwo.getScore();

		   
			// Retrieves the value of each players dice roll and stores them in their respective variable
			pOnePointChecker = playerOne.getScore();
			pTwoPointChecker = playerTwo.getScore();
			
			// Compares the dice roll between both players. Whoever is higher wins the round
		   if (pOnePointChecker > pTwoPointChecker) {
			   System.out.println("Player 1 has won the round");
			   pOneTotalWins += 1;
		   }
		   else if (pTwoPointChecker > pOnePointChecker) {
			   System.out.println("Player 2 has won the round");
			   pTwoTotalWins += 1;
		   }
		   else {
			   System.out.println("Both players tied scores");
		   }
		   
		   // Each players total score is divided by the number of rounds played. This gives us the average score per round
		   pOneAverage = pOneTotalPoints / numRounds;
		   pTwoAverage = pTwoTotalPoints / numRounds;
	   }

	   // This is left outside of the loop so that it prints once the game is finished
	   System.out.println("-----------------------------------");
	   System.out.println("Player 1 results:");
	   System.out.println("Total rounds won: " + pOneTotalWins);
	   System.out.println("Average points per round: " + pOneAverage);
	   System.out.println("Total points: " + pOneTotalPoints);
	   
	   System.out.println();
	   
	   System.out.println("Player 2 results:");
	   System.out.println("Total rounds won: " + pTwoTotalWins);
	   System.out.println("Average points per round: " + pTwoAverage);
	   System.out.println("Total points: " + pTwoTotalPoints);
	   
	   
	}
	   
   
}