---
layout: post
author: delbao
title: Path Sum I/II
tag: leetcode
---

同上，preorder搞定。这题竟然犯了2个错误。
错误点
 
- pop不能发生在入左右子树之后
- 每个节点对应的sum值是减去该节点的val，所以root初始要减去val
 
II用递归做的。递归里，root不为None，而且在外层更新sum，内层只是中止条件判断（sum为0，左右为空）

{% gist bf99b99cf26d9a231936748c89f96b69  112 Path Sum I.py %}

{% gist bf99b99cf26d9a231936748c89f96b69  113 Path Sum II.py %}
