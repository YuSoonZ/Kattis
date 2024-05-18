import java.util.Scanner;

public class metronome {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        int n = keyboard.nextInt();

        System.out.println(n / 4.0);
    }
}