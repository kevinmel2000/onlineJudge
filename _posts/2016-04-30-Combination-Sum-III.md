---
layout: post
author: delbao
title: Combination Sum III
tag: leetcode
---

这题似乎没什么玄机，和I/II思路类似，而且更简单：输入集合没有重复元素（所以不用考虑duplicate），一个数也不能用多次（所以下层recursion start+1)。
错误点：因为失败返回的条件比较多(len(res)>k or sum<0)，start>9也有可能成功，所以成功条件要在失败之前。否则，有效结果中包含9的解会被漏掉。

{% gist bf99b99cf26d9a231936748c89f96b69 216 Combination Sum III.py %}
