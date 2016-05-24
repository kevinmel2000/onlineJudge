---
layout: post
author: delbao
title: Recover Binary Search Tree
tag: leetcode
---

要点：如果两个交换，那么会有两对顺序相反，或者如果是相邻的交换，那么仅有一对。所以第一次发现逆序更新first和second，第二次只更新second
 
- in order traversal如何track prev？其实和bst找第k个或者前一个都是一个pattern。就是先递归向左，返回后，prev已经更新。然后root变prev，然后递归向右
- 因为python是pass-by-value的，所以prev只能用全局变量，而不能pass around。也不需要返回
 
python实现中的问题：
 
- 首先first和second是global的，在python里，nested function可以读enclosing的变量，但是不能update（update就变成对local变量操作）。所以这题把变量弄成class member
 
{% gist bf99b99cf26d9a231936748c89f96b69 99 Recover Binary Search Tree.py %}
