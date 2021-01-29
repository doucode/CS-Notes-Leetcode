# 热度降序总结刷leetcode
1.[两数之和(9586)](https://leetcode-cn.com/problems/two-sum/)
```java
    //1. 两数之和
    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，
    // 并返回它们的数组下标。
    //输入：nums = [2,7,11,15], target = 9
    //输出：[0,1]
    //解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    public int[] twoSum(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int sum = nums[l] + nums[h];
            if (sum == target) {
                return new int[]{l, h};
            } else if (sum < target) {
                l++;
            } else {
                h--;
            }
        }
        return new int[]{};
    }
```

206.5978[反转链表](https://leetcode-cn.com/problems/reverse-linked-list/)
```java

```

.[]()
```java

```
