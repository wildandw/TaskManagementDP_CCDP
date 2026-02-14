package app.task.objectpool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Supplier;

public class ObjectPool<T> {

    private final Deque<T> available = new ArrayDeque<>();
    private final Supplier<T> creator;
    private final int maxSize;

    public ObjectPool(Supplier<T> creator, int maxSize) {
        this.creator = creator;
        this.maxSize = maxSize;
    }

    public synchronized T acquire() {
        if (!available.isEmpty()) {
            return available.pop();
        }
        return creator.get();
    }

    public synchronized void release(T obj) {
        if (obj == null) return;

        if (available.size() < maxSize) {
            available.push(obj);
        }
    }

    public synchronized int availableCount() {
        return available.size();
    }
}
