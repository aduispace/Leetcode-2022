class MaxStack {
    Deque<int[]> stack;

    public MaxStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            this.stack.push(new int[]{x, x});
        } else {
            int curMax = this.stack.peek()[1];
            if (curMax < x) {
                this.stack.push(new int[]{x, x});
            } else {
                this.stack.push(new int[]{x, curMax});
            }
        }
    }
    
    public int pop() {
        return this.stack.pop()[0];
    }
    
    public int top() {
        return this.stack.peek()[0];
    }
    
    public int peekMax() {
        return this.stack.peek()[1];
    }
    
    public int popMax() {
        int max = this.stack.peek()[1];
        Deque<int[]> temp = new ArrayDeque<>();
        while (this.stack.peek()[0] != max) {
            temp.push(this.stack.pop());
        }
        this.stack.pop();
        while (!temp.isEmpty()) {
            this.push(temp.pop()[0]);
        }
        
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */