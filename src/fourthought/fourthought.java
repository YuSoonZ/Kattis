import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class fourthought {
    public static void main(String[] args) {
        final char[] OPERANDS = new char[]{'*', '-', '+', '/'};
        final int NUMBER = 4;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < NUMBER; i++) {
            for (int j = 0; j < NUMBER; j++) {
                for (int k = 0; k < NUMBER; k++) {
                    String expression = NUMBER + " " + OPERANDS[i] + " " + NUMBER + " "
                            + OPERANDS[j] + " " + NUMBER + " " + OPERANDS[k] + " " + NUMBER;
                    int result = getResult(expression);
                    expression = expression + " = " + result;
                    if (!map.containsKey(result)) {
                        map.put(result, expression);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(map.getOrDefault(sc.nextInt(), "no solution"));
        }
    }
    
    public static int getResult(String expression) {
        String[] arr = expression.split(" ");

        // First pass: handle * and /
        LinkedList<Integer> values = new LinkedList<>();
        LinkedList<Character> operators = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                values.add(Integer.parseInt(arr[i]));
            } else {
                char operator = arr[i].charAt(0);
                if (operator == '*' || operator == '/') {
                    int left = values.removeLast();
                    int right = Integer.parseInt(arr[++i]);
                    if (operator == '*') {
                        values.add(left * right);
                    } else {
                        values.add(left / right);
                    }
                } else {
                    operators.add(operator);
                    values.add(Integer.parseInt(arr[++i]));
                }
            }
        }

        // Second pass: handle + and -
        int result = values.removeFirst();
        while (!operators.isEmpty()) {
            char operator = operators.removeFirst();
            int operand = values.removeFirst();
            if (operator == '+') {
                result += operand;
            } else {
                result -= operand;
            }
        }

        return result;
    }
}
