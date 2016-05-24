---
layout: post
author: delbao
title: Super Ugly Number
tag: leetcode
---

这题和名字一样恶心。逻辑不好想，也可能我是天生对数的结构不太敏感。但是算法结构很简单，所以建议最好背答案
结构：
 
- 维护一个数组：记录每个prime的当前指针，下一个数就是最小的prime指向的数和其乘积。
- 有可能多个prime都对应min，比如3X5和5X3，所以在判断min后再loop一遍primes来移动指针

{% gist bf99b99cf26d9a231936748c89f96b69 13 Super Ugly Number.py %}
