package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class No_232_LeetCode {
    // 自己写的 连续pop时性能不好
    class MyQueueBad {

        private final Stack<Integer> stack1;
        private final Stack<Integer> stack2;

        public MyQueueBad() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            if (stack2.empty()) {
                stack1.push(x);
            } else {
                stack2.push(x);
            }
        }

        public int pop() {
            Stack<Integer> emptyStack = transformStack();
            Integer pop = emptyStack.pop();
            transformStack();
            return pop;
        }

        public int peek() {
            Stack<Integer> emptyStack = transformStack();
            Integer peek = emptyStack.peek();
            transformStack();

            return peek;
        }

        private Stack<Integer> transformStack() {
            Stack<Integer> emptyStack;
            Stack<Integer> nonEmptyStack;

            if (stack1.empty()) {
                emptyStack = stack1;
                nonEmptyStack = stack2;
            } else {
                emptyStack = stack2;
                nonEmptyStack = stack1;
            }

            while (!nonEmptyStack.empty()) {
                emptyStack.push(nonEmptyStack.pop());
            }
            return emptyStack;
        }

        public boolean empty() {
            return stack1.size() == 0 && stack2.size() == 0;
        }
    }

    class MyQueue {
        Deque<Integer> inStack;
        Deque<Integer> outStack;

        public MyQueue() {
            inStack = new ArrayDeque<Integer>();
            outStack = new ArrayDeque<Integer>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.pop();
        }

        public int peek() {
            if (outStack.isEmpty()) {
                in2out();
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void in2out() {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }


}
