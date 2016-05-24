---
layout: post
author: delbao
title: Count Primes 
tag: leetcode
---

要点：sieve of eratosthenes: 两层loop在区间里统计上去。如果已知一个prime，在内层loop可以进一步证伪在区间内从这个prime开始的其他数，凡是so far没有被证伪的，都可以确认为prime（外层loop）。
错误点
 
- 外层loop只需要到sqrt(n-1)，因为质因子都是对称的。另外用x*x<n做invariant而不要直接和x<sqrt(n-1)比较
- count要在另一个loop里

{% gist bf99b99cf26d9a231936748c89f96b69 204 Count Primes.py %}

