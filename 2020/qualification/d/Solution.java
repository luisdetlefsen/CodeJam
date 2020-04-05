package codejam.qualification.d;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt(); //n
            int K = in.nextInt();//k

            if (K % N == 0) {
                System.out.println("Case #" + i + ": POSSIBLE");
                int r = K / N;
                int[][] arr = new int[N][N];

                for (int j = 0; j < N; j++) {
                    int s = r;
                    for (int k = 0; k < N; k++) {
                        arr[j][k] = s;
                        s++;
                        if (s > N) {
                            s = 1;
                        }
                    }
                    r--;
                    if (r == 0) {
                        r = N;
                    }
                }

                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        System.out.print(arr[j][k] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }


        }
    }
}
