class Logger{

	private Map<String, Integer> logLastPrint;
	private int INTERVAL = 10;
	
	public Logger(){
		logLastPrint = new HashMap<>();
  }
  public boolean shouldPrint(String msg, int time) {
    boolean print = time - logLastPrint.getOrDefault(msg, -INTERVAL) >= INTERVAL;
    logLastPrint.put(msg, time);
    return print;
  }
}
