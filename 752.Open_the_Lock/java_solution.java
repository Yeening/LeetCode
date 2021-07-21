class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadend = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        if (deadend.contains("0000")) return -1;
        Deque<String> deque = new LinkedList<>();
        deque.addLast("0000");
        int move = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String cur = deque.pollFirst();
                if (visited.contains(cur)) continue;
                visited.add(cur);
                if (deadend.contains(cur)) continue;
                if (cur.equals(target)) {
                    return move;
                }
                char[] lock = cur.toCharArray();
                for (int j = 0; j < 4; j++) {
                    int c = lock[j] - '0';
                    lock[j] = (char) ('0' + ((c + 1) % 10));
                    String next = new String(lock);
                    if (!visited.contains(next)){
                        deque.addLast(new String(lock));
                    }
                    lock[j] = (char) ('0' + ((c + 9) % 10));
                    next = new String(lock);
                    if (!visited.contains(next)){
                        deque.addLast(new String(lock));
                    }
                    lock[j] = (char)('0' + c);
                }
            }
            move++;
        }
        return -1;
    }
}
