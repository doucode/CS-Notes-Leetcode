# 树
104[二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)
```java
    //104 树的高度
    //给定一个二叉树，找出其最大深度。
    //二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    //说明:叶子节点是指没有子节点的节点
    //示例：
    //给定二叉树 [3,9,20,null,null,15,7]
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //返回它的最大深度3 。
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
 ```
 
110.[平衡二叉树](https://leetcode-cn.com/problems/balanced-binary-tree/description/)
```java
    //Balanced Binary Tree110 判断是否为平衡树
    //给定一个二叉树，判断它是否是高度平衡的二叉树。
    //本题中，一棵高度平衡二叉树定义为：
    //一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
    //示例
    //输入：root = [3,9,20,null,null,15,7]
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //输出：true
    private boolean result = true;
    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }
    public int maxDepth(TreeNode root) {
        if (root == null) 
            return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1)
            result = false;    //大于1 返回false
        return Math.max(l, r) + 1; 
    }
```
  
 
543.[二叉树的直径](https://leetcode-cn.com/problems/diameter-of-binary-tree/description/)
```java
    //Diameter of Binary Tree 543 两节点的最长路径
    //给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意
    //两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
    //示例 :
    //给定二叉树
    //      1
    //         / \
    //        2   3
    //       / \
    //      4   5
    //返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    public int depth(TreeNode root) {
        if (root == null) 
            return 0;
        int l = depth(root.left);
        int r = depth(root.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }
```
 
226.[翻转二叉树](https://leetcode-cn.com/problems/invert-binary-tree/description/)
```java
    //反转树 Invert Binary Tree 226
    //翻转一棵二叉树。
    //示例：
    //输入：
    //     4
    //   /   \
    //  2     7
    // / \   / \
    //1   3 6   9

    //输出：
    //     4
    //   /   \
    //  7     2
    // / \   / \
    //9   6 3   1
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = root.left;// 后面的操作会改变 left 指针，因此先保存下来
        root.left = invertTree(root.left);
        root.right = invertTree(left);
        return root;
    }
``` 

617.[合并二叉树](https://leetcode-cn.com/problems/merge-two-binary-trees/description/)
```java
    //归并两棵树 Merge Two Binary Trees 617
    //将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加
    //作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
    //输入:
    //	Tree 1                     Tree 2
    //          1                         2
    //         / \                       / \
    //        3   2                     1   3
    //       /                           \   \
    //      5                             4   7
    //输出:
    //合并后的树:
    //	     3
    //	    / \
    //	   4   5
    //	  / \   \
    //	 5   4   7
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
```


112.[路径总和](https://leetcode-cn.com/problems/path-sum/description/)
```java
    //判断路径和是否等于一个数 Path Sum 112
    //给你二叉树的根节点root 和一个表示目标和的整数targetSum ，判断该树中是否存在
    //根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
    //Given the below binary tree and sum = 22,
    //              5
    //             / \
    //            4   8
    //           /   / \
    //          11  13  4
    //         /  \      \
    //        7    2      1
    //return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.left == null && root.right == null && root.val == sum)
            return true;
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);
    }
```

437.[路径总和 III](https://leetcode-cn.com/problems/path-sum-iii/description/)
```java
    //437统计路径和等于一个数的路径数量  Path Sum III
    //给定一个二叉树，它的每个结点都存放着一个整数值。
    //找出路径和等于给定数值的路径总数。
    //路径不需要从根节点开始，也不需要在叶子节点结束，
    //但是路径方向必须是向下的（只能从父节点到子节点）
    //root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
    //      10
    //     /  \
    //    5   -3
    //   / \    \
    //  3   2   11
    // / \   \
    //3  -2   1
    //返回 3。和等于 8 的路径有:
    //
    //1.  5 -> 3
    //2.  5 -> 2 -> 1
    //3.  -3 -> 11

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int ret = pathSumStartWithRoot(root, sum)
                + pathSum(root.left, sum) + pathSum(root.right, sum);
        return ret;
    }
    private int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        if (root.val == sum)
            ret++;
        ret += pathSumStartWithRoot(root.left, sum - root.val)
                + pathSumStartWithRoot(root.right, sum - root.val);
        return ret;
    }
```

572.[另一个树的子树](https://leetcode-cn.com/problems/subtree-of-another-tree/description/)
```java
    //子树  Subtree of Another Tree 572
    //给定两个非空二叉树 s 和 t，检验s 中是否包含和 t 具有相同结构和节点值的子树。
    // s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
    //
    //示例 1:
    //给定的树 s:
    //
    //     3
    //    / \
    //   4   5
    //  / \
    // 1   2
    //给定的树 t：
    //   4
    //  / \
    // 1   2
    //返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

    //示例 2:
    //给定的树 s：
    //     3
    //    / \
    //   4   5
    //  / \
    // 1   2
    //    /
    //   0

    //给定的树 t：
    //   4
    //  / \
    // 1   2
    //返回 false。
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        return isSubtreeWithRoot(s, t)
                || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private boolean isSubtreeWithRoot(TreeNode s, TreeNode t) {
        if (t == null && s == null)
            return true;
        if (t == null || s == null)
            return false;
        if (t.val != s.val)
            return false;
        return isSubtreeWithRoot(s.left, t.left)
                && isSubtreeWithRoot(s.right, t.right);
    }
```

.[]()
```java

```

.[]()
```java

```
