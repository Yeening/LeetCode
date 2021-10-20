/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

// suppose robot facing right, start from (0,0)
// dirs: [0:right, 1:down, 2: left, 3: up]
// DFS solution, set the start point as (0,0), the start direction as right
class Solution {
    private static final int[] dirs = new int[] {0, 1, 0, -1, 0};
    Set<String> visited;
    public void cleanRoom(Robot robot) {
        visited = new HashSet<>();
	    visit(robot, 0, 0, 0);
    }

    private void visit(Robot robot, int i, int j, int faceDir) {
        String cor = i + " " + j;
        if(visited.contains(cor)) {
            return;
        }
        robot.clean();
        visited.add(cor);
        // visit curDirection
        for (int d = faceDir; d < 4 + faceDir; d++) {
            if (robot.move()) {
                visit(robot, 
                      i + dirs[d % 4], 
                      j + dirs[(d + 1) % 4], 
                      d % 4);
                back(robot);
            }
            robot.turnRight();
        }
    }

   private void back(Robot robot) {
    robot.turnLeft();
    robot.turnLeft();
    robot.move();
    robot.turnLeft();
    robot.turnLeft();
   }
}


