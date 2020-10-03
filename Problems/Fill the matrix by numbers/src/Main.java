import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[][] array = new int[size][size];

        // for each column
        for (int i = 0; i < size; i++) {
            // for each row
            for (int j = 0; j < size; j++) {

                // fill with value equal to distance beween i and j
                array[i][j] = Math.abs(i - j);
            }
        }

        // display contents
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }
}