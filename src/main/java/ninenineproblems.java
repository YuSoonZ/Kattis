import java.util.Scanner;

public class ninenineproblems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numberStr = sc.next();
        // 99, 199, 299, 399 etc. +100 each time
        if (numberStr.length() == 2 || numberStr.length() == 1) {
            System.out.println(99);
        } else {
            int number = Integer.parseInt(numberStr);
            String frontPart = numberStr.substring(0, numberStr.length() - 2);
            String endNumber = frontPart.concat("99");
            int numInt = Integer.parseInt(endNumber);
            int firstInt = numInt - 100;
            int diff1 = Math.abs(number - numInt);
            int diff2 = Math.abs(number - firstInt);
            if (diff2 < diff1) {
                System.out.println(firstInt);
            } else {
                System.out.println(numInt);
            }
        }
    }
}
