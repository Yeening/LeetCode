//Backtracking solution, beats 99.8%
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<>();
        backTracking(candidates, target, 0, res, new LinkedList<>());
        return res;
    }
    private void backTracking(int[] candidates, int remain, int start
                              , List<List<Integer>> res, LinkedList<Integer> temp){
        if(remain < 0) return;
        if(remain==0){
            res.add(new LinkedList<Integer>(temp));
        }
        else{
            for(int i = start; i < candidates.length; i++){
                //reduce half of time be skipping the big candidates
                if(candidates[i] > remain) break;
                temp.add(candidates[i]);
                //start from i because we need to try the same candidate again
                backTracking(candidates, remain-candidates[i], i, res, temp);
                temp.removeLast();
            }
        }
    }
}

//Old version
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> candidates = new ArrayList<Integer>();
        System.out.println("Type in candidates:");
        String str = "";
        if(scan.hasNextLine()){
            str = scan.nextLine();
        }
        String[] str_a = str.split(" ");
        for (String s: str_a
             ) {
            candidates.add(Integer.parseInt(s));
        }
        System.out.println(candidates);
        System.out.println("Type in target:");
        int target = 0;
        if(scan.hasNextInt()){
            target = scan.nextInt();
        }
        System.out.println(subsets(candidates, target));

    }
    private static List<List<Integer>> subsets(List<Integer> candidates, int target){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Collections.sort(candidates);
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }
    private static void backtrack(List<List<Integer>> list, List<Integer> current, List<Integer> candidates, int target, int start){
        if(target == 0){
            list.add(new ArrayList<>(current));
        }
        else if(target > 0){
            for (int i = start; i < candidates.size() && candidates.get(i) <= target; i++) {
                current.add(candidates.get(i));
                backtrack(list, current, candidates, target - candidates.get(i), i);
                current.remove(current.size() - 1);
            }
        }
    }
}
