import java.util.Scanner;

public class areal {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        long area = sc.nextLong();
        double len = Math.sqrt(area);
        double perimeter = len * 4;
        System.out.println(perimeter);
    }
}
