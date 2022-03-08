class MyQueue {
    Deque<Integer> queue = new ArrayDeque<Integer>();
    Deque<Integer> stack = new ArrayDeque<Integer>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        if (queue.isEmpty()) {
            while (!stack.isEmpty()) {
                queue.push(stack.pop());
            }
        }
        return queue.pop();
    }
    
    public int peek() {
        int res = this.pop();
        queue.push(res);
        return res;
    }
    
    public boolean empty() {
        return queue.isEmpty() && stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */