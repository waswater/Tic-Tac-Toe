import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxInput = -1;
        int input = -1;

        do {
            input = sc.nextInt();
            if (maxInput < input) {
                maxInput = input;
            }
        } while (input != 0);

        System.out.print(maxInput);
    }
}