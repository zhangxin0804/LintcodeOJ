public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> helper;
    
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        helper = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if( helper.empty() || number <= helper.peek() ){
            helper.push(number);
        }
    }

    public int pop() {
        // write your code here
        if( stack.peek().equals(helper.peek()) ){
            helper.pop();
        }
        int res = stack.pop();
        return res;
    }

    public int min() {
        // write your code here
        return helper.peek();
    }
}
