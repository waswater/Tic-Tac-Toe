import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int limit = sc.nextInt();

        int square = -1;
        int base = 1;

        boolean fitsInLimit = true;

        while (fitsInLimit) {
            square = base * base;
            if (square <= limit) {
                System.out.println(square);
                base++;
            } else {
                fitsInLimit = false;
            }
        }
    }
}
