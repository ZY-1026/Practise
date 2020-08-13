package thread.producerConsumer;

import java.util.LinkedList;

public class PC {
    private static int MAX_VALUE = Integer.MAX_VALUE;
    LinkedList<String> linkedList = new LinkedList<>();

    // 生产者
    public void product() throws Exception {
        synchronized (linkedList) {
            while (MAX_VALUE == linkedList.size()) {
                System.out.println("队列满");
                linkedList.wait();
            }
            linkedList.push("123");
            System.out.println("生产者生产商品");
            linkedList.notifyAll();
        }
    }

    // 消费者
    public void consumer() throws Exception {
        synchronized (linkedList) {
            while (linkedList.size() == 0) {
                System.out.println("队列空");
                linkedList.wait();
            }
            linkedList.pop();
            System.out.println("消费者消费商品");
            linkedList.notifyAll();
        }
    }
}
