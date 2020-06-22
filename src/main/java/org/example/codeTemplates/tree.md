
#### 树遍历
##### 二叉树遍历
```
class TreeNode {
    int val;
    TreeNode left, right;
}

void traverse(TreeNode root) {
    traverse(root.left);
    traverse(root.right);
}
```

##### N叉树遍历
```
class TreeNode {
    int val;
    TreeNode[] children;
}

void traverse(TreeNode root) {
    for(TreeNode child : root.children) {
        traverse(child)
    }
}
```

##### 将节点值+1
```
void plusOne(TreeNode root) {
    if (root == null) return;
    root.val += 1;
    plusOne(root.left);
    plusOne(root.right);
}
```

##### 判断两棵树是否相同
```
boolean isSameTree(TreeNode root1, TreeNode root2) {
     if (root1 == null && root2 == null) return true; // 都是空树
     if (root1 == null || root2 == null) return false; // 有一颗非空
     if (root1.val != root2.val) return false; // 节点值不一致
     return isSameTree(root1.left, root2.left) && isSameTree(root2.left, root2.right);
}
```

##### bst遍历框架
```
void BST(TreeNode root, int target) {
    if (root.val == target) // do..., 找到了、做什么
    if (root.val < target) BST(root.right, target);
    BST(root.left, target);
}
```

#### 特殊二叉树

`完全二叉树`: 除叶子层所有节点都是靠左排列、其它层的节点都是满的

`满二叉树`: 每一层节点都是满的、是一种特殊的完全二叉树

##### 普通二叉树节点个数

```
public int countNodes(TreeNode root) {
   if (root == null) return 0;
   return 1 + countNodes(root.left) + countNodes(root.right);
}
```