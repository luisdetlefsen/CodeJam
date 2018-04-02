package practice.b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author luisdetlefsen
 */
public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Integer T = in.nextInt();

        for (int i = 1; i <= T; i++) {
            Integer N = in.nextInt();
            Character c = 'A';
            Map<Character, Integer> parties = new HashMap<Character, Integer>();
            for (int j = 0; j < N; j++) {
                parties.put(c, in.nextInt());
                c++;
            }
            StringBuilder r = new StringBuilder();
            //   System.out.println("Evacuating");
            while (!parties.isEmpty()) {
                List<Map.Entry<Character, Integer>> partiesOrdered = parties.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());

                int n = partiesOrdered.size();

                if (n == 1) { //if only one party left
                    if (partiesOrdered.get(n - 1).getValue() > 2) {
                        r.append(" ").append(partiesOrdered.get(n - 1).getKey()).append(partiesOrdered.get(n - 1).getKey());
                        partiesOrdered.get(n - 1).setValue(partiesOrdered.get(n - 1).getValue() - 2);
                    } else if (partiesOrdered.get(n - 1).getValue() == 2) {
                        r.append(" ").append(partiesOrdered.get(n - 1).getKey()).append(partiesOrdered.get(n - 1).getKey());
                        parties.remove(partiesOrdered.get(n - 1).getKey());
                    } else {
                        r.append(" ").append(partiesOrdered.get(n - 1).getKey());
                        parties.remove(partiesOrdered.get(n - 1).getKey());
                    }
                } else if (partiesOrdered.get(n - 1).getValue() == partiesOrdered.get(n - 2).getValue()) { //there are two parties with same number of senators
                    Map.Entry<Character, Integer> e = partiesOrdered.get(n - 1);
                    Map.Entry<Character, Integer> e2 = partiesOrdered.get(n - 2);

                    if (n == 3) {
                        if (e.getValue() == 1) {
                            r.append(" ").append(e.getKey());
                            parties.remove(e.getKey());
                            continue;
                        }                        
                    }

                    r.append(" ").append(e.getKey()).append(e2.getKey());
                    if (e.getValue() == 1) {
                        parties.remove(e.getKey());
                        parties.remove(e2.getKey());
                    } else {
                        e.setValue(e.getValue() - 1);
                        e2.setValue(e2.getValue() - 1);
                    }
                } else { //there is a party with more senators than all other parties
                    Integer t = partiesOrdered.get(n - 1).getValue();

                    if (t > 2) {
                        r.append(" ").append(partiesOrdered.get(n - 1).getKey()).append(partiesOrdered.get(n - 1).getKey());
                        partiesOrdered.get(n - 1).setValue(t - 2);
                    } else if (t == 2) {
                        r.append(" ").append(partiesOrdered.get(n - 1).getKey()).append(partiesOrdered.get(n - 1).getKey());
                        parties.remove(partiesOrdered.get(n - 1).getKey());

                    } else {
                        r.append(" ").append(partiesOrdered.get(n - 1).getKey());
                        parties.remove(partiesOrdered.get(n - 1).getKey());
                    }
                }

                //Map.Entry<Character, Integer> maxP = parties.entrySet().stream().max(Map.Entry.comparingByValue()).get();
            }

            System.out.println("Case #" + i + ":" + r.toString());
        }

    }
}
