import java.util.Arrays;
import java.util.Scanner;

public class abc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] integers = sc.nextLine().split(" ");
        String sequence = sc.nextLine();
        int[] intArr = new int[3];
        for (int i = 0; i <= 2; i++) {
            intArr[i] = Integer.parseInt(integers[i]);
        }
        Arrays.sort(intArr);
        String result = "";
        for (int i = 0; i <= 2; i++) {
            char temp = sequence.charAt(i);
            if (temp == 'A') {
                 result += intArr[0];
            } else if (temp == 'B') {
                result += intArr[1];
            } else {
                result += intArr[2];
            }
            result += " ";
        }
        System.out.println(result);
    }
}
