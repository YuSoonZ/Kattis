import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class alphabetspam {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        HashMap<String, Integer> hashMap = new HashMap<>(4);
        hashMap.put("whitespace", 0);
        hashMap.put("lowercase", 0);
        hashMap.put("uppercase", 0);
        hashMap.put("symbols", 0);
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (isWhitespace(c)) {
                int count = hashMap.get("whitespace");
                hashMap.put("whitespace", count + 1);
            } else if (isLowerCase(c)) {
                int count = hashMap.get("lowercase");
                hashMap.put("lowercase", count + 1);
            } else if (isUppercase(c)) {
                int count = hashMap.get("uppercase");
                hashMap.put("uppercase", count + 1);
            } else {
                int count = hashMap.get("symbols");
                hashMap.put("symbols", count + 1);
            }
        }
        System.out.println(ratio(hashMap.get("whitespace"), input.length()));
        System.out.println(ratio(hashMap.get("lowercase"), input.length()));
        System.out.println(ratio(hashMap.get("uppercase"), input.length()));
        System.out.println(ratio(hashMap.get("symbols"), input.length()));
    }

    public static boolean isWhitespace(char c) {
        return (int) c == 95;
    }
    public static boolean isLowerCase(char c) {
        return (int) c >= 97 && (int) c <= 122;
    }
    public static boolean isUppercase(char c) {
        return (int) c >= 65 && (int) c <= 90;
    }
    public static double ratio(int count, int sum) {
        return (double) count / sum;
    }
}
