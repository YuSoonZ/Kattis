import java.io.*;

public class racinggame {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int Q = Integer.parseInt(br.readLine());
        int[] top10 = new int[10];
        int size = 0;
        MergeSort ob = new MergeSort();

        for (int i = 0; i < 10; i++) {
            top10[i] = Integer.MAX_VALUE;
        }

        String[] token;
        for (int i = 0; i < Q; i++) {
            ob.sort(top10, 0, top10.length - 1);
            token = br.readLine().split(" ");
            int operation = Integer.parseInt(token[0]);
            int number = Integer.parseInt(token[1]);
            if (operation == 1) {
                if (size < 10) {
                    top10[size] = number;
                    size++;
                } else {
                    ob.sort(top10, 0, 9);
                    if (number < top10[9]) {
                        top10[9] = number;
                    }
                }
            } else if (operation == 2) {
                for (int j = 0; j < size; j++) {
                    int toPut = top10[j] + number;
                    top10[j] = toPut;
                }
            } else {
                ob.sort(top10, 0, 9);
                printWriter.println(top10[number - 1]);
            }
        }
        printWriter.close();
    }
}

// Java program for Merge Sort
// https://www.geeksforgeeks.org/merge-sort/

class MergeSort {

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // A utility function to print array of size n
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
/* This code is contributed by Rajat Mishra */