---
layout: post
author: delbao
title: Minimum Height Trees
tag: leetcode
---

要点：这题实质是topological sort。重点是这是对无向图，和有向图的几点区别：
 
- 不需要indegree，因为无向图入度和出度是相同的，所以邻接点的个数就能表示。下一层某结点只需要从adjSet中删除当前层结点即可
- 因为至少有degree 1，所以要这个是下一层的选择条件

{% gist bf99b99cf26d9a231936748c89f96b69 310 Minimum Height Trees.py %}
