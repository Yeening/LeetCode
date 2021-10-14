// https://leetcode.com/problems/sell-diminishing-valued-colored-balls/discuss/927509/Java-O(NlogN)-or-Detailed-Explanation-or-Runtime-Beats-100
// time: O(N), space: O(1)
class Solution {
    static private final long MOD_BASE = 1000000007;
    // time: O(orders*log(inventory.length))
    /**
     inventory = [2,4,6,8,10], orders = 20
                        i
                        1 color: price (8,10]
                        2 colors: price (6,10)
    i = 4, curCount(n-i) = 1: 10, order -= (10 - 8) * 1 = 18
        profit += 1 * rangeSum(8,10]
    i = 3, curCount = 2: 8 8, order -= (8 - 6) * 2 = 14
        profit += 2 * rangeSum(6,8]
    i = 2, curCount = 3: 6 6 6, order -= (6 - 4) * 3 = 8
        profit += 2 * rangeSum(6,8]
    i = 1, curCount = 4: 4 4 4 4, order -= (4 - 2) * 4 = 0
        profit += 2 * rangeSum(4,6]             
    */
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int n = inventory.length;
        long profit = 0;
        for (int i = n - 1; i >= 0 && orders > 0; i--) {
            if (i > 0 && inventory[i-1] == inventory[i]) {continue;}
            int nextInventory = 0;
            if (i > 0) {nextInventory = inventory[i-1];}
            int curCount = n - i;
            if (orders >= curCount * (inventory[i] - nextInventory)) {
                // can sell curCount colors at price: 
                // (nextInventory, inventory[i]] (2,5]
                profit += (rangeSum(nextInventory + 1, inventory[i])
                    * curCount) % MOD_BASE;
                profit %= MOD_BASE;
                orders -= curCount * (inventory[i] - nextInventory);
            } else {
                // 2, 5 orders = 3, curCount = 2
                // [5,5] * 2 + 4 * 1
                // can sell curCount colors at price: 
                // [inventory[i] - orders / curCount + 1, inventory[i]]
                // and orders%curCount colors at price:
                // inventory[i] - orders / curCount
                long lowPrice = inventory[i] - orders / curCount + 1;
                profit += (rangeSum(lowPrice, inventory[i]) * curCount) % MOD_BASE;
                profit %= MOD_BASE;
                profit += ((orders % curCount) * (lowPrice - 1)) % MOD_BASE;
                profit %= MOD_BASE;
                assert((inventory[i] - lowPrice + 1) * curCount 
                    + orders % curCount == orders);
                orders = 0;
            }
        }
        return (int)profit;
    }
    
    private long rangeSum(long a, long b) {
        // sum of range [a,a+1,...,b]
        long res = (((long)a + b) * (b - a + 1) / 2) % MOD_BASE;
        return res;
    }
}
