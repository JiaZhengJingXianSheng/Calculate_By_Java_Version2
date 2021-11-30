/**
 * @Author LYZ
 * @Date 2021/11/30 11:38
 */
public class Operation {
    OperationInterface strategy;
    public Operation(OperationInterface strategy){
        this.strategy = strategy;
    }
    // 根据具体策略对象，调用其方法。
    public double ContextInterface(double A, double B) throws Exception {
        return strategy.getResult(A,B);
    }

}
