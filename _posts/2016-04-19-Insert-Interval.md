---
layout: post
author: delbao
title: Insert Interval
tag: leetcode
---

虽然现在看算法很简单，但是实现比较tricky，另外算法背后的逻辑比较不容易想。
记忆要点：因为interval list已经是排好序的了，核心就是顺序比较当前的interval和newInterval。主要分成两种情况：newInterval可以直接插入或者不确定。对于前者，就是newInterval.end<interval.start
 
 
 {% gist bf99b99cf26d9a231936748c89f96b69 57 Insert Interval.py %}
