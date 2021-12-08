# Calculate_By_Java_Version2
# Java策略模式

参考书目 《大话设计模式》 程杰 清华大学出版社

**代码链接** **https://github.com/JiaZhengJingXianSheng/Calculate_By_Java_Version2**

本文是对上篇 **Java简单工厂模式** 的重写，以达到代码更易于维护的目的。

## 一、 定义接口

与上篇不同，这篇我们选择定义接口，并在后续功能实现中， $implement$ 我们的接口。

接口定义加上参数，方便后期调用，定义如下

```java
public interface OperationInterface {
    double getResult(double A, double B) throws Exception;
}
```

## 二、 定义运算

接下来定义各种方法，来实现我们的接口。

```
public class OperationAdd implements OperationInterface {
    @Override
    public double getResult(double A, double B) {
        return A + B;
    }
}
```

```java
public class OperationSub implements OperationInterface {
    @Override
    public double getResult(double A, double B) {
        return A - B;
    }
}
```

```java
public class OperationMul implements OperationInterface {
    @Override
    public double getResult(double A, double B) {
        return A * B;
    }
}

```

```java
public class OperationDiv implements OperationInterface {
    @Override
    public double getResult(double A, double B) throws Exception {
        if (B == 0) {
            throw new Exception("除数不能为0 ");
        }
        return A / B;
    }
}
```

同样，还是去判断除数是否为0，为零抛出异常。

## 三、 策略定义

接下来我们在策略结构体中，定义我们的操作接口，并书写构造函数。

再根据我们的具体策略，返回其对应计算函数。

```java
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
```

## 四、 测试

在主函数中定义策略，并传入数值 $A,B$ 与操作符 $operate$ 。

根据操作符，生成对应运算，并构造策略。

最终调用具体策略对应的计算函数。

```java
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

        System.out.println(A + " + " + B + " = " + operation.ContextInterface(A, B));
    }
}
```

```
// 运行结果
1 + 2
1.0 + 2.0=3.0
```

## 总结

策略模式和工厂模式是比较类似的，工厂模式是通过继承抽象计算函数，并实现，本质来说和接口基本一样。 **策略模式是用来封装算法的，但在实际中，我们发现可以用它来封装几乎任何类型的规则。**

 **在基本的策略模式中，选择所用具体实现的职责由客户端对象承担，并转给策略模式的 $Context$  对象。**

