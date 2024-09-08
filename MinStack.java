import java.util.Stack;

/**
 * Leetcode problem #155, Min Stack
 * https://leetcode.com/problems/min-stack/
 */
public class MinStack {
    public static void main(String[] args) {
        InnerMinStack minStack = new InnerMinStack();
        minStack.push(-1);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.push(1);
        System.out.println(minStack.getMin());
    }

    static class InnerMinStack {
        Stack<int[]> s = new Stack<>();

        public InnerMinStack() {
        }

        public void push(int val) {
            if (s.empty()) {
                s.push(new int[] { val, val });
                return;
            }
            s.push(new int[] { val, Math.min(val, getMin()) });
        }

        public void pop() {
            s.pop();
        }

        public int top() {
            return s.peek()[0];
        }

        public int getMin() {
            return s.peek()[1];
        }
    }
}
