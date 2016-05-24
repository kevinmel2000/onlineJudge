---
layout: post
author: delbao
title: Surrounded Regions
tag: leetcode
---

要点
 
- 之所以从边上开始dfs/bfs，是因为中间的点是没法直接判断是否被包围的，而从边上走，可以立刻判断点是连通的。
- 这题不需要visited，直接用board上的mark来判断，因为如果是’X’，本来就不继续了，而如果是’O’。只有被mark了，才确定是通的，也就是visited，而没mark的话，从其他路径还要继续判断。
 
dfs对大size会有Runtime Error：stack overflow了，因为dfs最坏深度可能是整个矩阵的size。所以只能用bfs


{% gist bf99b99cf26d9a231936748c89f96b69 130 Surrounded Regions.py %}
