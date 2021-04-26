public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    int height = maxGap(h, horizontalCuts);
    int width = maxGap(w, verticalCuts);
    final int MAX_VALUE = 1000000007;
    return (int)((long)height * (long)width % MAX_VALUE);
//            return MAX_VALUE / height <= width? MAX_VALUE: (height * width); // This will overflow at a product of 755332975
}

private int maxGap(int range, int[] cuts) {
    if (cuts == null || cuts.length == 0){
        return range;
    }
    Arrays.sort(cuts);
    int firstGap = cuts[0], lastGap = range - cuts[cuts.length-1];
    int max = Math.max(firstGap, lastGap);
    for (int i = 0; i < cuts.length - 1; i++) {
        max = Math.max(max, cuts[i + 1] - cuts[i]);
    }
    return max;
}
