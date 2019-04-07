/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QualificationRound.foregone;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author luisdetlefsen
 */
public class Solution {

    private final Scanner scanner = new Scanner(System.in);

    public String[] breakN(BigInteger N) {
        String[] R = new String[2];

        
        char[] s = N.toString().toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '4') {
                s[i] = '3';
            }
        }

        BigInteger n1 = new BigInteger(new String(s));
        BigInteger n2 = N.subtract(n1);

        R[0] = n1.toString();
        R[1] = n2.toString();
        return R;
    }

    public void solve() {
        Integer T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            
            
            BigInteger N = new BigInteger( scanner.next());
            
            String[] R = breakN(N);
            System.out.println("Case #" + i + ": " + R[0] + " " + R[1]);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.solve();
    }
}
