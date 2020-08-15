package reference.weakReference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue referenceQueue = new ReferenceQueue();

        WeakReference reference = new WeakReference(new Object(),referenceQueue);
        System.out.println(reference);

        System.gc();

        Reference reference1 = referenceQueue.remove();
        System.out.println(reference1);
    }
}
