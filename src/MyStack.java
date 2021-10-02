import java.util.LinkedList;
import java.util.Queue;

// 225.用队列实现栈
public class MyStack {
    Queue<Integer> q;
    int top_element = 0;
    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);
        top_element = x;
    }

    public int pop() {
        int size = q.size();
        while (size > 2) {
            q.offer(q.poll());
            size--;
        }
        top_element = q.peek();
        q.offer(q.poll());
        return q.poll();
    }

    public int top() {
        return top_element;
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
