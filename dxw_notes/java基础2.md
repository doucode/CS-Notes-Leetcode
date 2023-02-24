## 异常 
Java异常类层次结构概览：  
![](https://camo.githubusercontent.com/ee3217a2cddcd33519e52da77d93de429866d8f3859202474d11fadb935ee65f/68747470733a2f2f67756964652d626c6f672d696d616765732e6f73732d636e2d7368656e7a68656e2e616c6979756e63732e636f6d2f6769746875622f6a61766167756964652f6a6176612f62617369732f74797065732d6f662d657863657074696f6e732d696e2d6a6176612e706e67)

`Throwable`两个重要的子类  
- `Exception`:程序本身可以处理的异常，可以通过catch捕获。它又可以分为Checked Exception(受检查异常，必须处理)和
Unchecked Exception(不受检查异常，可以不处理)。  
- `Error`:程序无法处理的错误。

除了`RuntimeException`及其子类以外，其他Exception类及其子类都是受检查异常，`RuntimeException`及其子类都统称为非受检查异常

### try,catch,finally
- `try`块：用于捕获异常，其后可以接零个或多个`catch`块，如果没有`catch`块，必须跟一个`finally`块
- `catch`块：用于处理try捕获到的异常
- `finally`块：无论是否捕获到异常，该块中的语句都会被执行，当`try`块或`catch`块中有`return`时，`finally`语句块将在方法返回之前被执行

**注意：不要在finally语句中使用return**

## 泛型
泛型一般有三种使用方法：泛型类，泛型接口，泛型方法

```java
public static <E> void method()
```
由于静态方法的加载先于类的实例化，也就是说类中的泛型还没有传递真正的类型参数，静态方法的加载就已经完成了，所以静态泛型方法没法使用类上声明的泛型，
只能使用自己声明的<E>

## 反射
通过反射你可以得到任意一个类的所有属性和方法，你还可以调用这些属性和方法。

Java中的**注解**的实现用到了反射

## 注解
注解本身是一个继承了`Annotation`的特殊接口

####注解的解析方法：  
1.编译器直接扫描  
2.运行期通过反射处理

## SPI
Service Provider Interface "服务提供者的接口"

API(Application Programming Interface)

![](https://camo.githubusercontent.com/61859167f1914191d09dda70df7b5292af08df4c3afeece56e32682b933162be/68747470733a2f2f67756964652d626c6f672d696d616765732e6f73732d636e2d7368656e7a68656e2e616c6979756e63732e636f6d2f6769746875622f6a61766167756964652f6a6176612f62617369732f7370692f316562643164663836326333343838306263323662396434393435333562336474706c762d6b3375316662706663702d77617465726d61726b2e706e67)

## 序列化和反序列化
- 序列化：将数据结构或对象转化成二进制字节流的过程
- 反序列化：将在序列化过程中生成的二进制字节流转换成数据结构和对象的过程

序列化协议对应于TCP/IP四层模型中的**应用层**

使用`transient`关键字修饰，可以阻止变量被序列化

[参考](https://github.com/Snailclimb/JavaGuide/blob/main/docs/java/basis/java-basic-questions-03.md)