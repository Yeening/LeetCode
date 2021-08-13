// https://labuladong.gitbook.io/algo/mu-lu-ye-1/mu-lu-ye-2/dan-tiao-zhan
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            res[i] = s.isEmpty()? 0: s.peek() - i;
            s.push(i);
        }
        return res;
    }
}
