---
layout: post
author: delbao
title: Group Anagrams
tag: leetcode
---

在当下绝对是简单题了，uber考过要求不用sort string实现，可以统计字符个数encode。比如aabd=a2b1d1，用数组表示hash表。这题python实现有个catch，因为input是strs，很容易用str作为单个string的表示。这样hide了str()函数，报错：TypeError: 'unicode' object is not callable
 
 {% gist bf99b99cf26d9a231936748c89f96b69 49 Group Anagrams.py %}
