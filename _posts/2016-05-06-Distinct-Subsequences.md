---
layout: post
author: delbao
title: Distinct Subsequences
tag: leetcode
---

2d dp，要点：
 
- 这种序列的题，dp的size都是index+1，因为初始值都是从空序列开始的。同时空序列是边界条件，不符合递归式。
- 这题s和t是非对称的。t[j]表示前j个必须满足，所以递归式只依赖于s[i-1]
 
 {% gist bf99b99cf26d9a231936748c89f96b69  115 Distinct Subsequences.py %}
