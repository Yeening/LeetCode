// Solurion 1: iterative 2d dp 
class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        int[][] dp = new int[m][n];
        ArrayList<Integer> lastPos = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (ring.charAt(j) == key.charAt(0)) {
                dp[0][j] = shortestDis(0, j, n);
                lastPos.add(j);
            } else {
                dp[0][j] = -1;
            }
        }

        for (int i = 1; i < m; i++) {
            char c = key.charAt(i);
            ArrayList<Integer> curPos = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (ring.charAt(j) == c) {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int last: lastPos) {
                        dp[i][j] = Math.min(dp[i][j],
                                dp[i-1][last] + shortestDis(last, j, n));
                    }
                    curPos.add(j);
                } else {
                    dp[i][j] = -1;
                }
            }
            lastPos = curPos;
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if (dp[m-1][j] >= 0)
                res = Math.min(res, dp[m-1][j]);
        }
        return res + key.length();
    }
    
    private int shortestDis(int i, int j, int N) {
        if (i > j) {
            return shortestDis(j, i, N);
        }
        return Math.min(j - i, N - (j - i));
    }
}

// Solution 2: iterative 1d dp, with dictionary

public int findRotateSteps(String ring, String key) {
    int n = ring.length(), m = key.length();
    // save ring to dict
    ArrayList<Integer>[] dict = new ArrayList[26];
    for (int i = 0 ; i < 26; i++) {
        dict[i] = new ArrayList<>();
    }
    for (int i = 0 ; i < ring.length(); i++) {
        dict[ring.charAt(i) - 'a'].add(i);
    }
    int[] dp = new int[n];

    for (int j = 0; j < n; j++) {
        if (ring.charAt(j) == key.charAt(0)) {
            dp[j] = shortestDis(0, j, n);
        }
    }

    for (int i = 1; i < m; i++) {
        char c = key.charAt(i);
        for (int j: dict[c - 'a']) {
            int cur = Integer.MAX_VALUE;
            for (int last: dict[key.charAt(i-1) - 'a']) {
                cur = Math.min(cur, dp[last] + shortestDis(last, j, n));
            }
            dp[j] = cur;
        }
    }

    int res = Integer.MAX_VALUE;
    for (int last: dict[key.charAt(m-1) - 'a']) {
        res = Math.min(res, dp[last]);
    }
    return res + key.length();
}

private int shortestDis(int i, int j, int N) {
    if (i > j) {
        return shortestDis(j, i, N);
    }
    return Math.min(j - i, N - (j - i));
}

// Solution 3: recursive solution with memo
class Solution {
    ArrayList<Integer>[] dict;
    int[][] memo;
    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        memo = new int[m][n];
        for (int i = 0 ; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        // save ring to dict
        dict = new ArrayList[26];
        for (int i = 0 ; i < 26; i++) {
            dict[i] = new ArrayList<>();
        }
        for (int i = 0 ; i < ring.length(); i++) {
            dict[ring.charAt(i) - 'a'].add(i);
        }
        return rotateSteps(key, ring,0, 0) + key.length();
    }

    private int rotateSteps(String key, String ring, int start, int curPos) {
        if (start == key.length()) return 0;
        if (memo[start][curPos] >= 0) return memo[start][curPos];
        char c = key.charAt(start);
        int res = Integer.MAX_VALUE;
        for (int i: dict[c - 'a']) {
            int subProblem = rotateSteps(key, ring, start + 1, i);
            res = Math.min(res,
                    shortestDis(i, curPos, ring.length()) + subProblem);
        }
        memo[start][curPos] = res;
        return res;
    }

    private int shortestDis(int i, int j, int N) {
        if (i > j) {
            return shortestDis(j, i, N);
        }
        return Math.min(j - i, N - (j - i));
    }
}
