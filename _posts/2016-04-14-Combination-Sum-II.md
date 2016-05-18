---
layout: post
author: delbao
title: Combination Sum II 
tag: leetcode
---

要点
错误点：
 
- 对于unlimited那题，因为不可能有负数和正数（这样会出现无限解），所以target<0是失败条件
- 因为已经排好序了，所以target==0以后就应该return
- 注意next的index是i而不是start，这个很容易错写成start，另外unlimited这题是可重用的，所以仍然从当前的i开始
- 这题本身指明都为正数，如果不target<0 return会TLE，实际对于limited这题，有负数也是可以做的

{% gist 6f92c83b10a0a2dc56b5b521f1085b5e %}
