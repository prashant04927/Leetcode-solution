import java.util.*;

class Solution {
    private int[] quiet;
    private List<Integer>[] graph;
    private int[] ans;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;

        this.quiet = quiet;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Edge: poor -> rich
        for (int[] edge : richer) {
            graph[edge[1]].add(edge[0]);
        }

        ans = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i++) {
            dfs(i);
        }

        return ans;
    }

    private int dfs(int person) {
        if (ans[person] != -1) {
            return ans[person];
        }

        ans[person] = person;

        for (int richerPerson : graph[person]) {
            int candidate = dfs(richerPerson);

            if (quiet[candidate] < quiet[ans[person]]) {
                ans[person] = candidate;
            }
        }

        return ans[person];
    }
}
