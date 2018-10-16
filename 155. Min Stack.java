/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
*/

class MinStack {
    class Node {
        int value;
        int min;
        public Node (int value, int min){
            this.value = value;
            this.min = min;
        }
    }
    /** initialize your data structure here. */
    Stack<Node> stack;
    public MinStack() {
        stack = new Stack<Node>();
    }
    
    public void push(int x) {
        if (!stack.isEmpty()){
            Node node = new Node(x, Math.min(stack.peek().min, x));
            stack.push(node);
        } else {
            stack.push(new Node(x,x));
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()){
            stack.pop();
        }
    }
    
    public int top() {
        if (!stack.isEmpty()){
            return stack.peek().value;
        } else {
            return -1;
        }
        
    }
    
    public int getMin() {
        if (stack.isEmpty()){
            return -1;
        }
        return stack.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */