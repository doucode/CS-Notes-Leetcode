# leetcode2021
## 双指针
167.[两数之和 II - 输入有序数组](https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/)
```java
    //167 Two Sum II - Input array is sorted
    //有序数组的Two Sum
    //Input: numbers={2, 7, 11, 15}, target=9
    //Output: index1=1, index2=2
    //题目描述：在有序数组中找出两个数，使它们的和为 target。
    //时间复杂度O(N) 空间复杂度O(1)
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null) 
            return null;                          //numbers数组为空，返回空
        int i = 0, j = numbers.length - 1;         //头尾两个指针
        while (i < j) {                           //当i=j时跳出循环
            int sum = numbers[i] + numbers[j];
            if (sum == target) {                 //两数相加判断
                return new int[]{i + 1, j + 1};      //相等
            } else if (sum > target) {
                j--;                    //sum大于target，尾指针前移一位     
            } else {
                i++;                    //sum小于target，头指针后移一位
            }
        }
        return null;
    }
```
633.[平方数之和](https://leetcode-cn.com/problems/sum-of-square-numbers/)
```java
    //633 Sum of Square Numbers
    //两数平方和
    //Input: 5
    //Output: True
    //Explanation: 1 * 1 + 2 * 2 = 5
    public boolean judgeSquareSum(int target) {
        if (target < 0) 
            return false; //target为负数，返回false
        int i = 0, j = (int)Math.sqrt(target); //头指针从0开始，尾指针从target开方取整开始
        while (i <= j) { // 当i > j时 跳出循环
            int sum = i * i + j * j;
            if (sum == target) {
                return true;  
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
```
345.[反转字符串中的元音字母](https://leetcode-cn.com/problems/reverse-vowels-of-a-string/)
```java
    //345 Reverse Vowels of a String
    //反转字符串中的元音字符
    //Given s = "leetcode", return "leotcede".
    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a',
            'e','i','o','u','A','E','I','O','U'));
    public String reverseVowels(String s) {
        if (s == null)
            return null; //s为空，返回空
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) { //i>j时 跳出循环
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;               //前指针不含元音
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;               //后指针不含元音
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
```

680.[验证回文字符串 Ⅱ](https://leetcode-cn.com/problems/valid-palindrome-ii/)
```java
    //680 Valid Palindrome II
    //回文字符串
    //Input: "abca"
    //Output: True
    //Explanation: You could delete the character 'c'.
    //题目描述：可以删除一个字符，判断是否能构成回文字符串。
    public boolean validPalindrome(String s) {
        if (s == null)
            return true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
        }
        return true;
    }
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
```

88.[合并两个有序数组](https://leetcode-cn.com/problems/merge-sorted-array/)
```java
    //88 Merge Sorted Array
    //归并两个有序数组
    //Input:
    //nums1 = [1,2,3,0,0,0], m = 3
    //nums2 = [2,5,6],       n = 3
    //
    //Output: [1,2,2,3,5,6]
    //题目描述：把归并结果存到第一个数组上。
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }

```

141.[环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)
```java
    //141 Linked List Cycle
    //判断链表是否存在环
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode l1 = head, l2 = head.next;
        while (l1 != null && l2 != null && l2.next != null) {
            if (l1 == l2)
                return true;
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }
```

524.[通过删除字母匹配到字典里最长单词](https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/)
```java
    //524 Longest Word in Dictionary through Deleting
    //最长子序列
    //Input:
    //s = "abpcplea", d = ["ale","apple","monkey","plea"]
    //
    //Output:
    //"apple"
    //题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，
    //找出能构成的最长字符串。如果有多个相同长度的结果，返回字典序的最小字符串。
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {
            int l1 = longestWord.length(), l2 = target.length();
            if(l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if(isSubstr(s, target))
                longestWord = target;
        }
        return longestWord;
    }
    private boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}

```
## 二分查找
69.[x 的平方根](https://leetcode-cn.com/problems/sqrtx/description/)
```java
    //实现int sqrt(int x)函数。
    //计算并返回x的平方根，其中x 是非负整数。
    //由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

    //示例 1:
    //输入: 4
    //输出: 2

    //示例 2:
    //输入: 8
    //输出: 2
    //说明: 8 的平方根是 2.82842...,
    //    由于返回类型是整数，小数部分将被舍去。
    public int mySqrt(int x) {
        if (x <= 1)
            return x;
        int l = 1, h = x;
        while (l <= h) {  // l > h 时， 跳出循环
            int m = l + (h - l) / 2;
            int sqrt = x / m;
            if (sqrt == m) {
                return m;
            } else if (sqrt < m) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return h;  //h总是比l小1,返回h
    }
```

744.[寻找比目标字母大的最小字母](https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/)
```java
    //744 Find Smallest Letter Greater Than Target
    //大于给定元素的最小元素
    //Input:
    //letters = ["c", "f", "j"]
    //target = "d"
    //Output: "f"
    //
    //Input:
    //letters = ["c", "f", "j"]
    //target = "k"
    //Output: "c"
    //题目描述：给定一个有序的字符数组 letters 和一个字符 target，
    //要求找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符。
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0, h = n - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < n ? letters[l] : letters[0];
    }
```

540.[有序数组中的单一元素](https://leetcode-cn.com/problems/single-element-in-a-sorted-array/)
```java
    //540 Single Element in a Sorted Array
    //题目描述：一个有序数组只有一个数不出现两次，找出这个数。
    //Input: [1, 1, 2, 3, 3, 4, 4, 8, 8]
    //Output: 2
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--; // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }
```

278.[第一个错误的版本](https://leetcode-cn.com/problems/first-bad-version/)
```java
    //278 First Bad Version
    //题目描述：给定一个元素 n 代表有 [1, 2, ..., n] 版本，在第 x 位置开始出现错误版本，
    // 导致后面的版本都错误。可以调用 isBadVersion(int x) 知道某个版本是否错误，
    // 要求找到第一个错误的版本。
    public int firstBadVersion(int n) {
        int l = 1, h = n;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (isBadVersion(m)) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
```

153.[寻找旋转排序数组中的最小值](https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/description/)
```java
    //153 Find Minimum in Rotated Sorted Array
    //假设按照升序排序的数组在预先未知的某个点上进行了旋转。
    // 例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2]
    //请找出其中最小的元素。
    //Input: [3,4,5,1,2],
    //Output: 1
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
```

34.[在排序数组中查找元素的第一个和最后一个位置](https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
```java
    //34 Find First and Last Position of Element in Sorted Array
    //Input: nums = [5,7,7,8,8,10], target = 8
    //Output: [3,4]
    //
    //Input: nums = [5,7,7,8,8,10], target = 6
    //Output: [-1,-1]
    //题目描述：给定一个有序数组 nums 和一个目标 target，
    //要求找到 target 在 nums中的第一个位置和最后一个位置。
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findFirst(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }
    private int findFirst(int[] nums, int target) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
```

##
