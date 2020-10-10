class Vector2D {
    int[][] mVector = null;
    int x = 0;
    int y = 0;

    public Vector2D(int[][] v) {
        mVector = v;
    }

    public int next() {
        hasNext();
        int res = mVector[x][y++];
        return res;
    }

    public boolean hasNext() {
        while(x < mVector.length){
            if(mVector[x] != null && y < mVector[x].length){
                return true;
            } else{
                x++;
                y = 0;
                continue;
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
