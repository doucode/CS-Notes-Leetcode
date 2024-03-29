[source](https://github.com/Snailclimb/JavaGuide/blob/main/docs/java/basis/java-basic-questions-01.md)
## 基础概念与常识

### Java 语言有哪些特点?
1.简单易学  
2.面向对象（封装，继承，多态）  
3.平台无关性  
4.支持多线程  
5.可靠性  
6.安全性  
7.支持网络编程  
8.编译与解释并存  

### JVM vs JDK vs JRE
- Java 虚拟机（JVM）是运行 Java 字节码的虚拟机。  
- JDK 是 Java Development Kit 缩写，它是功能齐全的 Java SDK。它拥有 JRE 所拥有的一切，还有编译器（javac）和工具（如 javadoc 和 jdb）。它能够创建和编译程序。    
- JRE 是 Java 运行时环境。它是运行已编译 Java 程序所需的所有内容的集合，包括 Java 虚拟机（JVM），Java 类库，java 命令和其他的一些基础构件。
但是，它不能用于创建新程序。

### 什么是字节码?采用字节码的好处是什么?
在 Java 中，JVM 可以理解的代码就叫做字节码（即扩展名为 .class 的文件），它不面向任何特定的处理器，只面向虚拟机。

Java 程序从源代码到运行的过程如下图所示：  
![](https://camo.githubusercontent.com/2787b36c8b7086423ee62ddea4dbf085b40b89499a420273716a6abc43494117/68747470733a2f2f67756964652d626c6f672d696d616765732e6f73732d636e2d7368656e7a68656e2e616c6979756e63732e636f6d2f6769746875622f6a61766167756964652f6a6176612f62617369732f6a6176612d636f64652d746f2d6d616368696e652d636f64652e706e67)
我们需要格外注意的是`.class->机器码` 这一步。在这一步 JVM 类加载器首先加载字节码文件，然后通过解释器逐行解释执行，这种方式的执行速度会相对比较慢。而且，有些方法和代码块是经常需要被调用的(也就是所谓的热点代码)，所以后面引进了 JIT（just-in-time compilation） 编译器，而 JIT 属于运行时编译。当 JIT 编译器完成第一次编译后，其会将字节码对应的机器码保存下来，下次可以直接使用。而我们知道，机器码的运行效率肯定是高于 Java 解释器的。这也解释了我们为什么经常会说 Java 是编译与解释共存的语言 。

### 为什么说 Java 语言“编译与解释并存”？
这是因为 Java 语言既具有编译型语言的特征，也具有解释型语言的特征。因为 Java 程序要经过先编译，后解释两个步骤，由 Java 编写的程序需要先经过编译步骤，生成字节码（`.class` 文件），这种字节码必须由 Java 解释器来解释执行。

### Java 和 C++ 的区别?
虽然，Java 和 C++ 都是面向对象的语言，都支持封装、继承和多态，但是，它们还是有挺多不相同的地方：
- Java 不提供指针来直接访问内存，程序内存更加安全
- Java 的类是单继承的，C++ 支持多重继承；虽然 Java 的类不可以多继承，但是接口可以多继承。
- Java 有自动内存管理垃圾回收机制(GC)，不需要程序员手动释放无用内存。
- C ++同时支持方法重载和操作符重载，但是 Java 只支持方法重载（操作符重载增加了复杂性，这与 Java 最初的设计思想不符）。
- ......

## 基本语法

### 移位运算符
在 Java 代码里使用 << 、 >> 和>>>转换成的指令码运行起来会更高效些。  
- `<<` :左移运算符，向左移若干位，高位丢弃，低位补零。`x << 1`,相当于 x 乘以 2(不溢出的情况下)。
- `>>` :带符号右移，向右移若干位，高位补符号位，低位丢弃。正数高位补 0,负数高位补 1。x >> 1,相当于 x 除以 2。
- `>>>` :无符号右移，忽略符号位，空位都以 0 补齐。  
  由于 `double`，`float` 在二进制中的表现比较特殊，因此不能来进行移位操作。
  
**如果移位的位数超过数值所占有的位数会怎样？**
当 int 类型左移/右移位数大于等于 32 位操作时，会先求余（%）后再进行左移/右移操作。也就是说左移/右移 32 位相当于不进行移位操作（32%32=0），左移/右移 42 位相当于左移/右移 10 位（42%32=10）。当 long 类型进行左移/右移操作时，由于 long 对应的二进制是 64 位，因此求余操作的基数也变成了 64。

也就是说：x<<42等同于x<<10，x>>42等同于x>>10，x >>>42等同于x >>> 10。

### 变量

**静态方法为什么不能调用非静态成员?**
这个需要结合 JVM 的相关知识，主要原因如下：  
1.静态方法是属于类的，在类加载的时候就会分配内存，可以通过类名直接访问。而非静态成员属于实例对象，只有在对象实例化之后才存在，需要通过类的实例对象去访问。  
2.在类的非静态成员不存在的时候静态方法就已经存在了，此时调用在内存中还不存在的非静态成员，属于非法操作。

**重载和重写有什么区别？**
>重载就是同样的一个方法能够根据输入数据的不同，做出不同的处理
>
>重写就是当子类继承自父类的相同方法，输入数据一样，但要做出有别于父类的响应时，你就要覆盖父类方法

**重写**

重写发生在运行期，是子类对父类的允许访问的方法的实现过程进行重新编写。

1.方法名、参数列表必须相同，子类方法返回值类型应比父类方法返回值类型更小或相等，抛出的异常范围小于等于父类，访问修饰符范围大于等于父类。  
2.如果父类方法访问修饰符为 private/final/static 则子类就不能重写该方法，但是被 static 修饰的方法能够被再次声明。  
3.构造方法无法被重写

####什么是可变长参数？  
从 Java5 开始，Java 支持定义可变长参数，所谓可变长参数就是允许在调用方法时传入不定长度的参数。就比如下面的这个 printVariable 方法就可以接受 0 个或者多个参数。
```java
public static void method1(String... args) {
//......
        }
```  
另外，可变参数只能作为函数的最后一个参数，但其前面可以有也可以没有任何其他参数。
```java
public static void method2(String arg1, String... args) {
//......
}
```

**遇到方法重载的情况怎么办呢？会优先匹配固定参数还是可变参数的方法呢？**

答案是会优先匹配固定参数的方法，因为固定参数的方法匹配度更高。

## 基本数据类型
### Java 中的几种基本数据
| 基本类型  | 位数 | 字节 | 默认值  | 取值范围                                   |
| :-------- | :--- | :--- | :------ | ------------------------------------------ |
| `byte`    | 8    | 1    | 0       | -128 ~ 127                                 |
| `short`   | 16   | 2    | 0       | -32768 ~ 32767                             |
| `int`     | 32   | 4    | 0       | -2147483648 ~ 2147483647                   |
| `long`    | 64   | 8    | 0L      | -9223372036854775808 ~ 9223372036854775807 |
| `char`    | 16   | 2    | 'u0000' | 0 ~ 65535                                  |
| `float`   | 32   | 4    | 0f      | 1.4E-45 ~ 3.4028235E38                     |
| `double`  | 64   | 8    | 0d      | 4.9E-324 ~ 1.7976931348623157E308          |
| `boolean` | 1    |      | false   | true、false                                |

### 基本类型和包装类型的区别？
- 成员变量包装类型不赋值就是 null ，而基本类型有默认值且不是 null。  
- 包装类型可用于泛型，而基本类型不可以。  
- 基本数据类型的局部变量存放在 Java 虚拟机栈中的局部变量表中，基本数据类型的成员变量（未被 static 修饰 ）存放在 Java 虚拟机的堆中。包装类型属于对象类型，我们知道几乎所有对象实例都存在于堆中。  
- 相比于对象类型， 基本数据类型占用的空间非常小。

### 包装类型的缓存机制
Byte,Short,Integer,Long 这 4 种包装类默认创建了数值 [-128，127] 的相应类型的缓存数据，Character 创建了数值在 [0,127] 范围的缓存数据，Boolean 直接返回 True or False。  
两种浮点数类型的包装类 Float,Double 并没有实现缓存机制。

**所有整型包装类对象之间值的比较，全部使用 equals 方法比较。**

### 自动装箱与拆箱了解吗？原理是什么？
什么是自动拆装箱？  
- 装箱：将基本类型用它们对应的引用类型包装起来；  
- 拆箱：将包装类型转换为基本数据类型；

- Integer i = 10 等价于 Integer i = Integer.valueOf(10)  
- int n = i 等价于 int n = i.intValue();

### 如何解决浮点数运算的精度丢失问题？
`BigDecimal` 可以实现对浮点数的运算，不会造成精度丢失。通常情况下，大部分需要浮点数精确运算结果的业务场景（比如涉及到钱的场景）都是通过 `BigDecimal` 来做的。




