---
layout: post
author: delbao
title: Minimum Size Subarray Sum
tag: leetcode
---

要点：O(n)解的基本方法是sliding window，loop到第i个元素表示的值是结尾在i的元素最长序列。所以进入loop首先加上该元素。然后从左边pop
错误点：左边pop是一个while loop而不是仅pop一个元素：可能有一堆小元素进入window，当前元素很大，所以所有之前的小元素都pop也能满足条件

{% gist 16748ca2627e1e48ac8bc98bec9c311a %}
