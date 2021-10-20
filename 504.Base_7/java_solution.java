class Solution {
    // 100 /10 = 10, 10 /10 = 1, 1 /10 = 0
    // 100 % 10 = 0, 10 %10 = 0, 1 %10 = 1
    // 100 / 7 = 14, 14 / 7 = 2, 2 / 7 = 0
    // 100 % 7 = 2,  14 % 7 = 0, 2 % 7 = 2
    // -7 / 7 = -1， -1 / 7 = 0
    // -7 % 7 = 0， -1 % 7 = -1
    public String convertToBase7(int num) {
        if (num == 0) {return "0";}
        StringBuilder sb = new StringBuilder();
        boolean negative = false;
        if (num < 0) {
            negative = true;
            num = -num;
        }
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (negative) {sb.append('-');}
        sb.reverse();
        return sb.toString();
    }
}
