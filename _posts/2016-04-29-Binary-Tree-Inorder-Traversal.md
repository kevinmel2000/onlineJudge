---
layout: post
author: delbao
title: Binary Tree Inorder Traversal
tag: leetcode
---

要点：iteration解法更深入考察了结点指针在binary tree层级间的移动规律。
 
- stack用来记录上层未访问的结点，这样之后还可以访问到。而current指针作为一个indicator，如果为null，表示上层结点对应的左子树已经遍历完了，应该pop。如果不为null，应该入栈变为“上层”结点，继续遍历左子树。
- 当下层左子树遍历完毕，应该访问本结点并且出栈。因为是inorder，出栈并不代表一直向上，而是要继续向右子树开始新的向下。
- 这题的画面感有一直向左下=>上升=>继续右下

{% gist bf99b99cf26d9a231936748c89f96b69 94 Binary Tree Inorder Traversal.py %}

