package ai.sangmado.jt808.protocol.memory;

/**
 * 池化数组接口
 */
public interface IByteArrayPool {

    int getArraySize();

    PooledByteArray borrow();

    void recycle(PooledByteArray pooledByteArray);
}
