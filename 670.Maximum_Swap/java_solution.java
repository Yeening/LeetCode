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


// Solution 2: O(N)
class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        if (s.length() < 2) return num;
        int N = s.length();
        char[] ca = s.toCharArray();
        int left = N - 1, maxFromRight = ca[N-1] - '0';
        int[] maxIndex = new int[N];
        maxIndex[N-1] = N-1;
        for (int i = N - 2; i >= 0; i--) {
            int val = ca[i] - '0';
            if (val > maxFromRight) {
                maxFromRight = val;
                maxIndex[i] = i;
            } else {
                maxIndex[i] = maxIndex[i+1];
            }
        }
        for (int i = 0; i < N; i++) {
            int val = ca[i] - '0';
            if (val < ca[maxIndex[i]] - '0') {
                swap(ca, i, maxIndex[i]);
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
