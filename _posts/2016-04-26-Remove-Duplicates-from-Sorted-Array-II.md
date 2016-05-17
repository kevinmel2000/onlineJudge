---
layout: post
author: delbao
title: Remove Duplicates from Sorted Array II
tag: leetcode
---

错误点
 
- 不能swap，而是要只把后面的元素取代前面的。swap将破坏nums[i]!=nums[i-1] check
- [ ] 要特殊处理，返回0。因为。。。

{% gist fd94dadf500290614a899674034f785f %}
