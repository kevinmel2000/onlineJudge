---
layout: post
author: delbao
title: Maximum Subarray
tag: leetcode
---

 
- O(n) solution：local解的核心就是判断是否从当前元素重新开始。如果前一个local值<0，那么要从这个元素开始。
- divide and conquer：两点
    - 包含中间点的最长序列的计算：向左右两方向延伸，不断更新最大值，最差情况是遍历所有元素，O(n)。注意最小值是0，而不是INT_MIN：空序列是0，所以不用担心会有负数结果。如果用INT_MIN，不更新的情况不是得到0
    - recursion：这类递归和merge sort类似结构，值得注意的是边界条件。另外如果递归是(low, m), (m+1, high)，那么注意无限循环因为1个或者2个元素m总是在第一个元素不变。递归也可能是(low,m-1),(m+1,high)。所以前者边界里包含low==high，后者边界要包含low>high
    
{% gist bf99b99cf26d9a231936748c89f96b69 53 Maximum Subarray.py %}    
  
