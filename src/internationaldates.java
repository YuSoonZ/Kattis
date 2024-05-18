import java.util.Scanner;

public class internationaldates {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();

        String[] numbers = input.split("/");
        int a1 = Integer.parseInt(numbers[0]);

        int b1 = Integer.parseInt(numbers[1]);

        if (a1 > 12) {
            System.out.println("EU");
        } else if (b1 > 12) {
            System.out.println("US");
        } else {
            System.out.println("either");
        }
    }
}
