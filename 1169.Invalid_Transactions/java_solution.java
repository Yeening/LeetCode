class Solution {
    class Transaction implements Comparable<Transaction> {
        String name;
        String city;
        int amount;
        int time;
        String string;
        Transaction(String transaction) {
            String[] tokens = transaction.split(",",4);
            name = tokens[0]; 
            city = tokens[3];
            time = Integer.parseInt(tokens[1]); 
            amount = Integer.parseInt(tokens[2]);
            string = transaction;
        }
        
        public int compareTo(Transaction b) {
            return Integer.compare(this.time, b.time);
        }
    }
    public List<String> invalidTransactions(String[] transactions) {
        Transaction[] transArr = new Transaction[transactions.length];
        List<String> invalid = new ArrayList<>();
        for (int i = 0; i < transactions.length; i++) {
            transArr[i] = new Transaction(transactions[i]);
        }
        Arrays.sort(transArr);
        boolean[] isInvalid = new boolean[transArr.length];
        for (int i = 0; i < transArr.length; i++) {
            int curTime = transArr[i].time;
            String curName = transArr[i].name, curCity = transArr[i].city;
            if (transArr[i].amount > 1000 && !isInvalid[i]) {
                invalid.add(transArr[i].string);
                isInvalid[i] = true;
            }
            for (int j = i + 1; j < transArr.length; j++) {
                if (transArr[j].time > curTime + 60) {break;}
                if (transArr[j].name.equals(curName) && 
                   !transArr[j].city.equals(curCity)) {
                    if (!isInvalid[j]) {
                        invalid.add(transArr[j].string);
                        isInvalid[j] = true;
                    }
                    if (!isInvalid[i]) {
                        invalid.add(transArr[i].string);
                        isInvalid[i] = true;
                    }
                }
            }
        }
        return invalid;
    }
}
