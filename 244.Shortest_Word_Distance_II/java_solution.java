class WordDistance {
    Map<String, List<Integer>> map;
    int n;
    public WordDistance(String[] wordsDict) {
        map = new HashMap<>();
        n = wordsDict.length;
        for (int i = 0 ; i < wordsDict.length; i++) {
            map.putIfAbsent(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1), list2 = map.get(word2);
        int i = 0, j = 0, distance = n;
        while (i < list1.size() && j < list2.size()) {
            int index1 = list1.get(i), index2 = list2.get(j);
            if (index1 < index2) {
                distance = Math.min(distance, index2 - index1);
                i++;
            } else{
                distance = Math.min(distance, index1 - index2);
                j++;
            }
        }
        return distance;
    }
}
