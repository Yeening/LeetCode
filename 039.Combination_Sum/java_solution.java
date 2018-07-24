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
