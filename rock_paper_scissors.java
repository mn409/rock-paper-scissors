import java.util.Scanner;

public class RockPaperScissors {
    public static int getPlayerChoice(int playerNumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player " + playerNumber + ", enter your choice (1 - rock, 2 - paper, 3 - scissors):");

        int choice = scanner.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println("Invalid choice. Please enter 1 (rock), 2 (paper), or 3 (scissors):");
            choice = scanner.nextInt();
        }
        return choice;
    }

    public static int decideWinner(int playerChoice1, int playerChoice2) {
        if (playerChoice1 == playerChoice2) {
            System.out.println("It's a draw!");
            return 0;
        }
        if ((playerChoice1 == 1 && playerChoice2 == 3) || 
            (playerChoice1 == 2 && playerChoice2 == 1) || 
            (playerChoice1 == 3 && playerChoice2 == 2)) {
            System.out.println("Player 1 wins this round!");
            return 1;
        } else {
            System.out.println("Player 2 wins this round!");
            return 2;
        }
    }

    public static void playGame() {
        int player1Score = 0;
        int player2Score = 0;

        while (player1Score < 2 && player2Score < 2) {
            int p1Choice = getPlayerChoice(1);
            int p2Choice = getPlayerChoice(2);

            int roundResult = decideWinner(p1Choice, p2Choice);
            if (roundResult == 0) {
                System.out.println("No points this round.");
            }

            if (roundResult == 1) {
                player1Score++;
            } else if (roundResult == 2) {
                player2Score++;
            }

            System.out.println("Scores: Player 1 = " + player1Score + ", Player 2 = " + player2Score);
        }

        if (player1Score == 2) {
            System.out.println("Player 1 wins the game!");
        } else {
            System.out.println("Player 2 wins the game!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Rock-Paper-Scissors!");
        playGame();
        System.out.println("Thanks for playing!");
    }
}
