class BrowserHistory {
    
    Deque<String> backStack;
    Deque<String> forwardStack;
    String curUrl;

    public BrowserHistory(String homepage) {
        backStack = new ArrayDeque<>();
        forwardStack = new ArrayDeque<>();
        curUrl = homepage;
    }
    
    public void visit(String url) {
        forwardStack.clear();
        backStack.push(curUrl);
        curUrl = url;
    }
    
    public String back(int steps) {
        for (int i = 0; i < steps && !backStack.isEmpty(); i++) {
            forwardStack.push(curUrl);
            curUrl = backStack.pop();
        }
        return curUrl;
    }
    
    public String forward(int steps) {
        for (int i = 0; i < steps && !forwardStack.isEmpty(); i++) {
            backStack.push(curUrl);
            curUrl = forwardStack.pop();
        }
        return curUrl;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
