class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int j = 0;
        int num = 0;
        for (int i = 0; i < abbr.length(); i++) {
            char c = abbr.charAt(i);
            if (Character.isDigit(c)) {
                if (num == 0 && c == '0') return false;
                num = num * 10 + (c - '0');
            } else {
                if (num > 0) {
                    j += num;
                    num = 0;
                }
                if (j >= word.length() || word.charAt(j) != c) return false;
                j++;
            }
        }
        return j + num == word.length();
    }
}
