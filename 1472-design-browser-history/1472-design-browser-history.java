class BrowserHistory {
    Deque<String> backHistory = new ArrayDeque<String>();;
    Deque<String> forwardHistory = new ArrayDeque<String>();

    public BrowserHistory(String homepage) {
        backHistory.push(homepage);
    }
    
    public void visit(String url) {
        backHistory.push(url);
        forwardHistory.clear();
    }
    
    public String back(int steps) {
        while (backHistory.size() > 1 && steps > 0) {
            forwardHistory.push(backHistory.pop());
            steps--;
        }
        
        return backHistory.peek(); 
    }
    
    public String forward(int steps) {
        while (forwardHistory.size() > 0 && steps > 0) {
            backHistory.push(forwardHistory.pop());
            steps--;
        }
        
        return backHistory.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */