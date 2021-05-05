import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public  class Main{
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.poll());
    }
}
class MaxQueue {

    Queue<Integer> queue1;
    Deque<Integer> queue2;

    public MaxQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public int max_value() {
        return queue2.isEmpty() ? -1 : queue2.peekFirst();
    }

    public void push_back(int value) {
        while (!queue2.isEmpty() && value > queue2.peekLast()) {
            queue2.pollLast();
        }
        queue1.offer(value);
        queue2.offerLast(value);
    }

    public int pop_front() {
// 不明白这四行代码为甚么错×
        if (!queue2.isEmpty() && queue1.peek() == queue2.peekFirst()) {
            queue2.pollFirst();
        }
        return queue1.isEmpty() ? -1 : queue1.poll();

//        if (queue1.isEmpty()) return -1;
//        int ans = queue1.poll();
//        if (!queue2.isEmpty() && ans == queue2.peekFirst()) {
//            queue2.pollFirst();
//        }
//        return ans;
    }
}