import java.util.*;

public class falcondive {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int m = keyboard.nextInt();
        int n = keyboard.nextInt();
        char c = keyboard.next().charAt(1);

        char[][] frame1 = new char[m][n];
        char[][] frame2 = new char[m][n];

        for (int i = 0; i < m; i++) {
            frame1[i] = keyboard.next().toCharArray();
        }

        for (int i = 0; i < m; i++) {
            frame2[i] = keyboard.next().toCharArray();
        }

        int horizontalPos1 = 0;
        int verticalPos1 = 0;
        int horizontalPos2 = 0;
        int verticalPos2 = 0;
        for (int i = 0; i < n * m; i++) {
            if (frame1[i / n][i % n] == c) {
                verticalPos1 = i / n;
                horizontalPos1 = i % n;
                break;
            }
        }
        for (int i = 0; i < n * m; i++) {
            if (frame2[i / n][i % n] == c) {
                verticalPos2 = i / n;
                horizontalPos2 = i % n;
                break;
            }
        }

        int horizontalMovement = horizontalPos2 - horizontalPos1;
        int verticalMovement = verticalPos2 - verticalPos1;

        char[][] result = new char[m][n];

        int rowNumber = 0;
        int columnNumber = 0;

        for (int i = 0; i < n * m; i++) {
            if (horizontalMovement == 0 && verticalMovement == 0) {
                break;
            }

            int resultRow = rowNumber + verticalMovement;
            int resultColumn = columnNumber + horizontalMovement;

            char temp = frame2[rowNumber][columnNumber];

            if (frame2[rowNumber][columnNumber] == c) {
                result[rowNumber][columnNumber] = frame1[rowNumber][columnNumber];
                if (verticalMovement == 0) {
                    if (horizontalMovement > 0 && resultColumn < n) {
                        result[rowNumber][resultColumn] = 128;
                    } else if (horizontalMovement < 0 && resultColumn >= 0) {
                        result[rowNumber][resultColumn] = 128;
                    }
                } else {
                    if (verticalMovement > 0) {
                        if (horizontalMovement == 0 && resultRow < m) {
                            result[resultRow][resultColumn] = 128;
                        } else if (horizontalMovement > 0 && resultColumn < n && resultRow < m) {
                            result[resultRow][resultColumn] = 128;
                        } else if (horizontalMovement < 0 && resultColumn >= 0 && resultRow < m) {
                            result[resultRow][resultColumn] = 128;
                        }
                    } else {
                        if (horizontalMovement == 0 && resultRow >= 0) {
                            result[resultRow][resultColumn] = 128;
                        } else if (horizontalMovement > 0 && resultColumn < n && resultRow >= 0) {
                            result[resultRow][resultColumn] = 128;
                        } else if (horizontalMovement < 0 && resultColumn >= 0 && resultRow >= 0) {
                            result[resultRow][resultColumn] = 128;
                        }
                    }
                }
            } else {
                if (result[rowNumber][columnNumber] != 128) {
                    result[rowNumber][columnNumber] = temp;
                }
            }

            columnNumber++;
            if (columnNumber >= n) {
                rowNumber++;
                columnNumber = 0;
            }
        }

        rowNumber = 0;
        columnNumber = 0;
        for (int i = 0; i < n * m; i++) {
            if (result[rowNumber][columnNumber] == 128) {
                result[rowNumber][columnNumber] = c;
            }
            columnNumber++;
            if (columnNumber >= n) {
                rowNumber++;
                columnNumber = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            if (horizontalMovement == 0 && verticalMovement == 0) {
                System.out.println(frame2[i]);
            } else {
                System.out.println(result[i]);
            }
        }
    }
}

