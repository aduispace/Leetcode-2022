class Logger {
    
    Map<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        int diff = 10;
        if (map.containsKey(message)) {
            diff = timestamp - map.get(message);
            if (diff < 10) return false;
        }
        
        map.put(message, timestamp);
        
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */