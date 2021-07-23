// Solution 1: removing zero prefixes
class Solution {
    public String largestNumber(int[] nums) {
        String[] numStrings = new String[nums.length];
        for (int i = 0 ; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrings, this::compare);
        StringBuilder sb = new StringBuilder();
        for (String numString: numStrings) {
            sb.append(numString);
        }
        String res = sb.toString();
        int zeroPrefixes = 0;
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == '0') {
                zeroPrefixes++;
            } else break;
        }
        if (zeroPrefixes == res.length()) return "0";
        return res.substring(zeroPrefixes);
    }

    private int compare(String num1, String num2) {
        return (num2 + num1).compareTo(num1 + num2);
    }
}

// Solution 2:
class Solution {
    public String largestNumber(int[] nums) {
        String[] numStrings = new String[nums.length];
        for (int i = 0 ; i < nums.length; i++) {
            numStrings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numStrings, this::compare);
        // if the largest number is 0, the whole sequence is 0
        if (numStrings[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String numString: numStrings) {
            sb.append(numString);
        }
        return sb.toString();
    }

    private int compare(String num1, String num2) {
        return (num2 + num1).compareTo(num1 + num2);
    }
}
