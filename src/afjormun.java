import java.util.Scanner;

public class afjormun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numLines = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numLines; i++) {
            String input = sc.nextLine();
            input = input.toLowerCase();
            int first = (int)input.charAt(0) - 32;
            char replace = (char) first;
            String result = replace + input.substring(1);
            System.out.println(result);
        }
    }
}
