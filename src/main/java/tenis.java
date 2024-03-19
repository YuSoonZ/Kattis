import java.util.Scanner;

public class tenis {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String name1 = keyboard.next();
        String name2 = keyboard.next();

        int numberOfMatch = keyboard.nextInt();
        keyboard.nextLine();
        String[] result = new String[numberOfMatch];

        for (int i = 0; i < numberOfMatch; i++) {
            String setDetails = keyboard.nextLine();
            String[] detailsArr = setDetails.split("\\s");
            int[] resultArray = new int[detailsArr.length * 2];

            for (int j = 0; j < detailsArr.length; j++) {
                String[] colonSplit = detailsArr[j].split(":");
                resultArray[j * 2] = Integer.parseInt(colonSplit[0]);
                resultArray[j * 2 + 1] = Integer.parseInt(colonSplit[1]);
            }

            if (matchresult(resultArray) == -1) {
                result[i] = "ne";
            } else if (matchresult(resultArray) == 1) {
                if (name2.equals("federer")) {
                    result[i] = "ne";
                } else if (name1.equals("federer")) {
                    if (detailsArr.length == 2) {
                        result[i] = "da";
                    } else {
                        result[i] = "ne";
                    }
                } else {
                    result[i] = "da";
                }
            } else if (matchresult(resultArray) == 2) {
                if (name1.equals("federer")) {
                    result[i] = "ne";
                } else if (name2.equals("federer")) {
                    if (detailsArr.length == 2) {
                        result[i] = "da";
                    } else {
                        result[i] = "ne";
                    }
                } else {
                    result[i] = "da";
                }
            } else {
                result[i] = "ne";
            }
        }

        for (int k = 0; k < numberOfMatch; k++) {
            System.out.println(result[k]);
        }
    }

    private static int matchresult(int[] arr) {
        int size = arr.length;
        int numberOfSets = size / 2;
        int counter1 = 0;
        int counter2 = 0;
        int invalid = 0;
        int setCounter = 0;

        if (numberOfSets > 3) {
            invalid++;
        }

            if (setCounter < numberOfSets - 1) {
                while (setCounter < 2) {
                    int first = arr[setCounter * 2];
                    int second = arr[setCounter * 2 + 1];
                    if ((first - second) >= 2 && first == 6) {              // these 2 for 6-0, 6-1 to 6-4
                        counter1++;
                    } else if ((second - first) >= 2 && second == 6) {
                        counter2++;
                    } else if ((first - second) == 2 && first == 7) {       // these 2 for 7-5
                        counter1++;
                    } else if ((second - first) == 2 && second == 7) {
                        counter2++;
                    } else if ((first - second) == 1 && first == 7) {       // these 2 for tie-breakers
                        counter1++;
                    } else if ((second - first) == 1 && second == 7) {
                        counter2++;
                    } else {
                        invalid++;
                    }

//                    System.out.println(counter2);
                    setCounter++;
                }

                if (setCounter == 2 && numberOfSets == 3) {             // when first 2 match finish 1-1
                    if (counter1 == 2 || counter2 == 2) {
                        invalid++;
                    }
                    int first = arr[setCounter * 2];
                    int second = arr[setCounter * 2 + 1];
                    if ((first - second) >= 2 && first == 6) {          // these 2 for 6-0, 6-1 to 6-4
                        counter1++;
                    } else if ((second - first) >= 2 && second == 6) {
                        counter2++;
                    } else if (first > second) {                        // these 2 for when 1st is bigger than 2nd
                        if (second >= 4 && first - second == 2) {
                            counter1++;
                        } else {
                            invalid++;
                        }
                    } else if (second > first) {
                        if (first >= 4 && second - first == 2) {
                            counter2++;
                        } else {
                            invalid++;
                        }
                    }
                }

            }

        if (invalid != 0) {
            return -1;
        } else if (counter1 == 2) {
            return 1;
        } else if (counter2 == 2) {
            return 2;
        } else {
            return -1;
        }
    }
}

