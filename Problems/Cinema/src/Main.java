import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] array = new int[rows][cols];

        // first write down the array of seats
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = sc.nextInt();
            }
        }

        int tickets = sc.nextInt();
        int perfectRow = 0;

        // now analyze the seats
        for (int i = 0; i < rows; i++) {
            // new row -> reset counter
            int emptySeatsCounter = 0;

            // for each seat in the row
            for (int j = 0; j < cols; j++) {
                boolean seatEmpty = array[i][j] == 0;
                if (seatEmpty) {
                    emptySeatsCounter++;
                    if (emptySeatsCounter == tickets) {
                        perfectRow = i + 1;
                        System.out.println(perfectRow);

                        // don't look any further (we don't want seats further from the screen)
                        return;
                    }

                } else {
                    // seat occupied -> reset counter
                    emptySeatsCounter = 0;
                }
            }
        }
        System.out.println(perfectRow);
    }
}