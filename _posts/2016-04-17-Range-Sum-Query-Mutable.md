---
layout: post
author: delbao
title: Range Sum Query - Mutable
tag: leetcode
---

要点：一道segment tree题，segment tree的结构要点是完全binary tree的下一层二分上一层的区间。对于这道题，要实现buildTree, sumQuery和update methods。
 
- buildTree: 注意叶结点实际存的是单个元素，所以这是一个post-order的bottom up构建。累加左右子树的结果并返回。创建root在最后，所以别忘了连接左右子树
- sumQuery：query实际是一个区间比较和累加的过程（这个无论是sum还是minimum query都是一样的）：segment tree的结点本身的区间和查询区间的比较，如果tree range在query range范围内，得到一个有效累加结果返回。如果overlapping，继续向左右子树查找：注意，查询区间是不变的。因为叶子是单个元素，所以总会找到全部有效区间
- update：一个错误是更新输入数组本身：因为在buildTree的时候已经把单个元素信息存在叶子结点了，所以更新叶子结点，并重新计算受影响的上层结点即可（这个和buildTree的过程是一样的，唯一差别就是更新结点不在区间，直接返回区间当前值即可）
 
错误点：（EDIT：4/23/16）
 
- 因为上层要重新计算和，update不在范围内要返回当前Node的val，而不是0。

{% gist bf99b99cf26d9a231936748c89f96b69 307 Range Sum Query - Mutable.py %}
