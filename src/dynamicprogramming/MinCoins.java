package dynamicprogramming;

import java.util.*;

public class MinCoins {

    static HashMap<Integer, Integer> memo = new HashMap<>();

    public static int coinChange(int[] coins, int amount) {
        if (memo.containsKey(amount)) return memo.get(amount);
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int minCount = -1;
        for (int coin : coins) {
            int count = coinChange(coins, amount - coin) + 1;
            if (count > 0) {
                minCount = minCount == -1 ? count : Math.min(minCount, count);
            }
        }
        memo.put(amount, minCount);
        return minCount;
    }

    public static long iterative(int[] coins, int amount) {
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(Arrays.asList(amount, 0));
        int min = Integer.MAX_VALUE;
        while(stack.size() != 0) {
            List<Integer> node = stack.pop();
            int newAmount = node.get(0);
            int count = node.get(1);
            if(newAmount == 0) {
                min = Math.min(min, count);
                continue;
            }
            for(int coin: coins) {
                if(newAmount - coin >= 0) {
                    stack.push(Arrays.asList(newAmount - coin, count + 1));
                }
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] coins = {10,18,19,20};
        System.out.println(coinChange(coins, 1000));
        //System.out.println(iterative(coins, 100));
    }
}
