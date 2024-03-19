import java.util.Scanner;
import java.lang.StringBuilder;

public class codetosavelives {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        int t = keyboard.nextInt();
        keyboard.nextLine(); // Consume the newline after reading the integer

        StringBuilder output = new StringBuilder();

        while (t > 0) {
            String firstLine = keyboard.nextLine();
            String secondLine = keyboard.nextLine();

            String[] firstDigits = firstLine.split("\\s+");
            String[] secondDigits = secondLine.split("\\s+");

            long[] firstNumbers = new long[firstDigits.length];
            long[] secondNumbers = new long[secondDigits.length];


            for (int i = 0; i < firstDigits.length; i++) {
                firstNumbers[i] = Long.parseLong(firstDigits[i]);
            }

            for (int i = 0; i < secondDigits.length; i++) {
                secondNumbers[i] = Long.parseLong(secondDigits[i]);
            }

            int lengthDiff = firstDigits.length - secondDigits.length;
            if (lengthDiff == 0) {
                long answer = 0;
                for (int i = 0; i < firstNumbers.length; i++) {
                    answer = answer * 10 + (firstNumbers[i] + secondNumbers[i]);
                }

                String ansString = Long.toString(answer);
                StringBuilder sb = new StringBuilder(ansString);
                int len = ansString.length();
                for (int i = 0; i < 2 * len; i++) {
                    if (i % 2 != 0) {
                        sb.insert(i, ' ');
                    }
                }

                output.append(sb.toString()).append("\n");
                t--;
            } else if (lengthDiff > 0) {
                long answer = 0;

                for (int i = 0; i < lengthDiff; i++) {
                    answer = answer * 10 + firstNumbers[i];
                }

                for (int i = lengthDiff; i < firstNumbers.length; i++) {
                    answer = answer * 10 + (firstNumbers[i] + secondNumbers[i - lengthDiff]);
                }

                String ansString = Long.toString(answer);
                StringBuilder sb = new StringBuilder(ansString);
                int len = ansString.length();
                for (int i = 0; i < 2 * len; i++) {
                    if (i % 2 != 0) {
                        sb.insert(i, ' ');
                    }
                }

                output.append(sb.toString()).append("\n");
                t--;
            } else {
                long answer = 0;
                int modLengthDiff = Math.abs(lengthDiff);

                for (int i = 0; i < modLengthDiff; i++) {
                    answer = answer * 10 + secondNumbers[i];
                }

                for (int i = modLengthDiff; i < secondNumbers.length; i++) {
                    answer = answer * 10 + (firstNumbers[i - modLengthDiff] + secondNumbers[i]);
                }

                String ansString = Long.toString(answer);
                StringBuilder sb = new StringBuilder(ansString);
                int len = ansString.length();
                for (int i = 0; i < 2 * len; i++) {
                    if (i % 2 != 0) {
                        sb.insert(i, ' ');
                    }
                }

                output.append(sb.toString()).append("\n");
                t--;
            }
        }

        System.out.print(output);
        keyboard.close();
    }
}

