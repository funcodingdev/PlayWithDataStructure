package segmentTree;

/**
 * @Author: FangJu
 * @Date: 2019/8/21
 */
public interface Merger<E> {
    E merge(E left, E right);
}
