class Solution {
    int M;
    int N;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        M = image.length;
        N = image[0].length;
        fill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void fill(int[][] image, int i, int j, int newColor, int oldColor){
        if(i < 0 || i >=M || j<0 || j>=N || image[i][j]!=oldColor || image[i][j] == newColor) return; //Consider that oldColor == newColor, return when current color equals to newcolor
        image[i][j] = newColor;
        fill(image, i-1, j, newColor, oldColor);
        fill(image, i+1, j, newColor, oldColor);
        fill(image, i, j-1, newColor, oldColor);
        fill(image, i, j+1, newColor, oldColor);
    }
}
