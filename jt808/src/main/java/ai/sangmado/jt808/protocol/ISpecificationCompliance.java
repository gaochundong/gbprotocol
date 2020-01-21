package ai.sangmado.jt808.protocol;

/**
 * 遵循协议版本规范
 */
public interface ISpecificationCompliance<TBuilder> {

    /**
     * 遵循协议版本
     *
     * @param version 协议版本号
     * @return 协议对象构造器
     */
    TBuilder complianceWith(ISpecificationContext version);
}
