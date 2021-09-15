class Solution {
    /*["Science"7,"is"2,"what"4,"we"2,"understand"10,"well",
        "enough","to","explain","to","a","computer.",
        "Art","is","everything","else","we","do"]
    */
    // maxWidth 20
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>(words.length);
        StringBuilder line = new StringBuilder(words[0]);
        for (int i = 1; i < words.length; i++) {
            String cur = words[i];
            if (cur.length() + line.length() + 1 > maxWidth) {
                res.add(justify(line.toString(), maxWidth));
                line = new StringBuilder(cur);
            } else {
                line.append(' ');
                line.append(cur);
            }
        }
        for (int i = line.length(); i < maxWidth; i++) {
            line.append(' ');
        }
        res.add(line.toString());
        return res;
    }
    // "Science is what we" maxW = 20
    private String justify(String line, int maxWidth) {
        if (line.length() == maxWidth) {
            return line;
        }
        int extraSpaces = maxWidth - line.length(); //2
        String[] words = line.split(" ");
        int[] countSpaces = new int[words.length];;
        if (words.length == 1) {
            countSpaces[0] = extraSpaces;
        } else {
            for (int i = 0; i < countSpaces.length - 1; i++) {
                countSpaces[i] = extraSpaces / (words.length - 1) + 1;
                if (i < extraSpaces % (words.length - 1)) {
                    countSpaces[i]++;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            for (int j = 0; j < countSpaces[i]; j++) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
