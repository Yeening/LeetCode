class Logger{

	private Map<String, Integer> logLastPrint;
	private int INTERVAL = 10;
	
	public Logger(){
		logLastPrint = new HashMap<>()
	};
  }
  public boolean shouldPrint(String msg, int time) {
    boolean print = time - logLastPrint.getOrDefault(msg, -INTERVAL) >= INTERVAL;
    logLastPrint.put(msg, time);
    return print;
  }
}


// Optimize Space. time O(total log within INTERVAL window), space: O(total log within INTERVAL window)
class Logger{

    private Map<String, Integer> logLastPrint;
    private int INTERVAL = 10;

    public Logger(){
        logLastPrint = new HashMap<>();
    }

    public boolean shouldPrint(String msg, int time) {
        boolean print = time - logLastPrint.getOrDefault(msg, -INTERVAL) >= INTERVAL;
        if (print) {
            updateMap(time);
        }
        logLastPrint.put(msg, time);
        return print;
    }

    private void updateMap(int time) {
        Map<String, Integer> newMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry: logLastPrint.entrySet()) {
            if (time - entry.getValue() < INTERVAL) {
                newMap.put(entry.getKey(), entry.getValue());
            }
        }
        logLastPrint = newMap;
    }
}

// Solution 3:
// time: O(INTERVAL), space:(total message in INTERVAL-length window)
public class Logger {
    // all message’s last print should be in [0,9] seconds from now
    Set<String>[] last10Sec;
    int newestTime = 0;
    private static final int INTERVAL = 10;

    public Logger() {
        last10Sec = new Set[INTERVAL];
        for (int i = 0; i < 10; i++) {
            last10Sec[i] = new HashSet<>();
        }
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        moveForward(last10Sec, timestamp - newestTime);
        assert(timestamp - newestTime == 0 || last10Sec[9].isEmpty());
        newestTime = timestamp;
        for (int i = 0; i < INTERVAL; i++) {
            if (last10Sec[i].contains(message)) {return false;}
        }
        last10Sec[INTERVAL - 1].add(message);
        return true;
    }
    // step = 1, copy [1,9] to [0,8], empty[9,9]
    private void moveForward(Set<String>[] last10Sec, int step) {
        if (step == 0) {return;}
        if (step > INTERVAL - 1) {
            for (Set<String> set: last10Sec) {set.clear();}
            return;
        }
        // copy [step, n] to [0, n - step - 1]
        System.arraycopy(last10Sec, step, last10Sec, 0, INTERVAL - step);
        // clear [n-step, n-1]
        for (int i = INTERVAL - step; i < INTERVAL; i++) {
            last10Sec[i] = new HashSet<>();
        }
    }
}

// Solution 4: 
