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

{% gist e4875643390861dd2f588daa83af80b9 %}

{% gist d7a06498668ec304843b4b3627089349 %}
