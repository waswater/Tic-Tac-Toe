import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long input = sc.nextLong();

        long base = 0;
        long factorial = -1;

        do {
            base++;
            factorial = 1;

            for (long i = 1; i <= base; i++) {
                factorial *= i;
            }

        } while (factorial <= input);

        System.out.println(base);

    }
}