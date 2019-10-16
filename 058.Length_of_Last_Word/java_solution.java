class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.length()-1;
        int length = 0;
        while(index>=0&&s.charAt(index)==' ') index--;
        while(index>=0&&s.charAt(index)!=' '){
            index--;
            length ++;
        } 
        return length;
    }
}
