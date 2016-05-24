---
layout: post
author: delbao
title: Rotate List
tag: leetcode
---

错误点
 
- 因为开始要计算结点数，要遍历list，所以顺便先把tail和head连上
- 因为指针最后要落在最后一个list结点，所以移动n-1步，初始的步数为1（即开始已经计入head）。同理，第二次移动n-k-2步到新head的前一个结点，断开
- n-k%n!=(n-k)%n，比如n=2, k=2 n-k%n=2, (n-k)%n=0

{% gist bf99b99cf26d9a231936748c89f96b69 61 Rotate List.py %}
