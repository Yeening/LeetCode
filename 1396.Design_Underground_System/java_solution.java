class UndergroundSystem {
    Map<Integer, Pair<String, Integer>> idToCheckIn; // id: {inStation, time}
    Map<String, int[]> routeToTime; // "stationA#stationB": {timeSum, count}
    String SEP = "#";
    public UndergroundSystem() {
        idToCheckIn = new HashMap<>();
        routeToTime = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        idToCheckIn.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInPair = idToCheckIn.get(id);
        if (checkInPair == null) {return;}
        String inStation = checkInPair.getKey();
        String route = inStation + SEP + stationName;
        int[] time = routeToTime.getOrDefault(route, new int[2]);
        time[0] += t - checkInPair.getValue();
        time[1]++;
        routeToTime.putIfAbsent(route, time);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + SEP + endStation;
        int[] time = routeToTime.get(route);
        if (time == null) {return 0;}
        return (double)time[0] / (double)time[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
