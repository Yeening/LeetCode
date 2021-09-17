// Solution 1: sorting and replace from the end
class Solution {
    // Time: O(nlogn) n: indices.length
    // Space: O(n)
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length(); //4
        int[][] indiceIndex = new int[indices.length][2];
        for (int i = 0 ; i < indices.length; i++) {
            indiceIndex[i][0] = indices[i];
            indiceIndex[i][1] = i;
        }
        // // [[0, 0], [2, 1]]
        Arrays.sort(indiceIndex, (a, b) -> (Integer.compare(b[0], a[0])));
        // [[2, 1], [0, 0]]
        for (int i = 0; i < indiceIndex.length; i++) {
            int indice = indiceIndex[i][0]; // 2
            String source = sources[indiceIndex[i][1]]; // "cd"
            String target = targets[indiceIndex[i][1]]; // "ffff"
            if (indice + source.length() <= s.length()) {
                if (s.substring(indice, indice + source.length()).equals(source)) {
                    s = s.substring(0, indice) + target + s.substring(indice + source.length());
                }
            }
        }
        return s;
    }
}

// Solution 2: use an array to record matches
// Time: O(sum(sources[i].length) + sum(targets[i].length) + s.length()))
// Space: O(s.length())
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length(); //4
        String[] newString = new String[n]; //[“eee”, null, null, null]
        for (int i = 0; i < indices.length; i++) {
            String source = sources[i]; // “cd”
            if (s.substring(indices[i], Math.min(s.length(), indices[i] + source.length())).equals(source)) {
                newString[indices[i]] = targets[i];
                Arrays.fill(newString, indices[i] + 1, Math.min(indices[i] + source.length(), n), "");
                /*
                for (int j = indices[i] + 1; j < indices[i] + source.length() && j < n; j++) {
                newString[j] = “”;
                }*/
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (newString[i] == null) {
                sb.append(s.charAt(i));
            } else {
                sb.append(newString[i]);
            }
        }
        return sb.toString();
    }
}

// Solution 3: use a map to record matches
class Solution {
    // Time: O(Nsources.length() + s.length()) N: indices.length
    // Space: O(matches), O(N)
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        // indiceIndex {0: 0, 2: 1}
        Map<Integer, Integer> indiceIndex = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            // i 1
            // indices[i] 2
            // sources[i] "cd"
            // s "abcd"
            // s.substring "cd"
            if (indices[i] + sources[i].length() <= s.length() && 
               s.substring(indices[i], indices[i] + sources[i].length()).equals(sources[i])) {
                indiceIndex.put(indices[i], i);
            }
        }
        StringBuilder sb = new StringBuilder();
        // sb: ["eeebffff"]
        for (int i = 0; i < s.length(); i++) {
            if (indiceIndex.containsKey(i)) {
                int index = indiceIndex.get(i);
                sb.append(targets[index]);
                i += sources[index].length() - 1;
            } else {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }

}
