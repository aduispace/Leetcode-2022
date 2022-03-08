class MinStack {
    Deque<int[]> stack; 

    public MinStack() {
        stack = new ArrayDeque<int[]>();
    }
    
    public void push(int val) {
        if (this.stack.isEmpty()) {
            this.stack.push(new int[]{val, val});
        } else {
            int curMin = stack.peek()[1];
            if (curMin > val) {
                this.stack.push(new int[]{val, val});
            } else {
                this.stack.push(new int[]{val, curMin});
            }
        }
    }
    
    public void pop() {
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek()[0];
    }
    
    public int getMin() {
        return this.stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */