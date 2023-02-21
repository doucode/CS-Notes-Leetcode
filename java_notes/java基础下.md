## 异常

Java 异常类层次结构图概览 ：

![](https://camo.githubusercontent.com/ee3217a2cddcd33519e52da77d93de429866d8f3859202474d11fadb935ee65f/68747470733a2f2f67756964652d626c6f672d696d616765732e6f73732d636e2d7368656e7a68656e2e616c6979756e63732e636f6d2f6769746875622f6a61766167756964652f6a6176612f62617369732f74797065732d6f662d657863657074696f6e732d696e2d6a6176612e706e67)
### Exception 和 Error 有什么区别？
在 Java 中，所有的异常都有一个共同的祖先 java.lang 包中的 Throwable 类。Throwable 类有两个重要的子类:

- Exception :程序本身可以处理的异常，可以通过 catch 来进行捕获。Exception 又可以分为 Checked Exception (受检查异常，必须处理) 和 Unchecked Exception (不受检查异常，可以不处理)。  
- Error ：Error 属于程序无法处理的错误 ，我们没办法通过 catch 来进行捕获不建议通过catch捕获 。例如 Java 虚拟机运行错误（Virtual MachineError）、虚拟机内存不够错误(OutOfMemoryError)、类定义错误（NoClassDefFoundError）等 。这些异常发生时，Java 虚拟机（JVM）一般会选择线程终止。

Throwable 类常用方法有哪些？  
- String getMessage(): 返回异常发生时的简要描述  
- String toString(): 返回异常发生时的详细信息  
- String getLocalizedMessage(): 返回异常对象的本地化信息。使用 Throwable 的子类覆盖这个方法，可以生成本地化信息。如果子类没有覆盖该方法，则该方法返回的信息与 getMessage()返回的结果相同  
- void printStackTrace(): 在控制台上打印 Throwable 对象封装的异常信息

try-catch-finally 如何使用？  
- try块 ： 用于捕获异常。其后可接零个或多个 catch 块，如果没有 catch 块，则必须跟一个 finally 块。  
- catch块 ： 用于处理 try 捕获到的异常。  
- finally 块 ： 无论是否捕获或处理异常，finally 块里的语句都会被执行。当在 try 块或 catch 块中遇到 return 语句时，finally 语句块将在方法返回之前被执行。

####finally 中的代码一定会执行吗？  
不一定的！在某些情况下，finally 中的代码不会被执行。

### 泛型

#### 泛型的使用方式有哪几种？
泛型一般有三种使用方式:泛型类、泛型接口、泛型方法。


### 反射
[Java 反射机制详解](https://github.com/Snailclimb/JavaGuide/blob/main/docs/java/basis/reflection.md)
#### 反射的应用场景？
像咱们平时大部分时候都是在写业务代码，很少会接触到直接使用反射机制的场景。但是！这并不代表反射没有用。相反，正是因为反射，你才能这么轻松地使用各种框架。像 Spring/Spring Boot、MyBatis 等等框架中都大量使用了反射机制。

### 注解
####何谓注解？
Annotation （注解） 是 Java5 开始引入的新特性，可以看作是一种特殊的注释，主要用于修饰类、方法或者变量，提供某些信息供程序在编译或者运行时使用。

### 序列化和反序列化
关于序列化和反序列化的详细解读，请看这篇文章 [Java 序列化详解](https://github.com/Snailclimb/JavaGuide/blob/main/docs/java/basis/serialization.md) ，里面涉及到的知识点和面试题更全面。

- 序列化： 将数据结构或对象转换成二进制字节流的过程   
- 反序列化：将在序列化过程中所生成的二进制字节流转换成数据结构或者对象的过程

#### 如果有些字段不想进行序列化怎么办？
对于不想进行序列化的变量，使用 transient 关键字修饰。

### I/O
[Java IO 基础知识总结](https://github.com/Snailclimb/JavaGuide/blob/main/docs/java/io/io-basis.md)  
[Java IO 设计模式总结](https://github.com/Snailclimb/JavaGuide/blob/main/docs/java/io/io-design-patterns.md)  
[Java IO 模型详解](https://github.com/Snailclimb/JavaGuide/blob/main/docs/java/io/io-model.md)

#### Java IO 流了解吗？
Java IO 流的 40 多个类都是从如下 4 个抽象类基类中派生出来的。

InputStream/Reader: 所有的输入流的基类，前者是字节输入流，后者是字符输入流。
OutputStream/Writer: 所有输出流的基类，前者是字节输出流，后者是字符输出流。

### 语法糖
#### 什么是语法糖？  
语法糖（Syntactic sugar） 代指的是编程语言为了方便程序员开发程序而设计的一种特殊语法，这种语法对编程语言的功能并没有影响。实现相同的功能，基于语法糖写出来的代码往往更简单简洁且更易阅读。


