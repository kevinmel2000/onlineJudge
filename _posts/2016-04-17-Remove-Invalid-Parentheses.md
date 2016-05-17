---
layout: post
author: delbao
title: Remove Invalid Parentheses
tag: leetcode
---

https://leetcode.com/discuss/67919/java-optimized-dfs-solution-3-ms
要点：因为这题要输出所有可能的最少删除组合，所以需要用dfs类似combination的算法。其实这题和generate parentheses的结构类似。以下几个要点
 
- dfs的参数：除了common的，特殊于此题的有diff，openN，closeN（后两者和generate算法的n是一样的意思）
- 如何初始化？维护一个count，如果<0，那么需要closeN-1，如果最终count<0，说明无论如何删除，都不可能’(‘>’)’。
- dedup：和subset sum的dedup类似。如果加入一个’(‘或者’)’，相同的一串要在同一层加入，如果没有都加入，在两个分支会有重复：对于加入该字符的分支，下一个 dfs不会没有加入该字符的分支，dfs下一层不会在同一位置加入相同的字符 。。。。注意，用增量循环而不要修改diff和start，因为另一个分支还需要原始值

