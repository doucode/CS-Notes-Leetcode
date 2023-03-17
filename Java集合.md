# Java集合
## Java集合概览
Java 集合， 也叫作容器，主要是由两大接口派生而来：一个是 Collection接口，主要用于存放单一元素；
另一个是 Map 接口，主要用于存放键值对。对于Collection 接口，下面又有三个主要的子接口：List、Set 和 Queue

### List, Set, Queue, Map 四者的区别
- List: 存储的元素是有序的、可重复的。
- Set: 存储的元素是无序的、不可重复的。
- Queue: 按特定的排队规则来确定先后顺序，存储的元素是有序的、可重复的。
- Map: 使用键值对（key-value）存储，key 是无序的、不可重复的，value 是无序的、可重复的，每个键最多映射到一个值

### 集合框架底层数据结构
`ArrayList`： Object[] 数组  
`Vector`：Object[] 数组  
`LinkedList`： 双向链表(JDK1.6之前为双向循环链表，JDK1.7取消了循环)

`HashSet`(无序，唯一): 基于 HashMap 实现的，底层采用 HashMap 来保存元素。  
`LinkedHashSet`: 是 HashSet 的子类，并且其内部是通过 LinkedHashMap 来实现的。   
`TreeSet`(有序，唯一): 红黑树(自平衡的排序二叉树)。

`PriorityQueue`: Object[] 数组来实现二叉堆  
`ArrayQueue`: Object[] 数组 + 双指针  

`HashMap`： JDK1.8 之前 HashMap 由数组+链表组成的，数组是 HashMap 的主体，链表则是主要为了解决哈希冲突而存在的（“拉链法”解决冲突）。
JDK1.8 以后在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为 8）（将链表转换成红黑树前会判断，
如果当前数组的长度小于 64，那么会选择先进行数组扩容，而不是转换为红黑树）时，将链表转化为红黑树，以减少搜索时间  
`LinkedHashMap`：继承自 HashMap，所以它的底层仍然是基于拉链式散列结构即由数组和链表或红黑树组成。
另外，LinkedHashMap 在上面结构的基础上，增加了一条双向链表，使得上面的结构可以保持键值对的插入顺序。
同时通过对链表进行相应的操作，实现了访问顺序相关逻辑。  
`Hashtable`： 数组+链表组成的，数组是 Hashtable 的主体，链表则是主要为了解决哈希冲突而存在的
`TreeMap`： 红黑树（自平衡的排序二叉树）

### 为什么要使用集合？
当我们需要保存一组类型相同的数据的时候，我们应该是用一个容器来保存，这个容器就是数组，但是，使用数组存储对象具有一定的弊端，
因为我们在实际开发中，存储的数据的类型是多种多样的，于是，就出现了“集合”，集合同样也是用来存储多个数据的。  

数组的缺点是一旦声明之后，长度就不可变了；同时，声明数组时的数据类型也决定了该数组存储的数据的类型；而且，数组存储的数据是有序的、可重复的，特点单一。 
但是集合提高了数据存储的灵活性，Java 集合不仅可以用来存储不同类型不同数量的对象，还可以保存具有映射关系的数据。

## List
### ArrayList 和 Vector 的区别?
ArrayList 是 List 的主要实现类，底层使用 Object[]存储，适用于频繁的查找工作，线程不安全 ；  
Vector 是 List 的古老实现类，底层使用Object[] 存储，线程安全的。#

### ArrayList 与 LinkedList 区别
- ArrayList 和 LinkedList 都是不同步的，也就是不保证线程安全
- ArrayList 底层使用的是 Object 数组；LinkedList 底层使用的是 双向链表 数据结构
- ArrayList 采用数组存储，所以插入和删除元素的时间复杂度受元素位置的影响。LinkedList 采用链表存储，所以，如果是在头尾插入或者删除元素不受元素位置的影响
- ArrayList（实现了RandomAccess接口)支持随机元素访问, LinkedList 不支持高效的随机元素访问
- ArrayList 的空间浪费主要体现在在list列表的结尾会预留一定的容量空间，而LinkedList的每一个元素都需要消耗比ArrayList更多的空间

## Set
### Comparable 和 Comparator 的区别
- comparable 接口实际上是出自java.lang包 它有一个 compareTo(Object obj)方法用来排序
- comparator接口实际上是出自 java.util 包它有一个compare(Object obj1, Object obj2)方法用来排序

需要对一个集合使用自定义排序时，我们就要重写compareTo()方法或compare()方法

### HashSet、LinkedHashSet 和 TreeSet 三者的异同
- 都是 Set 接口的实现类，都能保证元素唯一，并且都不是线程安全的。
- 底层数据结构不同。HashSet 的底层数据结构是哈希表（基于 HashMap 实现）。 
LinkedHashSet 的底层数据结构是链表和哈希表，元素的插入和取出顺序满足 FIFO。
TreeSet 底层数据结构是红黑树，元素是有序的，排序的方式有自然排序和定制排序。
- 三者的应用场景不同。 HashSet 用于不需要保证元素插入和取出顺序的场景，LinkedHashSet 用于保证元素的插入和取出顺序满足 FIFO 的场景，
TreeSet 用于支持对元素自定义排序规则的场景。

### HashSet 如何检查重复
在 JDK1.8 中，实际上无论HashSet中是否已经存在了某元素，HashSet都会直接插入，只是会在add()方法的返回值处告诉我们插入前是否存在相同元素。

