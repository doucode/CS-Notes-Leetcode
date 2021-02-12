160.[相交链表](https://leetcode-cn.com/problems/intersection-of-two-linked-lists/description/)
```java
//160. Intersection of Two Linked Lists (Easy)
    //编写一个程序，找到两个单链表相交的起始节点。

    //输入：intersectVal= 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
    //输出：Reference of the node with value = 2
    //输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，
    // 链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，
    // 相交节点前有 1 个节点。

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
```

206.[反转链表](https://leetcode-cn.com/problems/reverse-linked-list/description/)
```java
//206. 反转链表
    //反转一个单链表。
    //
    //示例:
    //
    //输入: 1->2->3->4->5->NULL
    //输出: 5->4->3->2->1->NULL
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
```

21.[合并两个有序链表](https://leetcode-cn.com/problems/merge-two-sorted-lists/description/)
```java
//21. 合并两个有序链表
    //将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    //输入：l1 = [1,2,4], l2 = [1,3,4]
    //输出：[1,1,2,3,4,4]
    //示例 2：
    //
    //输入：l1 = [], l2 = []
    //输出：[]
    //示例 3：
    //
    //输入：l1 = [], l2 = [0]
    //输出：[0]
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }
    }
```

83.[删除排序链表中的重复元素](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/description/)
```java
    //83. 删除排序链表中的重复元素
    //给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
    //
    //示例1:
    //
    //输入: 1->1->2
    //输出: 1->2
    //示例2:
    //
    //输入: 1->1->2->3->3
    //输出: 1->2->3
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
```

19.[删除链表的倒数第 N 个结点](https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/description/)
```java
//19. 删除链表的倒数第 N 个结点
    //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    //输入：head = [1,2,3,4,5], n = 2
    //输出：[1,2,3,5]
    //示例 2：
    //
    //输入：head = [1], n = 1
    //输出：[]
    //示例 3：
    //
    //输入：head = [1,2], n = 1
    //输出：[1]
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null){
            return head;
        }

        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
```

24.[两两交换链表中的节点](https://leetcode-cn.com/problems/swap-nodes-in-pairs/description/)
```java
// 24. 两两交换链表中的节点
    // 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    //
    //你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) { //空指针和单节点指针 直接返回
            return head;
        }
        ListNode newHead = head.next;         // newHead为第二个节点
        head.next = swapPairs(newHead.next);  // head后来变成第二结点
        newHead.next = head;                  // newHead变为第一结点
        return newHead;                       //返回 newHead
    }
```

.[]()
```java

```

.[]()
```java

```

.[]()
```java

```

.[]()
```java

```
