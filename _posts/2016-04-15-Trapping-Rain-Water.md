---
layout: post
author: delbao
title: Trapping Rain Water 
tag: leetcode
---

要点：很多题都是这种pattern，就是根据限定条件从两边扫描，然后比较取最终值，注意leetcode的靠前的难题到现在其实就是简单题。
错误点：
 
- left数组中第i个存的一定是在对应i这个点的左边值，而不是在i-1存这个值，所以在边界上是0
- 用和原数组同样长度的数组存left，别为省没意义的空间增加程序的复杂性
 
 {% gist 8e0d11a1ebf1e3d1a32ba183d188fa91 %}
