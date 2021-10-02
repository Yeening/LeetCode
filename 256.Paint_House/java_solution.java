int[] choice = new int[]{0,1,2,0};
public int minCost(int[][] costs) {
  int[] prevCost = new int[3];
  for (int[] cost: costs) {
    int[] nextCost = new int[3];
    for (int color = 0; color < 3; color++) {
      nextCost[color] = Math.min(choice[color], choice[color+1]) + cost[color];
    }
    cost = nextCost;
  }
  return Math.min(Math.min(cost[0], cost[1]), cost[2]);
}
