//put imports you need here

import java.util.Scanner;

class Main {
/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstName = sc.nextLine();
        String age = sc.nextLine();
        String education = sc.nextLine();
        String experience = sc.nextLine();
        String cuisinePreference = sc.nextLine();

        System.out.println("The form for " + firstName +
                " is completed. We will contact you if we need a chef that cooks " + cuisinePreference + " dishes.");
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] answers = new String[5];

        for (int i = 0 ; i < 5; i++)
        {
            answers[i] = sc.next();
        }

        System.out.printf("The form for %s is completed." +
                " We will contact you if we need a chef that cooks %s dishes.", answers[0], answers[4]);
    }


}