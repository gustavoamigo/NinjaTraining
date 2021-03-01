package fb;

import java.util.*;

public class ShortestDistanceAllBuildingsBFS {
    private void bfs(int[][] grid, int x, int y, Map<List<Integer>, Integer> distances,
                     Map<List<Integer>, Integer> counts) {
        Queue<List<Integer>> queue = new LinkedList<>();
        Set<List<Integer>> seen = new HashSet<>();
        queue.offer(Arrays.asList(0, x, y));
        seen.add(Arrays.asList(x,y));
        while(!queue.isEmpty()) {
            List<Integer> step = queue.poll();
            int dist = step.get(0);
            int i = step.get(1);
            int j = step.get(2);
            List<List<Integer>> neighbors = new ArrayList<>();
            neighbors.add(Arrays.asList(i + 1, j));
            neighbors.add(Arrays.asList(i - 1, j));
            neighbors.add(Arrays.asList(i, j - 1));
            neighbors.add(Arrays.asList(i, j + 1));
            for(List<Integer> neighbor: neighbors) {
                int n = neighbor.get(0);
                int m = neighbor.get(1);
                if(n>=0 && n<grid.length && m>=0 && m < grid[0].length) {
                    int t = grid[n][m];
                    if(t == 0 && !seen.contains(neighbor)) {
                        queue.offer(Arrays.asList(dist+1, n,m));
                        seen.add(Arrays.asList(n,m));
                        List<Integer> coord = Arrays.asList(n,m);
                        distances.put(coord, distances.getOrDefault(coord, 0) + dist + 1);
                        counts.put(coord, counts.getOrDefault(coord, 0) + 1);
                    }
                }
            }

        }
    }
    public int shortestDistance(int[][] grid) {
        Map<List<Integer>, Integer> distances = new HashMap<>();
        Map<List<Integer>, Integer> counts = new HashMap<>();
        int buildings = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j]==1) {
                    bfs(grid, i, j, distances, counts);
                    buildings++;
                }
        }
        int min = Integer.MAX_VALUE;
        for(List<Integer> land: distances.keySet()) {
            if(counts.get(land)==buildings) {
                min = Math.min(min, distances.get(land));
            }
        }

        HashMap<Integer, int[]> hashMap = new HashMap<>();
        hashMap.put(0, new int[]{1, 2});

        return min==Integer.MAX_VALUE?-1:min;




    }
}
