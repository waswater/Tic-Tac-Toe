//put imports you need here

import java.util.Scanner;

class Main {
    private static int NO_OF_ROOMS = 4;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // read lines with names (each line, 1 room)
        String[] namesForRooms = new String[NO_OF_ROOMS];
        for (int i = 0; i < NO_OF_ROOMS; i++)
        {
            namesForRooms[i] = sc.nextLine();
        }

        // print all names in order from the last registered
        for (int i = NO_OF_ROOMS; i > 0; i--)
        {
            String[] names = namesForRooms[i-1].split(" ");
            for (int j = names.length; j > 0; j--)
            {
                System.out.println(names[j-1]);
            }
        }
    }
}