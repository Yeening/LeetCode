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
    public int minIncrementForUnique(int[] A) {
        int totalMove = 0, maxValue = 0;
        int[] counting = new int[40001];
        for(int i : A){
            counting[i]++;
            maxValue = Math.max(maxValue, i);
        }
        for(int i = 0; i < maxValue; i++){
            if(counting[i] <= 1) continue;
            totalMove += (counting[i] - 1);
            counting[i+1] += (counting[i] - 1);
        }
        int remainNums = counting[maxValue];
        if(remainNums>1){
            totalMove += (remainNums*(remainNums-1)/2);
        }
        return totalMove;
    }
}
