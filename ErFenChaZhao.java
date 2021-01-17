public class ErFenChaZhao {
    //正常实现
    //Input : [1,2,3,4,5]
    //key : 3
    //return the index : 2
    //时间复杂度 O(logN)
    public int binarySearch(int[] nums, int key) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (nums[m] == key) {
                return m;
            } else if (nums[m] > key) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

    //变种
    public int binarySearch(int[] nums, int key) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= key) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    //69 Sqrt(x)
    //求开方
    //Input: 4
    //Output: 2
    //
    //Input: 8
    //Output: 2
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1, h = x;
        while (l <= h) {
            int m = l + (h - l) / 2;
            int sqrt = x / m;
            if (sqrt == m) {
                return m;
            } else if (m > sqrt) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return h;
    }

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

    //540 Single Element in a Sorted Array
    //题目描述：一个有序数组只有一个数不出现两次，找出这个数。
    //Input: [1, 1, 2, 3, 3, 4, 4, 8, 8]
    //Output: 2
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }

    //278 First Bad Version
    //题目描述：给定一个元素 n 代表有 [1, 2, ..., n] 版本，在第 x 位置开始出现错误版本，
    // 导致后面的版本都错误。可以调用 isBadVersion(int x) 知道某个版本是否错误，
    // 要求找到第一个错误的版本。
    public int firstBadVersion(int n) {
        int l = 1, h = n;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (isBadVersion(mid)) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    //153 Find Minimum in Rotated Sorted Array
    //Input: [3,4,5,1,2],
    //Output: 1
    public int fineMin(int[] nums) {
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
        int last findFirst(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }
    private int findFirst(int[] nums, int target) {
        int l = 0, h = nums.length;
        while(l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
