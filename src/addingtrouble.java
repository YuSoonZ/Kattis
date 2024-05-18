import java.util.Scanner;

public class addingtrouble {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String inputs = keyboard.nextLine();

        String[] numbers =inputs.split("\\s");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        int c = Integer.parseInt(numbers[2]);

        int result = a + b;
        if (result == c) {
            System.out.println("correct!");
        } else {
            System.out.println("wrong!");
        }
    }
}
