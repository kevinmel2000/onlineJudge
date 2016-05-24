---
layout: post
author: delbao
title: Remove Duplicates from Sorted Array II
tag: leetcode
---

错误点
 
- 不能swap，而是要只把后面的元素取代前面的。swap将破坏nums[i]!=nums[i-1] check
- [ ] 要特殊处理，返回0。因为。。。

{% gist bf99b99cf26d9a231936748c89f96b69 80 Remove Duplicates from Sorted Array II.py %}
