class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        if (s.length() < 2) return num;
        char[] caS = s.toCharArray();
        Arrays.sort(caS);
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] != caS[ca.length - 1 - i]) {
                int index = findIndexFromRight(ca, caS[ca.length - 1 - i]);
                swap(ca, i, index);
                return Integer.valueOf(String.valueOf(ca));
            }
        }
        return num;
    }


    private void swap(char[] ca, int i, int j) {
        char temp = ca[i];
        ca[i] = ca[j];
        ca[j] = temp;
    }

    private int findIndexFromRight(char[] ca, char target) {
        for (int i = ca.length - 1; i >= 0; i--) {
            if (ca[i] == target) return i;
        }
        return -1;
    }
}
