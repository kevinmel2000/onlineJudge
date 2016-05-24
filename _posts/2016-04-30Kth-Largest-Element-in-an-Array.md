---
layout: post
author: delbao
title: Kth Largest Element in an Array
tag: leetcode
---

待总结的要点：
 
- 为什么起始为k-1（or 0 started）要在大端k-kth-1，而起始为k（or 1 started）则为k-kth
    - basic fact：不论从0开始还是从1开始计数，任何2个index的差B-A都是个数（注意A是exlusive的）
    - 所以，如果用0表示第一个元素，每次adjust的时候都要多减1来保持个数-1
- partition为什么对于2个或1个元素都work
    - end要停在当前左侧最后一个位置，因为最后和开头交换只在左侧值
    - 1个元素：end初始就在这个元素，loop从下一个元素开始，所以loop是直接skip的。最后e==i，再做identity swap，结果一样
    - 2个元素：loop一次，e可能在第一个或第二个位置，这个和>2的情况是一样的
- 为什么recursion不用检查边界条件？首先k一定大于输入数组个数，所以一定有解。同时k根据sub-array的元素个数调整，所以sub-array的边界不会出现low>high的情况
- low,m-1和m+1,high不会出现2个元素的infinite loop
- 这题千万别用randomPartition，没法debug

{% gist bf99b99cf26d9a231936748c89f96b69 215 Kth Largest Element in an Array.py %}
