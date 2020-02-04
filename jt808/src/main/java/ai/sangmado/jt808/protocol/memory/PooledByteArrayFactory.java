package ai.sangmado.jt808.protocol.memory;

import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 池化数组工厂
 */
public class PooledByteArrayFactory implements IByteArrayPool {
    private final int arraySize;
    private final Deque<byte[]> pool = new ConcurrentLinkedDeque<>();

    public PooledByteArrayFactory(int arraySize, int preAllocCount) {
        this.arraySize = arraySize;
        for (int i = 0; i < preAllocCount; i++) {
            pool.push(new byte[this.arraySize]);
        }
    }

    public int getArraySize() {
        return arraySize;
    }

    public PooledByteArray borrow() {
        byte[] array;

        try {
            if (pool.isEmpty()) {
                array = new byte[this.arraySize];
            } else {
                array = pool.pop();
            }
        } catch (NoSuchElementException ex) {
            array = new byte[this.arraySize];
        }

        return new PooledByteArray(array);
    }

    public void recycle(PooledByteArray pooledByteArray) {
        pool.push(pooledByteArray.array());
    }
}
