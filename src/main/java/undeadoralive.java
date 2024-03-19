import java.util.Scanner;

public class undeadoralive {
    public static void main (String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();

        if (input.contains(":(") && input.contains(":)")) {
            System.out.println("double agent");
        } else if (input.contains(":(")) {
            System.out.println("undead");
        } else if (input.contains(":)")) {
            System.out.println("alive");
        } else {
            System.out.println("machine");
        }

    }
}