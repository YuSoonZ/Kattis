def import java.util.Scanner;

public class fimmtudagstilbod {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        final int PRICE = 1000;
        final int YEAR = 2020;
        final int INCREASE = 100;
        if (y < 2021) {
            System.out.println(PRICE);
        } else {
            int diff = y - YEAR;
            int increase = diff * INCREASE;
            System.out.println(PRICE + increase);
        }
    }
}
() -> None:
    y = int(input())

    start_price = 1000
    start_year = 2020
    increase = 100

    if y < 2021:
        print(start_price)
    else:
        price_increase = (y - start_year) * increase
        print(price_increase + start_price)

fimmtudagstilbod()