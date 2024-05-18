import java.util.Scanner;

public class laptopstickers {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int L = keyboard.nextInt();
        int H = keyboard.nextInt();
        int K = keyboard.nextInt();

        char[][] arr1 = new char[H][L];
        char con = '_';
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < L; j++) {
                arr1[i][j] = con;
            }
        }

        String[] arr2 = new String[K];

        keyboard.nextLine();

        for (int i = 0; i < K; i++) {
            arr2[i] = keyboard.nextLine();
        }

        int counter = 0;
        char sticker = 'a';
        while (counter < K) {
            String temp = arr2[counter];
            String[] token = temp.split("\\s");
            int l = Integer.parseInt(token[0]);
            int h = Integer.parseInt(token[1]);
            int a = Integer.parseInt(token[2]);
            int b = Integer.parseInt(token[3]);
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < l; j++) {
                    if (a + j < L && b + i < H) {
                        arr1[b + i][a + j] = sticker;
                    }
                }
            }
            counter++;
            sticker++;
        }

        for (int i = 0; i < H; i++) {
            System.out.println(arr1[i]);
        }
    }
}

