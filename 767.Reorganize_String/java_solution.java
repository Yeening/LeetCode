/*
solution 1: count letter appearance and store in hash[i]
find the letter with largest occurence.
put the letter into even index numbe (0, 2, 4 ...) char array
put the rest into the array
*/ 
class Solution {
    /*
    4 a, 2 b, 1 c
    
    if most count > sum of other count less than most count + 1: false
    true;
    time: O(N), space: O(1)
    */
    public String reorganizeString(String s) {
        int[] charCount = new int[26];
        int maxChar = 'a';
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > charCount[maxChar - 'a']) {
                maxChar = i + 'a';
            }
        }
        char[] organizedArr = new char[s.length()];
        if ((s.length() + 1) >> 1 < charCount[maxChar - 'a']) {
            return "";
        }
        int index = 0;
        for (; index < s.length() && charCount[maxChar - 'a'] > 0; index += 2) {
            organizedArr[index] = (char)(maxChar);
            charCount[maxChar - 'a']--;
        }
        for (int c = 0; c < charCount.length; c++) {
            while (charCount[c] > 0) {
                if (index >= organizedArr.length) {index = 1;}
                organizedArr[index] = (char)('a' + c);
                charCount[c]--;
                index += 2;
            }
        }
        return new String(organizedArr);
    }
}

/*solution 2:
  use priority queue to get the most counted char, put it in the stringbuilder if it's not the same as prev
  otherwise, use the second most counted char 
*/
class Solution {
    /*
    4 a, 2 b, 1 c
    
    if most count > sum of other count less than most count + 1: false
    true;
    */
    public String reorganizeString(String s) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
        }
        // [char - 'a', occur]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->Integer.compare(b[1], a[1]));
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] == 0) {continue;}
            pq.offer(new int[]{i, charCount[i]});
        }
        // pq: {[0,2],[1,1]}
        StringBuilder sb = new StringBuilder();
        int prev = -1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll(); // [0,1]
            if (cur[0] != prev) {
                sb.append((char)('a' + cur[0])); //"a"
                cur[1]--;
                prev = cur[0];
            } else {
                if (pq.isEmpty()) {return "";}
                int[] next = pq.poll();
                sb.append((char)('a' + next[0]));
                next[1]--;
                if (next[1] > 0) {pq.offer(next);}
                prev = next[0];
            }
            if (cur[1] > 0) {pq.offer(cur);}
        }
        return sb.toString();
    }
}
