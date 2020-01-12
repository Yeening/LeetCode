class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b)->myCompare(a, b));
        return logs;
    }
    
    private int myCompare(String a, String b){
        int index1 = a.indexOf(' ');
        int index2 = b.indexOf(' ');
        char fc1 = a.charAt(index1+1);
        char fc2 = b.charAt(index2+1);
        
        if(fc1 <= '9'){
            if(fc2 <= '9') return 0;
            else return 1;
        }
        
        if(fc2 <= '9') return -1;
        
        int compareRes = a.substring(index1).compareTo(b.substring(index2));
        if(compareRes!=0) return compareRes;
        else return a.substring(0, index1).compareTo(b.substring(0, index2));
    }
}
