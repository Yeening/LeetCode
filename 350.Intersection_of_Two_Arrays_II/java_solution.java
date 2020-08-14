class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int num: nums1){
            map1.put(num, map1.getOrDefault(num,0)+1);
        }
        for(int num: nums2){
            if(map1.containsKey(num)){
                list.add(num);
                if(map1.get(num) == 1){
                    map1.remove(num);
                } else{
                    map1.put(num, map1.get(num)-1);
                }
            }
        }
        int[] res = new int[list.size()];
        int i = 0;
        for(int num: list){
            res[i++] = num;
        }
        return res;
    }
}
