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
    
    // backHistory的顶部就是当前visit所在的url，这个使得backHistory不能为空，最多清到size == 1
    public String back(int steps) {
        while (backHistory.size() > 1 && steps > 0) {
            forwardHistory.push(backHistory.pop());
            steps--;
        }
        
        return backHistory.peek(); 
    }
    
    // forward可以清空，出来的元素回到backhisotry，使得backhistory top始终为当前visit url
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