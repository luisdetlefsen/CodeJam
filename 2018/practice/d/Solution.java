package practice.d;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author luisdetlefsen
 */
public class Solution {


    static class Stall {

        public int index;
        public int ls = 0;
        public int lr = 0;
        public int min_ls_lr = 0;
        public int max_ls_lr = 0;
    }

    //brute force
    private static void findLastPosition(int n, int K, int caseNumber) {

        if (n == K) {
            System.out.println("Case #" + caseNumber + ": 0 0");
            return;
        }

        boolean[] stalls = new boolean[n];
        Arrays.fill(stalls, true);  //true: stall is free. false: stall is occupied

        for (long k = 0; k < K; k++) {
            List<Stall> freeStalls = new ArrayList<>();
            for (int i = 0; i < n; i++) { //evaluate all free stalls
                if (stalls[i]) {
                    Stall stall = new Stall();
                    stall.index = i;

                    int lscm = 0;
                    for (int lsc = i; lsc > 0; lsc--, lscm++) {
                        if (!stalls[lsc - 1]) {
                            break;
                        }
                    }
                    stall.ls = lscm;

                    int lrcm = 0;
                    for (int lrc = i; lrc < stalls.length - 1; lrc++, lrcm++) {
                        if (!stalls[lrc + 1]) {
                            break;
                        }
                    }
                    stall.lr = lrcm;
                    stall.min_ls_lr = stall.ls < stall.lr ? stall.ls : stall.lr;
                    stall.max_ls_lr = stall.ls > stall.lr ? stall.ls : stall.lr;
                    freeStalls.add(stall);
                }
            }

            //get min free stalls
            int maxMinLsLr = freeStalls.stream().mapToInt(x -> x.min_ls_lr).reduce(0, Integer::max);

            long maxMinLsLrCount = freeStalls.stream().filter(x -> x.min_ls_lr == maxMinLsLr).count();
            Stall rr;
            if (maxMinLsLrCount == 1) {
                Optional<Stall> r = freeStalls.stream().filter(x -> x.min_ls_lr == maxMinLsLr).findFirst();
                rr = r.get();
            } else {
                int maxMaxLsLr = freeStalls.stream().filter(x -> x.min_ls_lr == maxMinLsLr).mapToInt(x -> x.max_ls_lr).reduce(0, Integer::max);

                Optional<Stall> r = freeStalls.stream().filter(x -> x.min_ls_lr == maxMinLsLr && x.max_ls_lr == maxMaxLsLr).findFirst();
                rr = r.get();
            }
            stalls[rr.index] = false;

            if (k == K - 1) {
                Integer y = Integer.max(rr.ls, rr.lr);
                Integer z = Integer.min(rr.ls, rr.lr);
                System.out.println("Case #" + caseNumber + ": " + y + " " + z);
            }
        }
    }



    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Integer T = in.nextInt();

        for (int i = 1; i <= T; i++) {
            Integer N = in.nextInt();
            Integer K = in.nextInt();
            findLastPosition(N,K, i);
        }

    }

}
