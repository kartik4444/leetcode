class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int bars = 0;
        int sum = 0;
        for (int cost : costs) {

            if (coins > 0 && cost <= coins) {
                coins = coins - cost;
                bars++;
            } else
                break;

        }
        return bars == 0 ? 0 : bars;
    }
}