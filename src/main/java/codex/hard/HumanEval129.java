package codex.hard;

import java.util.*;
import java.lang.*;

public class HumanEval129 {
    public List<Integer> minPath(List<List<Integer>> grid, int k) {
        int n = grid.size();
        int oneRow = -1;
        int oneCol = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == 1) {
                    oneRow = i;
                    oneCol = j;
                    break;
                }
            }
            if (oneRow != -1) {
                break;
            }
        }

        int bestNeighbor = Integer.MAX_VALUE;
        if (oneRow > 0) {
            bestNeighbor = Math.min(bestNeighbor, grid.get(oneRow - 1).get(oneCol));
        }
        if (oneRow + 1 < n) {
            bestNeighbor = Math.min(bestNeighbor, grid.get(oneRow + 1).get(oneCol));
        }
        if (oneCol > 0) {
            bestNeighbor = Math.min(bestNeighbor, grid.get(oneRow).get(oneCol - 1));
        }
        if (oneCol + 1 < n) {
            bestNeighbor = Math.min(bestNeighbor, grid.get(oneRow).get(oneCol + 1));
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (i % 2 == 0) {
                ans.add(1);
            } else {
                ans.add(bestNeighbor);
            }
        }
        return ans;
    }
}