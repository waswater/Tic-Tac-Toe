import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char numbers[] = scanner.next().toCharArray();

        boolean firstZero = false;

        if (numbers[2] != '0')
        {
            System.out.print(numbers[2]);
        } else {
            firstZero = true;
        }
        if (numbers[1] != '0' || firstZero == false)
        {
            System.out.print(numbers[1]);
        }
        System.out.print(numbers[0]);
    }
}