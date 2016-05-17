---
layout: post
author: delbao
title: Scramble String
tag: leetcode
---

这题其实用递归可以不TLE的，主要是有些预判可以剪枝，3d dp的方法就有点繁琐了。
 
- 剪枝1：两个string length不相同，返回False
- 剪枝2：两个string相同，直接返回True
- 剪枝3：两个string排序，不相同返回False

{% gist 2e022488549662d0400d443c55b839d7 %}
