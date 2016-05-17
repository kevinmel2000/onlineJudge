---
layout: post
author: delbao
title: N-Queens II
tag: leetcode
---

如果和N-Queens I一样用dfs的方法，注意因为python或者java是pass by value，所以用返回值返回count。这里如何返回和累加容易搞混：因为dfs是树形结构，所以只在找到一个结果后（或者leaf结点）返回1，上层做累加，直到return back到顶层。
 
不过这题据说还有更精妙的方法，求知道的童鞋给提示。

{% gist 1fcef1fb364e8c97d6cbe051a43519a8 %}
