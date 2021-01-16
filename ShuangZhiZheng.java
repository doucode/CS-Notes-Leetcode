
import java.util.HashSet;
import java.util.*;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }

public class ShuangZhiZheng {

    //167 Two Sum II - Input array is sorted
    //有序数组的Two Sum
    //Input: numbers={2, 7, 11, 15}, target=9
    //Output: index1=1, index2=2
    //题目描述：在有序数组中找出两个数，使它们的和为 target。
    //时间复杂度O(N) 空间复杂度O(1)
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null)
            return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j};
            } else if (sum < target) {
                i++:
            } else {
                j--;
            }
        }
        return null;
    }

    //633 Sum of Square Numbers
    //两数平方和
    //Input: 5
    //Output: True
    //Explanation: 1 * 1 + 2 * 2 = 5
    public boolean judgeSquareSum(int target) {
        if (target < 0)
            return false;
        int i = 0, j = (int)Math.sqrt(target);
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == target) {
                return true;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    //345 Reverse Vowels of a String
    //反转字符串中的元音字符
    //Given s = "leetcode", return "leotcede".
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        if (s == null)
            return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }

    //680 Valid Palindrome II
    //回文字符串
    //Input: "abca"
    //Output: True
    //Explanation: You could delete the character 'c'.
    //题目描述：可以删除一个字符，判断是否能构成回文字符串。
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
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

    //141 Linked List Cycle
    //判断链表是否存在环
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode l1 = head, l2 = head.next;
        while (l1 != null && l2 != null && l2.next != null) {
            if (l1 == l2) {
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }

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
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
            if (isSubstr(s, target)) {
                longestWord = target;
            }
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
