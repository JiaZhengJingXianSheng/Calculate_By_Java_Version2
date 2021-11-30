import java.util.Scanner;

/**
 * @Author LYZ
 * @Date 2021/11/30 12:21
 */
public class Calculator {
    public static void main(String[] args) throws Exception {
        Operation operation = null;
        Scanner in = new Scanner(System.in);
        double A = in.nextDouble();
        String operate = in.next();
        double B = in.nextDouble();

        switch (operate) {
            case "+":
                operation = new Operation(new OperationAdd());
                break;
            case "-":
                operation = new Operation(new OperationSub());
                break;
            case "*":
                operation = new Operation(new OperationMul());
                break;
            case "/":
                operation = new Operation(new OperationDiv());
                break;
        }

        System.out.println(A + " + " + B + "=" + operation.ContextInterface(A, B));
    }
}
