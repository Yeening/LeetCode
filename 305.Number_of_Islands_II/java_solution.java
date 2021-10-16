class LandUf {
        boolean[][] isLand;
        int islandCount;
        private final int[] dirs = new int[]{-1, 0, 1, 0, -1};
        int m;
        int n;
        int[] root;
        int[] islandSize;
        public LandUf(int m, int n) {
            isLand = new boolean[m][n];
            islandCount = 0;
            this.m = m;
            this.n = n;
            root = new int[m*n];
            islandSize = new int[m*n];
        }

        public void insert(int[] position) {
            int i = position[0], j = position[1];
            isLand[i][j] = true;
            islandSize[i*n + j] = 1;
            root[i*n + j] = i*n + j;
            islandCount++;
            for (int d = 0; d < 4; d++) {
                int nextI = i + dirs[d], nextJ = j + dirs[d+1];
                if (nextI < 0 || nextI > m-1
                        || nextJ < 0 || nextJ > n-1) {continue;}
                if (isLand[nextI][nextJ]) {
                    union(i*n + j, nextI*n + nextJ);
                }
            }
        }

        public int getIslandCount() {
            return islandCount;
        }

        public List<Integer> getIslandSize() {
            List<Integer> res = new ArrayList<>(islandCount);
            for(int i = 0; i < root.length; i++) {
                if (root[i] == i && islandSize[i] > 0) {
                    res.add(islandSize[i]);
                }
            }
            return res;
        }

        private int find(int cur) {
            while (root[cur] != cur) {
                root[root[cur]] = root[root[root[cur]]];
            }
            return cur;
        }

        private void union(int key1, int key2) {
            int root1 = find(key1), root2 = find(key2);
            if (root1 != root2) {
                if (islandSize[root1] < islandSize[root2]) {
                    root[root1] = root2;
                    islandSize[root2] += islandSize[root1];
                } else  {
                    root[root2] = root[root1];
                    islandSize[root1] += islandSize[root2];
                }
            }
            islandCount--;
        }
    }


    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        LandUf landUf = new LandUf(m, n);
        List<Integer> res = new ArrayList<>(positions.length);
        for (int[] pos: positions) {
            landUf.insert(pos);
            res.add(landUf.getIslandCount());
        }
        System.out.println("island count: " + landUf.getIslandCount());
        return res;
    }
