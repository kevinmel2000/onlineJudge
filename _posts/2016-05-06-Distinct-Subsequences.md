---
layout: post
author: delbao
title: Distinct Subsequences
tag: leetcode
---

2d dp，要点：
 
- 这种序列的题，dp的size都是index+1，因为初始值都是从空序列开始的。同时空序列是边界条件，不符合递归式。
- 这题s和t是非对称的。t[j]表示前j个必须满足，所以递归式只依赖于s[i-1]
 
 {% gist b25df1137ca712d321a2b48688161174 %}