## Queue
### Queue 与 Deque 的区别
Queue 是单端队列，只能从一端插入元素，另一端删除元素，实现上一般遵循 先进先出（FIFO） 规则。  
Deque 是双端队列，在队列的两端均可以插入或删除元素。

### ArrayDeque 与 LinkedList 的区别  
ArrayDeque 和 LinkedList 都实现了 Deque 接口，两者都具有队列的功能  
- ArrayDeque 是基于可变长的数组和双指针来实现，而 LinkedList 则通过链表来实现。
- ArrayDeque 不支持存储 NULL 数据，但 LinkedList 支持。
- ArrayDeque 插入时可能存在扩容过程, 不过均摊后的插入操作依然为 O(1)。虽然 LinkedList 不需要扩容，但是每次插入数据时均需要申请新的堆空间，均摊性能相比更慢。

###  PriorityQueue
与 Queue 的区别在于元素出队顺序是与优先级相关的，即总是优先级最高的元素先出队。

PriorityQueue 利用了二叉堆的数据结构来实现的，底层使用可变长的数组来存储数据  
PriorityQueue 通过堆元素的上浮和下沉，实现了在 O(logn) 的时间复杂度内插入元素和删除堆顶元素。  
PriorityQueue 是非线程安全的，且不支持存储 NULL 和 non-comparable 的对象。  
PriorityQueue 默认是小顶堆，但可以接收一个 Comparator 作为构造参数，从而来自定义元素优先级的先后。

## Map
### HashMap 和 Hashtable 的区别
- HashMap 是非线程安全的，Hashtable 是线程安全的(要保证线程安全就使用 ConcurrentHashMap)
- HashMap 可以存储 null 的 key 和 value，但 null 作为键只能有一个，null 作为值可以有多个；Hashtable 不允许有 null 键和 null 值，否则会抛出 NullPointerException
- HashMap 默认的初始化大小为 16。之后每次扩充，容量变为原来的 2 倍。Hashtable 默认的初始大小为 11，之后每次扩充，容量变为原来的 2n+1。
- 底层数据结构： JDK1.8 以后的 HashMap 在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为 8）时，将链表转化为红黑树 
（将链表转换成红黑树前会判断，如果当前数组的长度小于 64，那么会选择先进行数组扩容，而不是转换为红黑树），以减少搜索时间

### HashMap 和 TreeMap 区别
TreeMap 实现了NavigableMap接口让 TreeMap 有了对集合内元素的搜索的能力，实现了SortedMap 接口。让 TreeMap 有了对集合中的元素根据键排序的能力

### HashMap 的底层实现
JDK1.8 之前 HashMap 底层是 数组和链表 结合在一起使用也就是 链表散列。

### ConcurrentHashMap 和 Hashtable 的区别
- JDK1.7 的 ConcurrentHashMap 底层采用 分段的数组+链表 实现，JDK1.8 采用的数据结构跟 HashMap1.8 的结构一样，数组+链表/红黑二叉树。Hashtable 和 JDK1.8 之前的 HashMap 的底层数据结构类似都是采用 数组+链表 的形式，数组是 HashMap 的主体，链表则是主要为了解决哈希冲突而存在的
- 实现线程安全的方式（重要）：在 JDK1.7 的时候，ConcurrentHashMap 对整个桶数组进行了分割分段(Segment，分段锁)，每一把锁只锁容器其中一部分数据（下面有示意图），多线程访问容器里不同数据段的数据，就不会存在锁竞争，提高并发访问率。到了 JDK1.8 的时候，ConcurrentHashMap 已经摒弃了 Segment 的概念，而是直接用 Node 数组+链表+红黑树的数据结构来实现，并发控制使用 synchronized 和 CAS 来操作。（JDK1.6 以后 synchronized 锁做了很多优化） 整个看起来就像是优化过且线程安全的 HashMap，虽然在 JDK1.8 中还能看到 Segment 的数据结构，但是已经简化了属性，只是为了兼容旧版本；Hashtable(同一把锁) :使用 synchronized 来保证线程安全，效率非常低下。当一个线程访问同步方法时，其他线程也访问同步方法，可能会进入阻塞或轮询状态，如使用 put 添加元素，另一个线程不能使用 put 添加元素，也不能使用 get，竞争会越来越激烈效率越低。

### ConcurrentHashMap 线程安全的具体实现方式/底层具体实现
[具体实现](https://javaguide.cn/java/collection/java-collection-questions-02.html)

### JDK 1.7 和 JDK 1.8 的 ConcurrentHashMap 实现有什么不同？
- 线程安全实现方式 ：JDK 1.7 采用 Segment 分段锁来保证安全， Segment 是继承自 ReentrantLock。JDK1.8 放弃了 Segment 分段锁的设计，采用 Node + CAS + synchronized 保证线程安全，锁粒度更细，synchronized 只锁定当前链表或红黑二叉树的首节点。
- Hash 碰撞解决方法 : JDK 1.7 采用拉链法，JDK1.8 采用拉链法结合红黑树（链表长度超过一定阈值时，将链表转换为红黑树）。
- 并发度 ：JDK 1.7 最大并发度是 Segment 的个数，默认是 16。JDK 1.8 最大并发度是 Node 数组的大小，并发度更大。#
