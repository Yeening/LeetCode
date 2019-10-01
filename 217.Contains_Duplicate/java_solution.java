class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            if(set.contains(num)) return true;
            //HashSet uses add() while HashTable and HashMap use put()
            set.add(num);
        }
        return false;
    }
}
