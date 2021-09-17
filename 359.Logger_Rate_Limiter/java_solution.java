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


// Optimize Space
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
