import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class rankproblem {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int numberOfTeams = keyboard.nextInt();
        int gamesPlayed = keyboard.nextInt();
        keyboard.nextLine();

        ArrayList<Integer> order = new ArrayList<>();
        for (int i = 1; i <= numberOfTeams; i++) {
            order.add(i);
        }

        for (int i = 0; i < gamesPlayed; i++) {
            String line = keyboard.nextLine();
            String[] token = line.split(" ");
            int a = Integer.parseInt(token[0].substring(1));
            int b = Integer.parseInt(token[1].substring(1));

            int place1 = order.indexOf(a);
            int place2 = order.indexOf(b);

            if (place1 > place2) {
                order.remove(place2);
                order.add(place1, b);
            }
        }

        for (int i = 0; i < numberOfTeams; i++) {
            System.out.print("T" + order.get(i) + " ");
        }
    }
}

