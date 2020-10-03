import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] array = new int[rows][cols];

        int current = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int maxValueRow = -1;
        int maxValueCol = -1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = current = sc.nextInt();

                if (current > maxValue) {
                    maxValueRow = i;
                    maxValueCol = j;

                    maxValue = current;
                }
            }
        }

        System.out.println(maxValueRow + " " + maxValueCol);

    }
}