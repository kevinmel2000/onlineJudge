---
layout: post
author: delbao
title: Single Number I/II
tag: leetcode
---

II的python解是网上抄的，其实可以AC，但是python不会像c++/java那样自动overflow，而是转化成long。所以如果有负数的情况会得到一个巨大的正数解，比如
 
Input:[-2,-2,1,1,-3,1,-3,-3,-4,-2]
 
Output:4294967292
 
Expected:-4

{% gist bf99b99cf26d9a231936748c89f96b69 136-Single-Number-I.py %}

{% gist bf99b99cf26d9a231936748c89f96b69  137 Single Number II.py %}
