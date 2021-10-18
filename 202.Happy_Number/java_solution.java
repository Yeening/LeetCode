class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int remain, sSum;
        //record sum numbers in a hashset
        while(set.add(n)){
            remain = 0;
            sSum = 0;
            while(n > 0){
                remain = n%10;
                sSum += remain*remain;
                n /= 10;
            }
            if(sSum == 1) return true;
            n = sSum;
        }
        return false;
    }
}

// solution 1, O(lgn) space
class Solution {
    // time: (lgn), space: (lgn)
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = next(n);
        }
        return n == 1;
    }
    
    private int next(int n) {
        int next = 0;
        while (n > 0) {
            next += (n % 10) * (n % 10);
            n /= 10;
        }
        return next;
    }
}

// solution 2, O(1) space, Floyd Cycle detection
class Solution {
    // time: (lgn), space: (lgn)
    public boolean isHappy(int n) {
        int fast = next(n), slow = n;
        while (slow != fast && slow != 1 && fast != 1) {
            fast = next(fast);
            fast = next(fast);
            slow = next(slow);
        }
        return slow == 1 || fast == 1;
    }
    
    private int next(int n) {
        int next = 0;
        while (n > 0) {
            next += (n % 10) * (n % 10);
            n /= 10;
        }
        return next;
    }
}
