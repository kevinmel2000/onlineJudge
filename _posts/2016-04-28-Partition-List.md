---
layout: post
author: delbao
title: Partition List
tag: leetcode
---

要点：这题的循环条件要用cur.next，why？如果用cur，要维护两个pre，比较麻烦，而用cur.next，cur就是pre了。另一个好处是如果cur.next为null，只有一个结点不需要移动任何结点。
还有一个特殊条件是判断last==cur，这样不移动。凡是有边界指针的题，都需要考虑这个（比如insertion sort list）。这里就有问题，为什么不能和不相等的情况用同样的code path呢？因为移动结点的假设是将待移动结点（即cur.next）的next连上last.next，如果last==cur，那么待移动结点和last.next是同一个，这样就接成自环了。
错误点：
 
- cur的初始点为dummy，而不是head
- 别忘了交换结点之后lasat指针的移动

{% gist bf99b99cf26d9a231936748c89f96b69 86 Partition List.py %}
