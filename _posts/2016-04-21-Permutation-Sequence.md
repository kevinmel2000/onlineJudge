---
layout: post
author: delbao
title: Permutation Sequence
tag: leetcode
---

原理：一个permutation是n位，在第i位的值取决于有多少个i-1位的组合。这i-1位的组合是在高位pick完之后剩下的数中
细节：
 
- 不同于decimal，位数是固定的，所以不能用k>0作为循环条件（这样只会选择某几位），而是用for循环。
- 当i=0的时候，要选取最后一个位，但factorial不能再除了i了，所以这里要加corner的判断

{% gist bf99b99cf26d9a231936748c89f96b69 60 Permutation Sequence.py %}
