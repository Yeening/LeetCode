class Leaderboard {
        TreeMap<Integer, Set<Integer>> scoreToId;
        HashMap<Integer, Integer> idToScore;
        public Leaderboard() {
            scoreToId = new TreeMap<>(Comparator.reverseOrder());
            idToScore = new HashMap<>();
        }

        public void addScore(int playerId, int score) {
            Integer oldScore = idToScore.put(playerId, idToScore.getOrDefault(playerId, 0) + score);
            if (oldScore != null) {
                scoreToId.get(oldScore).remove(playerId);
            } else {
                oldScore = 0;
            }
            scoreToId.putIfAbsent(oldScore + score, new HashSet<>());
            scoreToId.get(oldScore + score).add(playerId);
        }

        public int top(int K) {
            int sum = 0;
            for (Map.Entry<Integer, Set<Integer>> entry: scoreToId.entrySet()) {
                int score = entry.getKey(), size = entry.getValue().size();
                if (K <= size) {
                    sum += K * score;
                    System.out.println(sum);
                    return sum;
                } else {
                    sum += size * score;
                    K -= size;
                }
            }
            System.out.println(sum);
            return sum;
        }

        public void reset(int playerId) {
            Integer oldScore = idToScore.get(playerId);
            if (oldScore == null) {return;}
            scoreToId.get(oldScore).remove(playerId);
            scoreToId.putIfAbsent(0, new HashSet<>());
            scoreToId.get(0).add(playerId);
            idToScore.put(playerId, 0);
        }
    }
