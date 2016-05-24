---
layout: post
author: delbao
title: Balanced Binary Tree
tag: leetcode
---

这题用recursive方法做非常trivial就不说了。试试怎么用itarative的方法，基本就是postorder traversal，局部子树的height可以存在结点map里。在访问结点的时候更新。
postorder iterative traversal的记忆法：第一个if是pre在上层，第二个if是pre是cur的left，最后的else是访问和出栈。

{% gist bf99b99cf26d9a231936748c89f96b69 110 Balanced Binary Tree.py %}

