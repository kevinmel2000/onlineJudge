---
layout: post
author: delbao
title: generate parentheses 
tag: leetcode
---

思路：递归，def generateRec(n, diff, res, solutions): n: 待生成的左右括号组，diff：左右括号的个数差，遵循单向recursion的基本模式即可

{% gist bf99b99cf26d9a231936748c89f96b69 22 generate parentheses.py %}
