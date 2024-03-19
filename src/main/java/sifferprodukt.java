import java.util.Scanner;

public class sifferprodukt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        int result = computeFinalDigit(x);
        System.out.println(result);
    }

    public static int computeFinalDigit(int num) {
        while (num >= 10) {
            int product = 1;
            while (num > 0) {
                int digit = num % 10;
                if (digit != 0) {
                    product *= digit;
                }
                num /= 10;
            }
            num = product;
        }
        return num;
    }
}

