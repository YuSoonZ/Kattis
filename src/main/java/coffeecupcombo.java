import java.util.Scanner;

  public class coffeecupcombo {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int numberOfLectures = keyboard.nextInt();
        String sequence = keyboard.next();
        int len = sequence.length();

        String[] sequenceArr = new String[len];
        for (int i = 0; i < len; i++) {
            sequenceArr[i] = String.valueOf(sequence.charAt(i));
        }

        String machine = "1";
        int coffeeOnHand = 0;
        int result = 0;
        int i = 0;

        while (numberOfLectures > 0) {
            if (sequenceArr[i].equals(machine)) {
                result++;
                if (coffeeOnHand != 2) {
                    coffeeOnHand = 2;
                }
                i++;
                numberOfLectures--;
            } else {
                if (coffeeOnHand != 0) {
                    result++;
                    coffeeOnHand--;
                }
                i++;
                numberOfLectures--;
            }
        }

        System.out.println(result);

    }
}

