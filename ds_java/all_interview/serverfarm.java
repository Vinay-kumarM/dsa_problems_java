package all_interview;

import java.util.*;

public class serverfarm {
    public static int minimumPower(List<Integer> power, List<String> conflicts) {
        int n = power.size();
        int min = Integer.MAX_VALUE;
        boolean[][] conflictmatrix = new boolean[n][n];
        for (String s : conflicts) {
            String[] parts = s.split(" ");
            int server1 = Integer.parseInt(parts[0]);
            int server2 = Integer.parseInt(parts[1]);
            conflictmatrix[server1][server2] = true;
            conflictmatrix[server2][server1] = true;
        }
        for (int i = 0; i < power.size(); i++) {
            for (int j = i + 1; j < power.size(); j++) {
                if (conflictmatrix[i][j]) {
                    continue;
                }
                min = Math.min(min, power.get(i) + power.get(j));
            }
        }
        return min;

    }

    public static void main(String[] args) {
        List<Integer> power = Arrays.asList(5, 8, 2);
        List<String> conflicts = Arrays.asList("0 1", "1 2");
        System.out.println(minimumPower(power, conflicts));

    }
}
