import java.io.*;
import java.util.*;

class Student {
    private long row;
    private long col;
    private int id;
    private int faculty;

    public Student(long row, long col, int id, int faculty) {
        this.row = row;
        this.col = col;
        this.id = id;
        this.faculty = faculty;
    }

    public long getRow() {
        return row;
    }

    public long getCol() {
        return col;
    }

    public int getId() {
        return id;
    }

    public int getFaculty() {
        return faculty;
    }
}

public class universityzoning {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = reader.readLine().split(" ");
        long R = Long.parseLong(firstLine[0]);
        long C = Long.parseLong(firstLine[1]);
        int F = Integer.parseInt(firstLine[2]);
        int S = Integer.parseInt(firstLine[3]);
        int G = Integer.parseInt(firstLine[4]);

        ArrayList<String> facultyArr = new ArrayList<>();
        ArrayList<Student> studentArr = new ArrayList<>();
        // long[] minArr = new long[G];
        ArrayList<Long> minArr = new ArrayList<>();
        long[] numFacultyLocation = new long[F];
        int[] studentsInFaculty = new int[F];

        // Adding the faculty's grid location to the array
        for (int i = 0; i < F; i++) {
            String str = reader.readLine();
            String[] strArr = str.split(" ");
            numFacultyLocation[i] = Long.parseLong(strArr[0]);
            String[] temp = Arrays.copyOfRange(strArr, 1, strArr.length);
            String str2 = String.join(" ", temp);
            facultyArr.add(str2);
        }

        ArrayList<List<Long>> pairedFaculty = new ArrayList<>();
        for (String str : facultyArr) {
            String[] tempArr = str.split(" ");
            ArrayList<List<Long>> temp = new ArrayList<>();
            for (int i = 0; i < tempArr.length - 1; i += 2) {
                long first = Long.parseLong(tempArr[i]);
                long second = Long.parseLong(tempArr[i + 1]);
                temp.add(Arrays.asList(first, second));
            }
            temp.sort(Comparator.comparingLong((List<Long> pair) -> pair.get(0))
                    .thenComparingLong(pair -> pair.get(1)));
            pairedFaculty.addAll(temp);
        }

        // Adding the student's info into the arraylist
        for (int i = 0; i < S; i++) {
            String[] tokens = reader.readLine().split(" ");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int id = Integer.parseInt(tokens[2]);
            int faculty = Integer.parseInt(tokens[3]);

            studentArr.add(new Student(row, col, id, faculty));
        }
        // Sort the info into ascending order of ID, then faculty
        studentArr.sort(Comparator.comparingInt(Student::getFaculty).thenComparingInt(Student::getId));

        for (Student student : studentArr) {
            int faculty = student.getFaculty();
            int init = studentsInFaculty[faculty - 1];
            int newInit = init + 1;
            studentsInFaculty[faculty - 1] = newInit;
        }

        String[] minArrStr = reader.readLine().split(" ");
        // Adding the minimum number needed to be marked as "okay"
        for (int i = 0; i < minArrStr.length; i++) {
            minArr.add(Long.parseLong(minArrStr[i]));
        }

//        // To track the number of faculties that reached the right arrangement
        long tracker = 0;

        // The result
        long stepsTaken = 0;

        long facultyCounter = 1;
        long facultyGridDone = 0;
        long studentsDone = 0;
        ArrayList<Long> result = new ArrayList<>();
        //System.out.println(minArr);

        while (true) {
            ArrayList<Long> temp1 = new ArrayList<>();
            //System.out.println(facultyCounter);
            long min = minArr.get(Math.toIntExact(facultyCounter - 1));
            for (int i = 0; i < studentsInFaculty[Math.toIntExact(facultyCounter - 1)]; i++) {
                Student student = studentArr.get(Math.toIntExact(studentsDone));
                long r = student.getRow();
                long c = student.getCol();
                long distance = manhattanDistance(pairedFaculty, r, c, (int) (i + facultyGridDone));
                temp1.add(distance);
                studentsDone++;
            }

            Collections.sort(temp1);
            int temp2 = 0;
            long inter = 0;
            if (temp1.size() >= min) {
                for (int j = 0; j < min; j++) {
                    long d = temp1.get(temp2);
                    inter += d;
                    temp2++;
                }
            }

            result.add(inter);
            facultyGridDone = facultyGridDone + numFacultyLocation[Math.toIntExact(facultyCounter - 1)];
            facultyCounter++;
            //System.out.println(result);
            if (result.size() == minArr.size()) {
                Collections.sort(result);
                for (int k = 0; k < G; k++) {
                    stepsTaken += result.get(k);
                }
                break;
            }
        }

        System.out.println(stepsTaken);
    }

    public static long manhattanDistance(ArrayList<List<Long>> arr, long from1, long from2, int counter) {
        List<Long> temp = arr.get(counter);
        long to1 = temp.get(0);
        long to2 = temp.get(1);
        return Math.abs(from1 - to1) + Math.abs(from2 - to2);
    }

    public static void sortID(String[] arr) {
        Comparator<String> comparator = (a, b) ->
                Integer.parseInt(a.split(" ")[2]) - Integer.parseInt(b.split(" ")[2]);

        Arrays.sort(arr, comparator);
    }

    public static void sortFaculty(String[] arr) {
        Comparator<String> comparator = (a, b) ->
                Integer.parseInt(a.split(" ")[3]) - Integer.parseInt(b.split(" ")[3]);

        Arrays.sort(arr, comparator);
    }
}
