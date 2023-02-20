[1.两数之和(20688)](https://leetcode-cn.com/problems/two-sum/)

给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。
```
示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。


示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]


示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]
```
```java
class Solution { 
    // 双指针
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length; //一维数组的大
        for (int i = 0; i < n; i++) { // 当 i=n 时 跳出循环
            for (int j = i + 1; j < n; j++){ 
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
```

[3.无重复字符的最长子串(12770)](https://leetcode.cn/problems/longest-substring-without-repeating-characters/)
   给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
```java
class Solution {
    //双指针
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character,Integer> map = new HashMap<>(); // map
        for(int i = 0, j = 0; j < n; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }
}
```

[2.两数相加(11416)](https://leetcode.cn/problems/add-two-numbers/)
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 链表
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }
}
```




[206.反转链表(9080)](https://leetcode-cn.com/problems/reverse-linked-list/)

反转一个单链表。
```
示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
```
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution { 
    // 链表 
    // 头插法
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;   
        while (curr != null) {
            ListNode next = curr.next; // 存储当前的后一个
            curr.next = prev;  // 反转 next指针 指向前一个
            prev = curr;  // prev 后移
            curr = next;  // curr 后移
        }
        return prev;
    }
}
```


[20.有效的括号(9080)](https://leetcode-cn.com/problems/valid-parentheses/)
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
```
示例 1：
输入：s = "()"
输出：true

示例 2：
输入：s = "()[]{}"
输出：true

示例 3：
输入：s = "(]"
输出：false

示例 4：
输入：s = "([)]"
输出：false

示例 5：
输入：s = "{[]}"
输出：true
```
```java
class Solution {
    // 字符串
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character,Character> pairs = new HashMap<Character,Character>() {{ // map
            put(')','(');
            put(']','[');
            put('}','{');
        }};
        
        Deque<Character> stack = new LinkedList<Character>(); //堆栈
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)){
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
```


[9.回文数(7834)](https://leetcode-cn.com/problems/palindrome-number/)

给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。

```
示例 1：
输入：x = 121
输出：true

示例 2：
输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3：
输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。

示例 4：
输入：x = -101
输出：false
```
```java
class Solution {
    // 反转一半数字
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
```



[26. 删除有序数组中的重复项(7817)](https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/)

给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
```

示例 1：
输入：nums = [1,1,2]
输出：2, nums = [1,2]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。

示例 2：
输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
```

[19. 删除链表的倒数第 N 个结点(7322)](https://leetcode.cn/problems/remove-nth-node-from-end-of-list/)
```java
class Solution {
    // 链表 
   //双指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) 
            return head.next;

        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
```



[27. 移除元素(7152)](https://leetcode.cn/problems/remove-element/)
```java
class Solution {
    // 双指针
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != val){
                nums[ans++] = nums[i];
            }
        }
        return ans;
    }
}
```

[5. 最长回文子串(7107)](https://leetcode.cn/problems/longest-palindromic-substring/)
```java

```


[35. 搜索插入位置(7022)](https://leetcode.cn/problems/search-insert-position/)
```java
class Solution {
    // 二分查找
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1, ans = n;
        while (left <= right) {
            int mid = (right - left) / 2  + left;
            if (target <= nums[mid]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
```

[7. 整数反转(7002)](https://leetcode.cn/problems/reverse-integer/)
```java
class Solution {
    // 反转
    public int reverse(int x) {
        long ans = 0;
        while(x != 0){
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        if(ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
        {
            return 0;
        }    
        return (int)ans;
    }
}
```

[34. 在排序数组中查找元素的第一个和最后一个位置(6881)](https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/)
```java
class Solution {
    // 二分查找
    
    public int[] searchRange(int[] nums, int target) {
        return new int[]{find(nums, target, true), find(nums, target, false)};
    }

    public int find(int[] nums, int target, boolean minType) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (minType) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
```

[21. 合并两个有序链表(6739)](https://leetcode.cn/problems/merge-two-sorted-lists/)
```java
class Solution {
    // 链表
    // 递归
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
```

[4. 寻找两个正序数组的中位数(6493)](https://leetcode.cn/problems/median-of-two-sorted-arrays/)
```java

```

[53. 最大子数组和(6425)](https://leetcode.cn/problems/maximum-subarray/)
```java
class Solution {
    //前缀和
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int maxAns = nums[0];
        
        for(int x : nums){
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
```

[14. 最长公共前缀(6304)](https://leetcode.cn/problems/longest-common-prefix/)
```java
class Solution {
    // 字符串
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) 
            return "";
        String str = strs[0];
        // 循环用indexOf和substring
        for(int i = 1; i < strs.length; i++) {
            while(strs[i].indexOf(str) != 0) {
                // 每次substring去掉最后一位
                str = str.substring(0, str.length() - 1);
            }
        }
        return str;
    }
}
```

[13. 罗马数字转整数(6193)](https://leetcode.cn/problems/roman-to-integer/)
```java
class Solution {
    //字符串 Map
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        int ans = 0, n = s.length();
        for(int i = 0; i < n; i++){
            int value = map.get(s.charAt(i));
            if(i < n - 1 && value < map.get(s.charAt(i + 1))){
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
```

[283. 移动零(5952)](https://leetcode.cn/problems/move-zeroes/)
```java
class Solution {
    // 快慢指针
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }
    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
```

[70. 爬楼梯(5860)](https://leetcode.cn/problems/climbing-stairs/)
```java
class Solution {
    //动态规划
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for(int i = 1; i <= n; i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
```


    
