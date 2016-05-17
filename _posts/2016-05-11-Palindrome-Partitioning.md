---
layout: post
author: delbao
title: Palindrome Partitioning I/II
tag: leetcode
---

dp的要点：dp数组本身还是表示前i个元素的palindrome partitioning，每次只更新中心点向右的，左边在之前已经计算好。
用上述dp解得I的错误点：
 
- j要从0开始，对于奇数，表示单个字符本身也是palindrome，对于偶数，i是左边第一个字符
- 因为已经有了单个字符，不要像II（mincut）那样用单个字符初始化dp，这样会重复或者对大sizeTLE
 
 {% gist 13c5f3b9019cdee93982c8148d34c2f2 %}
 
 {% gist 93ec55e89dfa7bdfcd300f204b2e724f %}
