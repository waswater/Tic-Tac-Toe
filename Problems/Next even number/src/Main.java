import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int nextEvenNumber = number + 2;

        if (number % 2 != 0) {
            nextEvenNumber = number + 1;
        }

        System.out.println(nextEvenNumber);
    }
}