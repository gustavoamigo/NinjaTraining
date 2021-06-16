package array;

public class Sum {


    public static int dfs(int[] nums, int i, int currentSum, int target) {
        if(nums == null) return 0;
        if(i==nums.length ) {
            if (currentSum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int resultPlus = dfs(nums, i+1, currentSum + nums[i], target);
        int resultMinus = dfs(nums, i+1, currentSum - nums[i], target);
        return resultPlus + resultMinus;
    }
    public static int numSignWays(int[] nums, int target) {

        return dfs(nums, 0, 0, target);
    }

    // remove or comment if running tests (we run our own main)
    public static void main(String[] args) {
        Sum.numSignWays(null, 0);
    }

}
