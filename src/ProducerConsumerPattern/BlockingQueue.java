package ProducerConsumerPattern;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private Queue<Integer> queue;
    private final int capacity;

    public BlockingQueue(int capacity){
        queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public boolean add(int elem){
        synchronized (this){
            while(queue.size() == capacity){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.add(elem);
            // for all the threads waiting in the remove method queue.isEmpty() condition
            queue.notifyAll();
            return true;
        }
    }

    public int remove(){
        synchronized (this){
            // we have added while condition because if more than 1 thread is waiting and then the lock is released
            // so there can be condition where we can go to remove elements from empty queue
            while(queue.isEmpty()){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            int removedElem = queue.poll();
            // for all the threads waiting in the add method queue.size() == capacity condition
            queue.notifyAll();
            return removedElem;
        }
    }

}
