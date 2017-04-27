package commonsTest;

/**
 * 一个可重试可执行方法
 *
 * @author liaoqiqi
 * @version 2014-6-10
 */
public interface UnreliableInterface {

    <T> T call() throws Exception;

}
