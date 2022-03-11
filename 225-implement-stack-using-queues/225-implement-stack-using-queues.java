class MyStack {
    
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack() {
        
    }
    
    // O(1)
    public void push(int x) {
        q1.offer(x);
    }
    
    // O(2N)
    public int pop() {
        while(!q1.isEmpty() && q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int res = q1.poll();
        while(!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        
        return res;
    }
    
    // O(2N)
    public int top() {
        int res = this.pop();
        q1.offer(res);
        return res;
    }
    
    // O(1)
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */