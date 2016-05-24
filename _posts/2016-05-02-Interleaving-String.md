---
layout: post
author: delbao
title: Interleaving String
tag: leetcode
---

这题首先要问的是为什么需要dp呢？如果s1和s2中没有duplicate，那么每次的选择就是唯一的 。但是s1和s2要保持和s3中的order，如果有duplicate并任意选择匹配，另一个数组中可匹配的元素就会被重复元素block住。比如s1=“aa”，s2=“ab”，s3=“aaba"。
 
- 注意这类涉及长度的dp都要从0开始，这个方便初始化
- 这题可以把空间降为线性的，用rolling array的方法，因为从dependency graph来看，当前dp元素依赖于本层的前一个和上层的同一位置：本层的前一个已经计算好了，而上层的同一位置在当前元素后不再需要，可以被当前元素取代。很多2d dp都可以类似的方法减少空间。
 
错误点
 
- s1的index为i-1，s2的index为j-1，那么对应的s3中的index为i+j-1，而不是i+j-2

{% gist bf99b99cf26d9a231936748c89f96b69 97 Interleaving String.py %}
