## 集合
java集合框架如下：
![](https://camo.githubusercontent.com/db8ac1b473b20570f0c55c0ba097b9a41873419c05c3f1ab6861036a2e67efc8/68747470733a2f2f67756964652d626c6f672d696d616765732e6f73732d636e2d7368656e7a68656e2e616c6979756e63732e636f6d2f6769746875622f6a61766167756964652f6a6176612f636f6c6c656374696f6e2f6a6176612d636f6c6c656374696f6e2d6869657261726368792e706e67)

List,Set,Queue,Map

### Collection 子接口 List
#### ArrayList和Vector的区别
ArrayList是List主要实现类，底层使用Object[]存储，适用于频繁的查找工作，线程不安全  
Vector是List古老实现类，底层使用Object[]存储，线程安全

#### ArrayList和LinkedList的区别
- 两者都不是线程安全的
- `ArrayList`底层数据用的是Object数组，`LinkedList`底层数据是**双向链表**数据结构
- LinkedList不支持高效的随机元素访问，ArrayList可以元素的序号快速访问
- LinkedList的每一个元素比ArrayList消耗更多的空间

#### [ArrayList扩容机制](https://javaguide.cn/java/collection/arraylist-source-code.html#_3-1-%E5%85%88%E4%BB%8E-arraylist-%E7%9A%84%E6%9E%84%E9%80%A0%E5%87%BD%E6%95%B0%E8%AF%B4%E8%B5%B7)

### Collection 子接口 Set

#### 比较HashSet，LinkedHashSet，TreeSet 三者的异同
- `HashSet`,`LinkedHashSet`和`TreeSet`都是Set接口的实现类，都能保证元素的唯一，都不是线程安全的。
- 三者底层数据结构不同，HashSet底层数据结构是哈希表(基于HashMap实现)；LinkedHashSet底层数据结构是链表和哈希表，元素插入取出遵循FIFO；
TreeSet底层数据结构是红黑树，元素是有序的，排序的方式有自然排序和定制排序。
- 三者应用场景不同，HashSet用于不需要保证插入和取出顺序的场景；LinkedHashSet用于保证元素插入取出满足FIFO的场景；TreeSet用于支持对元素
自定义排序的场景。

### Collection 子接口 Queue
#### Queue和Deque的区别
`Queue`是单端队列，只能从一端插入元素，从另一端删除元素，实现**先进先出(FIFO)**原则  
`Deque`是双端队列，队列两端均可插入删除元素

#### PriorityQueue
PriorityQueue的元素出队顺序是与优先级相关的，总是优先级高的元素先出队

- `PriorityQueue`是用**二叉堆**的数据结构实现的，底层使用可变长的数组来存储数据
- `PriorityQueue`通过堆元素的上浮和下沉，实现了在O(logn)的时间复杂度中插入元素和删除堆顶元素
- `PriorityQueue`是非线程安全的，不能存储`NULL`和`non-comparable`的对象
- `PriorityQueue`默认是小顶堆，但可以接收一个`Comparator`作为构造参数来自定义元素优先级的先后。


[参考](https://github.com/Snailclimb/JavaGuide/blob/main/docs/java/collection/java-collection-questions-01.md)