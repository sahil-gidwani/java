/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are given a number k.
4. Rotate the array a, k times to the right (for positive values of k), and to the left for negative values of k.
*/

import java.io.*;

public class rotate_an_array {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();
        for (int val : a) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void reverse(int[] a, int i, int j) // helper function reverse
    // takes two parameters to denote the parts, from where to where the array is to
    // be reversed at a time
    {
        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            ++i;
            --j;
        }
    }

    public static void rotate(int[] a, int k) {
        k = k % a.length;
        if (k < 0)
            k += a.length;
        // reverse part 1
        reverse(a, 0, a.length - k - 1);
        // reverse part 2
        reverse(a, a.length - k, a.length - 1);
        // reverse the whole array
        reverse(a, 0, a.length - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());
        rotate(a, k);
        display(a);
    }
}