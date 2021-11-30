/**
 * @Author LYZ
 * @Date 2021/11/30 11:37
 */
public class OperationDiv implements OperationInterface {
    @Override
    public double getResult(double A, double B) throws Exception {
        if (B == 0) {
            throw new Exception("除数不能为0 ");
        }
        return A / B;
    }
}
