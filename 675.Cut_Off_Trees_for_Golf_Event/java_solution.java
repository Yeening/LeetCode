class Solution {
    int M;
    int N;
    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest == null || forest.size()==0) return -1;
        M = forest.size();
        N = forest.get(0).size();

        PriorityQueue<int[]> trees = new PriorityQueue<>((a, b)->(a[2] - b[2]));
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                int height = forest.get(i).get(j);
                if(height > 1){
                    trees.add(new int[]{i, j, height});
                }
            }
        }

        int[] start = new int[2];
        int total_step = 0;

        while(!trees.isEmpty()){
            int[] tree = trees.poll();
            int step = stepToTree(start, tree, forest);
            if(step < 0) return -1;
            total_step += step;
            start[0] = tree[0];
            start[1] = tree[1];
        }

        return total_step;
    }

    private int stepToTree(int[] start, int[] tree, List<List<Integer>> forest){
        boolean[][] visited = new boolean[M][N];
        Queue<int[]> q = new LinkedList<>();
        int step = 0;

        q.add(start);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] current = q.poll();
                if(current[0] == tree[0] && current[1] == tree[1]){
                    return step;
                }
                for(int[] dir: directions){
                    int nextI = current[0] + dir[0];
                    int nextJ = current[1] + dir[1];
                    if(nextI < 0 || nextI >= M || nextJ < 0 || nextJ >=N 
                       || visited[nextI][nextJ] || forest.get(nextI).get(nextJ) == 0) continue;
                    q.add(new int[]{nextI, nextJ});
                    visited[nextI][nextJ] = true; //Set visited here to prevent duplicate points pushed to queue, overlapping position
                }
            }
            step++;
        }

        return -1;
    }
}
