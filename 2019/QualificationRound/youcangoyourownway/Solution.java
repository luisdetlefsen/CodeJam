package QualificationRound.youcangoyourownway;

import java.util.Scanner;

/**
 *
 * @author luisdetlefsen
 */
public class Solution {

    private final Scanner scanner = new Scanner(System.in);

    public String anotherPath(String s) {
        char[] C = s.toCharArray();
        for (int i = 0; i < C.length; i++) {
            if(C[i] == 'S'){
                C[i] = 'E';
            } else{
                C[i] = 'S';
            }
        }
        return new String(C);
    }

    public void solve() {
        Integer T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {

            Integer N = scanner.nextInt(); //grid size

            String s = scanner.next();

            String R = anotherPath(s);

            System.out.println("Case #" + i + ": " + R);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solve();
    }
}
