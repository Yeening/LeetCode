// Explaination: https://leetcode.com/problems/robot-bounded-in-circle/discuss/290856/JavaC%2B%2BPython-Let-Chopper-Help-Explain
// Returns true if the robot returns to the original point or faces not North
class Solution {
    public boolean isRobotBounded(String instructions) {
        // define north as direction 0, increases in anti-clockwise
        int[][] dirs = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int x = 0, y = 0, dir = 0; 
        for (char c: instructions.toCharArray()) {
            switch (c) {
                case 'L':
                    dir = (dir+1)%4;
                    break;
                case 'R':
                    dir = (dir+3)%4;
                    break;
                case 'G':
                    x+=dirs[dir][0];
                    y+=dirs[dir][1];
                    break;
            }
        }
        return (x==0 && y==0) || dir != 0;
    }
}
