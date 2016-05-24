---
layout: post
author: delbao
title: Binary Tree Maximum Path Sum
tag: leetcode
---

错误点：negative也可能是最大值，所以global maxVal初始值为INT_MIN。但是左右传上来的一侧值（left or right）一定要先和0比较再加到local maxVal做比较，因为如果left or right是negative，那么root可以选择不用。
 
 {% gist bf99b99cf26d9a231936748c89f96b69 124 Binary Tree Maximum Path Sum.py %}
