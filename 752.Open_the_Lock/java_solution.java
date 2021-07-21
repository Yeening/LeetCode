// Solution 1: basic BFS
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

// Solution 2: double direction BFS
class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add("0000");
        q2.add(target);
        int step = 0;
        while(!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                Set<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            Set<String> temp = new HashSet<>();
            for (String cur: q1) {
                if (visited.contains(cur)) continue;
                visited.add(cur);
                if (q2.contains(cur)) return step;
                for (int i = 0 ; i < 4; i++) {
                    String added = addOne(cur, i);
                    if (!visited.contains(added)) {
                        temp.add(added);
                    }
                    String minused = minusOne(cur, i);
                    if (!visited.contains(minused)) {
                        temp.add(minused);
                    }
                }
            }
            step++;
            q1 = temp;
        }
        return -1;
    }

    private String addOne(String cur, int i) {
        char[] ca = cur.toCharArray();
        int c = ca[i] - '0';
        ca[i] = (char) ('0' + (c + 1) % 10);
        return new String(ca);
    }

    private String minusOne(String cur, int i) {
        char[] ca = cur.toCharArray();
        int c = ca[i] - '0';
        ca[i] = (char) ('0' + (c + 9) % 10);
        return new String(ca);
    }
}
