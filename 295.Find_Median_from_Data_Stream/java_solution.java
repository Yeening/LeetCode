// Solution1: comparing large and small size, storing reverse value in the small heap
// class MedianFinder {
    
//     private PriorityQueue<Long> large;
//     private PriorityQueue<Long> small;
//     /** initialize your data structure here. */
//     public MedianFinder() {
//         large = new PriorityQueue<>();
//         small = new PriorityQueue<>();
//     }
    
//     public void addNum(int num) {
//         large.add((long)num);
//         small.add(-large.poll());
//         if(large.size() < small.size()){
//             large.add(-small.poll());
//         }
//     }
    
//     public double findMedian() {
//         if(large.size()==small.size()){
//             return (double)(large.peek()-small.peek())/2;
//         }
//         else return large.peek();
//     }
// }

//Solution 2: using reverse order PQ and odd-even attribute
class MedianFinder {
    
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;
    private boolean even = true;
    /** initialize your data structure here. */
    public MedianFinder() {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>((a,b)->(b-a));
    }
    
    public void addNum(int num) {
        if(even){
            small.add(num);
            large.add(small.poll());
        }
        else{
            large.add(num);
            small.add(large.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even){
            return (double)(large.peek()+small.peek())/2;
        }
        else return large.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
