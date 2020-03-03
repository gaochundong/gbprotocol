package ai.sangmado.gbstandard.gbcommon.memory;

/**
 * 池化数组接口
 */
public interface IByteArrayPool {

    /**
     * 获取池化数组长度
     *
     * @return 数组长度
     */
    int getArraySize();

    /**
     * 借一个数组
     *
     * @return 数组对象
     */
    PooledByteArray borrow();

    /**
     * 还一个数组
     *
     * @param pooledByteArray 数组对象
     */
    void recycle(PooledByteArray pooledByteArray);
}
