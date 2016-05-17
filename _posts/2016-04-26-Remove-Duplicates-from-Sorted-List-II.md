---
layout: post
author: delbao
title: Remove Duplicates from Sorted List II
tag: leetcode
---

要点：在内外两层循环，inner loop用来判断当前点是否有重复，outer loop找下一个判断点。在inner loop单用一个指针是不够的，需要用两个指针，一个沿着重复点移动，一个记录初始点，最后比较是否有移动来判断是否有重复。
错误点：
 
- pre在有重复的情况下要next设为None，否则最后一组重复点还会连着

{% gist e6071154e048470290d2a60f045bb5a0 %}
