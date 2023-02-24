## 面向对象

### 对象的相等和引用相等的区别
- 对象的相等一般比较内存中存放的内容是否相等
- 引用相等比较的是指向内存的地址是否相等

### 面向对象的三大特征
**封装**：封装是指把一个对象的状态信息（也就是属性）隐藏在对象内部，不允许外部对象直接访问对象的内部信息。但是可以提供一些可被外部访问的方法。  
**继承**  
- 子类拥有父类所有的属性和方法，但父类的私有属性和私有方法不可访问
- 子类可以拥有自己的属性和方法，对父类进行扩展
- 子类可以以自己的方法实现父类方法  

**多态**：表示一个对象具有多种形态，具体表现为父类的引用指向子类的实例。  
多态的特点：  
- 对象类型和引用类型具有继承（类）/实现（接口）的关系。
- 引用类型发出的方法调用的到底是哪个类的方法，只有在程序运行期间才能确定
- 多态不能调用"只在子类存在但父类没有"的方法
- 如果子类重写了父类的方法，则调用的是子类方法，否则调用的是父类方法。

### 接口和抽象类
共同点：  
- 都不能被实例化
- 都可以包含抽象方法
- 都可以默认实现的方法

不同点：  
- 一个类只可以继承一个抽象类，但可以实现多个接口
- 接口中的`成员变量`只能用`public static final`修饰，必须有初始值且不能被修改，抽象类的成员变量默认为default，可被子类重新定义和修改
- 接口主要用于对类的行为进行约束，实现了某个接口就具有了对应的行为。抽象类主要用于代码复用，强调的是从属关系

### 浅拷贝，深拷贝，引用拷贝
浅拷贝：在堆中创建一个对象，如果原对象内部属性是引用类型，浅拷贝会直接复制内部对象的内存地址，也就是说拷贝对象和原对象共用一个内部对象  
深拷贝：完全复制整个对象，包括原对象所包含的内部对象  
引用拷贝：对引用地址的拷贝，指向原对象的内部对象

## Java常见类
### Object
Object是所有类的父类。

### == 和 equals 的区别
`==`:  
- 对于基本数据类型，比较的是值
- 对于引用数据类型，比较的是内存地址

`equals()`不能用于比较基本数据类型，是`Object`类的方法，因此所有类都有`equals()`方法
 
### hashcode()
`hashcode()`定义在SDK的Object类中，所以所有的类都有此方法。`hashcode()`是本地方法，是用来将类的内存地址转换为整数之后返回。

- 如果两个对象的hashcode()相等，两个对象不一定相等(哈希碰撞)
- 两个对象hashcode()相等且equals()返回true，两者相等
- 两个对象hashcode()不等，则两者不相等

## String StringBuilder StringBuffer
### 三者的区别
**可变性**  
`String`是不可变的  
`StringBuilder`,`StringBuffer`都继承了`AbstractStringBuilder`类，`AbstractStringBuilder`类使用了字符数组来保存字符串，没有用
`final`,`static`修饰。它还提供了修改字符串的方法，如`append`方法
```java
abstract class AbstractStringBuilder implements Appendable, CharSequence {
    char[] value;
    public AbstractStringBuilder append(String str) {
        if (str == null)
            return appendNull();
        int len = str.length();
        ensureCapacityInternal(count + len);
        str.getChars(0, len, value, count);
        count += len;
        return this;
    }
    //...
}
```  
**线程安全性**  
`String`中的对象是不可变的，可以理解为常量，是线程安全的。`AbstractStringBuilder`类定义了一些操作字符串的方法，如 `expandCapacity、
append、insert、indexOf`，`StringBuffer`对调用的方法加了同步锁，是线程安全的; `StringBuilder`没有，是非线程安全的。

**性能**  
每次对`String`对象进行改变时，会生成新的`String`对象；而改变`StringBuffer`只会对对戏本身改变，`StringBuilder`比`StringBuffer`有10%～
15%的性能提升，却有线程安全的风险。

三者使用的总结：  
- 操作少量数据：用String  
- 单线程操作字符串缓冲区下大量数据：用StringBuilder
- 多线程操作字符串缓冲区下大量数据：用StringBuffer

#### 字符串拼接
`+`,`+=`是Java专门为String类重载过的运算符。



[参考](https://github.com/Snailclimb/JavaGuide/blob/main/docs/java/basis/java-basic-questions-02.md)