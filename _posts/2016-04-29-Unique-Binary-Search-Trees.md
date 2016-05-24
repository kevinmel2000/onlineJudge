---
layout: post
author: delbao
title: Unique Binary Search Trees I/II
tag: leetcode
---

要点： structurally unique的内涵是什么？输出所有组合时的编号如何处理
 
- 对于II，因为需要输出所有，不同区间的输出是不同的。所以要iterate所有区间，在每个区间内，需要用catalan number的iteration方式loop所有点作为root。无论是dp或者memoization，思路类似。
- 注意这题和Burst Balloons类似，不是单向dp，需要用长度作为outer loop
- 这题还有个tricky的地方：因为左右子树可能为null，在loop root和左右子树集合的时候，如何把null也包含到左右子树集合里？如果以长度作为dp的一维，可以把0作为一项，这里左右子树对应的是只有一个元素null的集合。
    - 当然也可以对左右子树为null的情况特殊处理，这里一个小技巧是判断是否k和左右边界相同，相同则建一个只有null的集合[null]，这样和iterate左右子树集合的code一致了。
 
I: dp
 
- 一类dp的代表，dp每个元素表示前i个结点的bst个数。对i个结点中的每一个点，作为root累积个数。
- 因为有null可能为左/右子树，所以dp的长度为n+1
- 左右子树结点个数的计算：i即表示结点个数，也表示以1初始的子树index，所以可以通过index计算其左右子树个数（这个是这题最不容易记住的地方，因为通常都是index比个数小1）

{% gist bf99b99cf26d9a231936748c89f96b69  96 Unique Binary Search Trees.py %}

{% gist bf99b99cf26d9a231936748c89f96b69  95 Unique Binary Search Trees II.py %}
