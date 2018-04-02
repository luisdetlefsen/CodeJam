
package practice.a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author luisdetlefsen
 */
public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Integer T = in.nextInt();

        for (int i = 0; i < T; i++) {
            Long A = in.nextLong();
            Long B = in.nextLong();
            Integer N = in.nextInt();
            Integer n = 0;

            Long Q = (A + B + 1) / 2;
            System.out.println(Q);
            String response = in.next();
            n++;
            while (response.compareTo("CORRECT") != 0 && n < N) {
                if (response.compareTo("TOO_SMALL") == 0) {
                    A = Q;
                } else {
                    B = Q;
                }
                Q = (A + B + 1) / 2;
                System.out.println(Q);
                n++;
                response = in.next();
            }
        }

    }
}
