package Level_2;

import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        System.out.println("=====================================");
        System.out.println("🎮 PRO TIC-TAC-TOE CHAMPIONSHIP 🎮");
        System.out.println("=====================================");

        while (playAgain) {
            initializeBoard();
            boolean gameWon = false;
            boolean gameDraw = false;
            currentPlayer = 'X';

            while (!gameWon && !gameDraw) {
                printBoard();
                playerMove(scanner);
                gameWon = checkWin();
                
                if (gameWon) {
                    printBoard();
                    System.out.println("🎉 BOOM! Player " + currentPlayer + " wins the game! 🏆");
                } else {
                    gameDraw = checkDraw();
                    if (gameDraw) {
                        printBoard();
                        System.out.println("🤝 It's a DRAW! Well played both of you.");
                    } else {
                        // Switch player
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                }
            }

            System.out.print("\n🔄 Do you want to play another round? (y/n): ");
            playAgain = scanner.nextLine().trim().equalsIgnoreCase("y");
        }
        System.out.println("Thanks for playing! 👋");
        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
        System.out.println("\nBoard:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void playerMove(Scanner scanner) {
        int row = -1, col = -1;
        boolean validMove = false;

        while (!validMove) {
            System.out.print("Player " + currentPlayer + ", enter your move (row and column: 1-3) separated by space: ");
            try {
                String[] input = scanner.nextLine().trim().split("\\s+");
                row = Integer.parseInt(input[0]) - 1;
                col = Integer.parseInt(input[1]) - 1;

                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    if (board[row][col] == '-') {
                        board[row][col] = currentPlayer;
                        validMove = true;
                    } else {
                        System.out.println("⚠️ That spot is already taken! Choose another one.");
                    }
                } else {
                    System.out.println("⚠️ Invalid input! Please enter numbers between 1 and 3.");
                }
            } catch (Exception e) {
                System.out.println("⚠️ Invalid format! Example: '1 2' for row 1, column 2.");
            }
        }
    }

    private static boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) return true;
            if (board[0][i] != '-' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) return true;
        }
        // Check diagonals
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) return true;
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) return true;
        
        return false;
    }

    private static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') return false; // Game is still going
            }
        }
        return true; // No empty spaces left
    }
}