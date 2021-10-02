//Solution1: 5%
// class Solution {
//     public int minIncrementForUnique(int[] A) {
//         // Map<Integer, Integer> map = new HashMap<>();
//         int[] map = new int[80000];
//         int totalMove = 0;
//         for(int i:A){
//             int move = 0;
//             while(map[i]>0){
//                 i++;
//                 move++;
//             } 
//             map[i] = 1;
//             totalMove += move;
//         }
//         return totalMove;
//     }
// }

//Solution2: sorting, 42%
// class Solution {
//     public int minIncrementForUnique(int[] A) {
//         Arrays.sort(A);
//         int need = 0, totalMove = 0;
//         for(int i : A){
//             totalMove += Math.max(need - i,0);
//             need = Math.max(need,i)+1;
//         }
//         return totalMove;
//     }
// }

//Solution3: counting sort
class Solution {
    // lowU: 5
    // move: 3
    // 1,1,2,2,3
    // [0,2,3,3]
    //  time: O(maxVal + nums.length), space: O(maxVal + nums.length)
    public int minIncrementForUnique(int[] nums) {
        int move = 0, maxVal = 0;
        for (int num: nums) {
            maxVal = Math.max(maxVal, num);
        }
        int[] numCount = new int[maxVal + nums.length];
        for (int num: nums) {
            numCount[num]++;
        }
        for (int i = 0; i < numCount.length; i++) {
            if (numCount[i] > 1) {
                int extra = numCount[i] - 1;
                move += extra;
                numCount[i + 1] += extra;
            }
            if (numCount[i] == 0 && i > maxVal) {break;}
        }
        return move;
    }
}
