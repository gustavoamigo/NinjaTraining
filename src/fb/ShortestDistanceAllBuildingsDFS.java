package fb;

import java.util.*;

public class ShortestDistanceAllBuildingsDFS {
    private Map<List<Integer>, Map<List<Integer>, Integer>> memo = new HashMap<>();

    private void dfs(int[][] grid, int i, int j, int x, int y, int steps, HashMap<List<Integer>, Integer> seen, Map<List<Integer>, Integer> distances) {
        List<Integer> coord = Arrays.asList(x,y);
        if(x<0 || y<0 || x>=grid.length || y>=grid[0].length) return;
        if(grid[x][y] == 2) return;
        if(grid[x][y] == 1) {
            if(distances.containsKey(coord)) {
                distances.put(coord, Math.min(distances.get(coord), steps));
            } else {
                distances.put(coord, steps);
            }
            memo.put(Arrays.asList(i,j), distances);
            return;
        }

        if(memo.containsKey(coord)) {
            Map<List<Integer>, Integer> alreadyComputedDistance = memo.get(coord);
            for(List<Integer> building: alreadyComputedDistance.keySet()) {
                distances.put(building, Math.min(distances.getOrDefault(building, Integer.MAX_VALUE), alreadyComputedDistance.get(building) + steps));
            }
            return;
        }

        if(seen.containsKey(coord) && seen.get(coord) <= steps) return;
        seen.put(coord, steps);



        dfs(grid, i, j, x + 1, y, steps + 1, seen, distances);
        dfs(grid, i, j, x, y + 1, steps + 1, seen, distances);
        dfs(grid, i, j, x - 1, y, steps + 1, seen, distances);
        dfs(grid, i, j, x, y - 1, steps + 1, seen, distances);
    }


    public int shortestDistance(int[][] grid) {
        List<List<Integer>> lands = new ArrayList<>();
        memo = new HashMap<>();
        int buildings = 0 ;
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    List<Integer> coord = Arrays.asList(i,j);
                    lands.add(coord);
                }
                if(grid[i][j] == 1) {
                    buildings++;
                }

            }
        }
        int min = Integer.MAX_VALUE;

        for(List<Integer> land: lands) {
            Map<List<Integer>, Integer> distances = new HashMap<>();
            dfs(grid, land.get(0), land.get(1), land.get(0), land.get(1), 0, new HashMap<>(), distances);
            int count = 0;
            int sum = 0;
            for(List<Integer> coord: distances.keySet() ) {
                sum+=distances.get(coord);
                count++;
            }
            if(count != buildings) continue;
            min = Math.min(sum, min);
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
