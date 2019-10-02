// Solution 1, 6ms, 51%
// class Solution {
//     public int romanToInt(String s) {
//         Map<Character, Integer> dic = new HashMap<>();
//         buildDic(dic);
//         int sum = 0;
//         for(int i = 0; i < s.length(); i++){
//             int val = dic.get(s.charAt(i));
//             if(val==1&&(s.indexOf('V')>i||s.indexOf('X',i)>i)) sum -= val;
//             else if(val==10&&(s.indexOf('L')>i||s.indexOf('C',i)>i)) sum -= val;
//             else if(val==100&&(s.indexOf('D')>i||s.indexOf('M',i)>i)) sum -= val;
//             else sum += val;
//         }
//         return sum;
//     }
//     private void buildDic(Map<Character, Integer> dic){
//         dic.put('I',1);
//         dic.put('V',5);
//         dic.put('X',10);
//         dic.put('L',50);
//         dic.put('C',100);
//         dic.put('D',500);
//         dic.put('M',1000);
//     }
// }

// Solution 2, 6ms, 51%
// class Solution {
//     public int romanToInt(String s) {
//         Map<Character, Integer> dic = new HashMap<>();
//         buildDic(dic);
//         int sum = 0;
//         int next = dic.get(s.charAt(0));
//         for(int i = 0; i < s.length()-1; i++){
//             int val = next;
//             next = dic.get(s.charAt(i+1));
//             if(next > val) sum -= val;
//             else sum += val;
//         }
//         sum += next;
//         return sum;
//     }
//     private void buildDic(Map<Character, Integer> dic){
//         dic.put('I',1);
//         dic.put('V',5);
//         dic.put('X',10);
//         dic.put('L',50);
//         dic.put('C',100);
//         dic.put('D',500);
//         dic.put('M',1000);
//     }
// }

// Solution 3， 3ms, 100%
class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        char pre = 0;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            sum += getValue(cur, pre);
            pre = cur;
        }
        return sum;
    }
    private int getValue(char cur, char pre){
        if(pre=='I'&&cur=='V') return 3;
        if(pre=='I'&&cur=='X') return 8;
        if(pre=='X'&&cur=='L') return 40 - 10;
        if(pre=='X'&&cur=='C') return 90 - 10;
        if(pre=='C'&&cur=='D') return 400 - 100;
        if(pre=='C'&&cur=='M') return 900 - 100;
        if(cur=='I') return 1;
        if(cur=='V') return 5;
        if(cur=='X') return 10;
        if(cur=='L') return 50;
        if(cur=='C') return 100;
        if(cur=='D') return 500;
        if(cur=='M') return 1000;
        return -1;
    }
}
