package queue;

public class MyCircularQueue {

    int[] q;
    int head = 0, tail = -1, n = 0;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        q = new int[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        
        if (tail == q.length - 1)
            tail = -1;
        
        q[++tail] = value;
        n++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty())
            return false;
        
        if (head == q.length - 1) {
            head = 0;
            n--;
            return true;
        }          
            
        head++; n--;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty())
            return -1;
        return q[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty())
            return -1;
        return q[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return n <= 0;     
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return n >= q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
