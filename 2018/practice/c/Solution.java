
package practice.c;

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

        for (int i = 1; i <= T; i++) {

            Double D = in.nextDouble();
            Integer N = in.nextInt();
            Double Ts = Double.MIN_VALUE; //time to reach D for the slowest horse
            for (int j = 0; j < N; j++) {
                Double K = in.nextDouble();
                Integer S = in.nextInt();

                Ts = Math.max(Ts, (D-K)/S);

            }
            Double Sa = D/Ts; //Annie's speed            
            System.out.println("Case #" + i + ": " + String.format("%.6f", Sa));
        }

    }
}
