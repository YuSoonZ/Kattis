import java.util.Scanner;

public class babypanda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        scanner.close();

        long sneezes = countSneezes(n, m);
        System.out.println(sneezes);
    }

    private static long countSneezes(long n, long m) {
        long sneezes = 0;

        while (m > 0) {
            if ((m & 1) == 1) {
                sneezes++;
            }
            m >>= 1;
        }

        return sneezes;
    }
}
