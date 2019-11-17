package fb;

class MaxProfit {
  public int maxProfit(int[] prices) {
    int minValue = Integer.MAX_VALUE;
    int maxProfit = 0;
    for(int i = 0; i<prices.length; i++) {
      maxProfit = Math.max(prices[i] - minValue, maxProfit );
      minValue = Math.min(prices[i], minValue);
    }
    return maxProfit;
  }


}
