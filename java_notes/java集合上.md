[source](https://github.com/Snailclimb/JavaGuide/blob/main/docs/java/collection/java-collection-questions-01.md)
## 集合概述

### Java 集合概览
Java 集合， 也叫作容器，主要是由两大接口派生而来：一个是 Collection接口，主要用于存放单一元素；另一个是 Map 接口，主要用于存放键值对。对于Collection 接口，下面又有三个主要的子接口：List、Set 和 Queue。

![](https://camo.githubusercontent.com/db8ac1b473b20570f0c55c0ba097b9a41873419c05c3f1ab6861036a2e67efc8/68747470733a2f2f67756964652d626c6f672d696d616765732e6f73732d636e2d7368656e7a68656e2e616c6979756e63732e636f6d2f6769746875622f6a61766167756964652f6a6176612f636f6c6c656374696f6e2f6a6176612d636f6c6c656374696f6e2d6869657261726368792e706e67)

### 说说 List, Set, Queue, Map 四者的区别？
- List(对付顺序的好帮手): 存储的元素是有序的、可重复的。  
- Set(注重独一无二的性质): 存储的元素是无序的、不可重复的。  
- Queue(实现排队功能的叫号机): 按特定的排队规则来确定先后顺序，存储的元素是有序的、可重复的。  
- Map(用 key 来搜索的专家): 使用键值对（key-value）存储，类似于数学上的函数 y=f(x)，"x" 代表 key，"y" 代表 value，key 是无序的、不可重复的，value 是无序的、可重复的，每个键最多映射到一个值。

## Collection 子接口之 List
### ArrayList 与 LinkedList 区别?
- 是否保证线程安全： ArrayList 和 LinkedList 都是不同步的，也就是不保证线程安全；  
- 底层数据结构： ArrayList 底层使用的是 Object 数组；LinkedList 底层使用的是 双向链表 数据结构
- 插入和删除是否受元素位置的影响：
  - ArrayList 采用数组存储，
  - LinkedList 采用链表存储
- 是否支持快速随机访问： LinkedList 不支持高效的随机元素访问，而 ArrayList（实现了RandomAccess接口） 支持。快速随机访问就是通过元素的序号快速获取元素对象(对应于get(int index)方法)。
- 内存空间占用： ArrayList 的空 间浪费主要体现在在 list 列表的结尾会预留一定的容量空间，而 LinkedList 的空间花费则体现在它的每一个元素都需要消耗比 ArrayList 更多的空间

[ArrayList 扩容机制分析](https://javaguide.cn/java/collection/arraylist-source-code.html#_3-1-%E5%85%88%E4%BB%8E-arraylist-%E7%9A%84%E6%9E%84%E9%80%A0%E5%87%BD%E6%95%B0%E8%AF%B4%E8%B5%B7)

## Collection 子接口之 Set


