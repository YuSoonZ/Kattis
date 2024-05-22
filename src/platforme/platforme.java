import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class platforme {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Platform> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            int height = Integer.parseInt(temp[0]);
            int x1 = Integer.parseInt(temp[1]);
            int x2 = Integer.parseInt(temp[2]);
            arrayList.add(new Platform(height, x1, x2));
        }

        Collections.sort(arrayList, new Comparator<Platform>() {
            @Override
            public int compare(Platform o1, Platform o2) {
                return o1.height - o2.height;
            }
        });

        int result = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            Platform temp = arrayList.get(i);
            int height = temp.height;
            int x1 = temp.x1;
            int x2 = temp.x2;
            if (i == 0) {
                result += (height * 2);
            }

            if (i != 0) {
                int leftLeg = height;
                int rightLeg = height;
                // Check to see if got anything below LEFT side
                for (int j = i - 1; j >= 0; j--) {
                    Platform leftCheck = arrayList.get(j);
                    int heightJ = leftCheck.height;
                    int x1J = leftCheck.x1;
                    int x2J = leftCheck.x2;

                    if (x1 + 0.5 >= x1J && x1 + 0.5 <= x2J) {
                        leftLeg -= heightJ;
                        break;
                    }
                }

                for (int k = i - 1; k >= 0; k--) {
                    Platform rightCheck = arrayList.get(k);
                    int heightK = rightCheck.height;
                    int x1K = rightCheck.x1;
                    int x2K = rightCheck.x2;

                    if (x2 - 0.5 >= x1K && x2 - 0.5 <= x2K) {
                        rightLeg -= heightK;
                        break;
                    }
                }
                result += (leftLeg + rightLeg);
            }
        }
        System.out.println(result);
    }
}

class Platform {
    int height;
    int x1;
    int x2;

    public Platform(int height, int x1, int x2) {
        this.height = height;
        this.x1 = x1;
        this.x2 = x2;
    }
}
