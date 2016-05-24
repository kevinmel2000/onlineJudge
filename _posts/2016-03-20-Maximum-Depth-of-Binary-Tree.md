---
layout: post
author: delbao
title: Maximum Depth of Binary Tree 
tag: leetcode
---

简单一题，但是递归结构可以用在很多Binary Tree的题目上（比如LCA）：递归左右子树，然后比较左右返回结果取一返回
 
### Construct Binary Tree from Preorder and Inorder Traversal
### Construct Binary Tree from Inorder and Postorder Traversal
这两道题都是一个思路，比较tricky。以preorder/inorder为例，对于preorder遍历，一个子树对应一个连续的子数组，而首个元素就是root。问题就变成如何在子数组中进一步确定左右子树的边界，这样就可以进一步递归构建左右子树。inorder的序列可以用来找到边界：具体来说，因为无论是inorder还是preorder，子树都是数组中连续的元素，inorder的左右子树的分界点在root，这样如果能找到root的index，就能确定左子树的大小，进而确定在preorder序列里左子树的大小。这就是为什么我们要提前做invert index来存储value到index的map。而offset是用来跟踪当前在inorder序列里的左边界。

{% gist bf99b99cf26d9a231936748c89f96b69 104 Maximum Depth of Binary Tree.py %}
