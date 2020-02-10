class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> deque = new LinkedList<>();
        for(int current: asteroids){
            if(current>0){
                deque.addLast(current);
            }
            else{
                while(!deque.isEmpty()&&deque.getLast()>0&&deque.getLast()<-current)
                    deque.pollLast();
                if(!deque.isEmpty()&&deque.getLast()>0&&deque.getLast()==-current)
                    deque.pollLast();
                else if(deque.isEmpty()||deque.getLast()<0)
                    deque.addLast(current);
            }
        }
        return deque.stream().mapToInt(i->i).toArray();
    }
}
