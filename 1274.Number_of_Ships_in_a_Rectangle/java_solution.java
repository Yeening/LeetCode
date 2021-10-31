class Solution {

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
      if (bottomLeft[0] < topRight[0] || bottomLeft[1] < topRight[1]) {return 0;}
      if (!sea.hasShips(topRight, bottomLeft)) {return 0;}
      int left = bottomLeft[1], down = bottomLeft[0], right = topRight[1], up = topRight[0];
      if (left == right && down == up) {return 1;}
      int yMid = (left + right) >> 1, xMid = (up + down) >> 1;

      int count = countShips(sea, new int[]{xMid, yMid}, bottomLeft);
      count += countShips(sea, new int[]{up, yMid}, new int[]{xMid + 1, left});
      count += countShips(sea, new int[]{xMid, right}, new int[]{down, yMid + 1});
      count += countShips(sea, topRight, new int[]{xMid+1, yMid+1});
      return count;
    }
}
