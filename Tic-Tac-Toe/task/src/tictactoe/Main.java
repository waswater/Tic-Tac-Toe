package tictactoe;

import java.util.Scanner;

public class Main {
    public static char MARK_X = 'X';
    public static char MARK_O = 'O';
    public static char MARK_EMPTY = '_';

    public static void main(String[] args) {

        // initialize main variables
        boolean gameEnded = false;
        boolean isXMovingNow = true;

        Scanner sc = new Scanner(System.in);

        // create empty field
        char[] symbols = new char[9];

        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = MARK_EMPTY;
        }

        // print current T-T-T field
        printField(symbols);

        // loop while game is not ended
        while(!gameEnded) {

            // get and validate input
            boolean validInput = false;
            int newMarkPosition = -1;

            while (!validInput) {
                System.out.print("Enter the coordinates: ");
                // get coordinates for row and col
                if (!sc.hasNextInt()) {
                    System.out.print("You should enter numbers!");
                    continue;
                }
                int row = sc.nextInt();
                if (!sc.hasNextInt()) {
                    System.out.print("You should enter numbers!");
                    continue;
                }
                int col = sc.nextInt();

                if ( ((row < 1) || (row > 3)) || ((col < 1) || (col > 3)) ) {
                    System.out.print("Coordinates should be from 1 to 3!");
                } else {

                    // transform
                    int rowFixed = row-1;
                    int colFixed = Math.abs(col-3);

                    newMarkPosition = rowFixed + 3 * colFixed;

                    // check if move is valid (space in empty)
                    if (symbols[newMarkPosition] != MARK_EMPTY)
                    {
                        System.out.print("This cell is occupied! Choose another one!");
                        continue;
                    } else {
                        validInput = true;
                    }
                }
            }

            // add new mark to the field and change player
            if (isXMovingNow) {
                symbols[newMarkPosition] = MARK_X;
                isXMovingNow = false;
            } else {
                // enter new "O" move on the board
                symbols[newMarkPosition] = MARK_O;
                isXMovingNow = true;
            }

            // print new board (after move was made)
            printField(symbols);

            // analyze T-T-T field - check what is the game state according to rules
            gameEnded = checkIfGameEnded(symbols);
        }
    }

    // analyze T-T-T field - check what is the game state according to rules
    private static boolean checkIfGameEnded(char[] symbols)
    {
        boolean gameEnded = false;

        int xCount = 0;
        int oCount = 0;
        int countTotal = 0;

        int xesInARow, osInARow;

        boolean xWins = false;
        boolean oWins = false;
        boolean impossible = false;

        boolean emptySpaceLeft = false;

        // analyze one by one (row after row)
        for (int row = 0; row < 3; row++) {

            // reset flags for each row
            xesInARow = 0;
            osInARow = 0;

            for (int col = 0; col < 3; col++) {

                // get current symbol
                char current = symbols[row * 3 + col];

                if (current == MARK_X) {
                    xCount++;
                    xesInARow++;

                    // if last column - check for a horizontal win
                    if (col == 2 && xesInARow == 3) {
                        if (xWins || oWins) {
                            impossible = true;
                        } else {
                            xWins = true;
                        }
                    }

                    // if in last row - check for vertical win
                    if (row == 2) { // last row
                        // get elements from higher rows
                        char firstRowEl = symbols[0 * 3 + col];
                        char secondRowEl = symbols[1 * 3 + col];

                        if (firstRowEl == MARK_X && secondRowEl == MARK_X) {
                            if (xWins || oWins) {
                                impossible = true;
                            } else {
                                xWins = true;
                            }
                        }
                    }

                } else if (current == MARK_O) {
                    oCount++;
                    osInARow++;

                    // check for a win
                    if (col == 2 && osInARow == 3) {
                        if (xWins || oWins) {
                            impossible = true;
                        } else {
                            oWins = true;
                        }
                    }

                    // check for vertical win
                    if (row == 2) { // last row
                        // get elements from higher rows
                        char firstRowEl = symbols[0 * 3 + col];
                        char secondRowEl = symbols[1 * 3 + col];

                        if (firstRowEl == MARK_O && secondRowEl == MARK_O) {
                            if (xWins || oWins) {
                                impossible = true;
                            } else {
                                oWins = true;
                            }
                        }
                    }

                } else { // current is empty space
                    // mark there is a space left (so move is possible)
                    if (!emptySpaceLeft) {
                        emptySpaceLeft = true;
                    }
                }

            }
        }

        // check for diagonal win
        char first = symbols[0];
        char middle = symbols[4];
        char last = symbols[8];
        char third = symbols[2];
        char seventh = symbols[6];

        if ((first == middle) && (middle == last)) {
            if (middle == MARK_X) {
                xWins = true;
            } else if (middle == MARK_O) {
                oWins = true;
            }
        }
        else if ((third == middle) && (middle == seventh)) {
            if (middle == MARK_X) {
                xWins = true;
            } else if (middle == MARK_O) {
                oWins = true;
            }
        }


        // check state based on the field analysis:

        String gameStateMsg = "Aaaaa! State not assigned!";

        // check if there is a big difference in no of Xes and Os
        if (Math.abs(xCount - oCount) >= 2) {
            //gameStateMsg = "Impossible!!!" + xCount + " : " + oCount + " -> " + xWins + "," + oWins;
            impossible = true;
        }

        // "Impossible"
        if (impossible) {
            //gameStateMsg = "Impossible" + xCount + " : " + oCount + " -> " + xWins + "," + oWins;
            gameStateMsg = "Impossible";
            gameEnded = true;
        }
        else {
            // "X wind"
            if (xWins) {
                gameStateMsg = "X wins";
                gameEnded = true;
            } else if (oWins) { // "O wins"
                gameStateMsg = "O wins";
                gameEnded = true;
            }
            else if (emptySpaceLeft) { // "Game not finished"
                gameStateMsg = "Game not finished";
            }
            else { // "Draw"
                gameStateMsg = "Draw";
                gameEnded = true;
            }
        }

        System.out.println(gameStateMsg);

        return gameEnded;
    }


    private static void printField(char[] symbols)
    {
        System.out.println("---------");

        System.out.print("|");
        System.out.print(" ");
        System.out.print(symbols[0]);
        System.out.print(" ");
        System.out.print(symbols[1]);
        System.out.print(" ");
        System.out.print(symbols[2]);
        System.out.print(" ");
        System.out.println("|");

        System.out.print("|");
        System.out.print(" ");
        System.out.print(symbols[3]);
        System.out.print(" ");
        System.out.print(symbols[4]);
        System.out.print(" ");
        System.out.print(symbols[5]);
        System.out.print(" ");
        System.out.println("|");

        System.out.print("|");
        System.out.print(" ");
        System.out.print(symbols[6]);
        System.out.print(" ");
        System.out.print(symbols[7]);
        System.out.print(" ");
        System.out.print(symbols[8]);
        System.out.print(" ");
        System.out.println("|");

        System.out.println("---------");

    }

}
