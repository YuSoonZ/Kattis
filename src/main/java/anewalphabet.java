import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class anewalphabet {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String input = br.readLine();
        
        // Big letter + 32 == small letter ASCII component
        HashMap<Integer, String> asciiMapping = new HashMap<>(52);
        String[] newMapping = {
                "@", "8", "(", "|)", "3", "#", "6", "[-]", "|", "_|", "|<", "1", "[]\\/[]",
                "[]\\[]", "0", "|D", "(,)", "|Z", "$", "']['", "|_|", "\\/" , "\\/\\/",
                "}{", "`/", "2"
        };

        for (int i = 0; i < 26; i++) {
            asciiMapping.put(65 + i, newMapping[i]);
            asciiMapping.put(97 + i, newMapping[i]);
        }

        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (asciiMapping.containsKey((int) temp)) {
                pw.append(asciiMapping.get((int) temp));
            } else {
                pw.append(temp);
            }
        }

        pw.close();
    }
}
