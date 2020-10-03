import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int position = a;
        int day = 1;

        while (position < h)
        {
            // apply night operations, start next day
            position -= b;
            day++;
            position += a;
        }

        System.out.println(day);

    }
}