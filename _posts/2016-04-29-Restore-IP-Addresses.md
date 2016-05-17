---
layout: post
author: delbao
title: Restore IP Addresses
tag: leetcode
---

要点：典型的backtrack的题，但是不同的是有一些限制条件可以剪枝。
 
- start>=n是中止条件，而层数是成功条件
- 因为要计算剩余位的长度来剪枝，所以层数在递归中应该是递减的。这样条件就是个数在层数*3和层数*1之间。
- 1位，2位，3位写成三个并行的情况，每个都进一步dfs
 
错误点：
 
- 不论是2位还是3位，只要检查leading不是0即可，比如001，检查leading 0就可以了，其他位不是检查条件。
- 3位要检查不能超过255
- 注意长度的计算：n不是最后的index，所以长度为n-start

{% gist 3d3dc76adcd82065b7c2bdc5f06f2d54 %}
